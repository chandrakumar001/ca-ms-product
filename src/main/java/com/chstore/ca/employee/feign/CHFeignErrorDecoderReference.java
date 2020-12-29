package com.chstore.ca.employee.feign;


import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.Objects;

public class CHFeignErrorDecoderReference implements ErrorDecoder {

    // refers: https://blog.wick.technology/sensible-feign/
    private final ErrorDecoder defaultDecoder = new Default();
    private static final Logger LOGGER = LoggerFactory.getLogger(CHFeignErrorDecoderReference.class);

    @Override
    public Exception decode(final String methodKey,
                            final Response response) {

        System.out.println("Called decode");
        //Requirement 5: log error first and include response body
        try {
            LOGGER.error("Got {} response from {}, response body: {}",
                    response.status(),
                    methodKey,
                    IOUtils.toString(response.body().asReader()));
        } catch (IOException e) {
            LOGGER.error("Got {} response from {}, response body could not be read",
                    response.status(), methodKey);
        }

        final Request.HttpMethod httpMethod = response.request().httpMethod();

        final Exception defaultException = defaultDecoder.decode(methodKey, response);

        if (defaultException instanceof RetryableException) {
            //Requirement 3: retry when Retry-After header is set
            //Will be true if Retry-After header is set e.g. in case of 429 status
            return defaultException;
        }

        if (HttpStatus.valueOf(response.status()).is5xxServerError()) {

            //Requirement 1: retry on server error
           /* if (httpMethod.equals(Request.HttpMethod.GET)) {
                return new RetryableException(
                        "Internal Server error",
                        httpMethod,
                        new CausingSystemException(response.reason(), defaultException),
                        null
                );
            }*/
            LOGGER.error(
                    "Got {} response from {}",
                    response.status(),
                    methodKey
            );
        }

        if (HttpStatus.valueOf(response.status()).is5xxServerError()
                || HttpStatus.valueOf(response.status()).is4xxClientError()) {
            final Response.Body body = response.body();
            if (Objects.isNull(body)) {

            }

            ErrorResponse error = null;

            // check and extract when it is an ErrorResponse
            try {
                final ObjectMapper mapper = new ObjectMapper();
                error = mapper.readValue(body.asReader(), ErrorResponse.class);
                if (error != null) {
                    throw createCHExecutionException(error, null);
                }

            } catch (final IOException | CHExecutionException e) {
                LOGGER.trace("The exception received,invalid format");
            }
        }
        //Requirement 4: return 500 on client error
        return new RuntimeException();
    }

    private static CHExecutionException createCHExecutionException(final ErrorResponse error,
                                                                   final HttpStatus httpstatus) {

        final SystemError systemError = SystemError.of(
                error.getSystem(),
                error.getCode(),
                error.getMessage(),
                httpstatus
        );
        return new CHExecutionException(error.getCode(), error.getMessage());
    }

    private static void serviceLogs(final String service,
                                    final String operation,
                                    final String result) {
        LOGGER.info("External System Service Call consumer=CA-Apps system= service={} operation={} result={}",
                service, operation, result);
    }
}