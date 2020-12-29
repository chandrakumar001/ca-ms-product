package com.chstore.ca.employee.feign;


import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Request;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.Objects;

public class CHFeignErrorDecoder implements ErrorDecoder {

    // refers: https://blog.wick.technology/sensible-feign/
    private final ErrorDecoder defaultDecoder = new Default();
    private static final Logger LOGGER = LoggerFactory.getLogger(CHFeignErrorDecoder.class);

    @Override
    public Exception decode(final String methodKey,
                            final Response response) {

        final String url = response.request().url();
        final Request.HttpMethod httpMethod = response.request().httpMethod();
        final Exception defaultException = defaultDecoder.decode(methodKey, response);

        serviceLogs(url, httpMethod.name(), response.body().toString());

        ErrorResponse error;
        // check and extract when it is an ErrorResponse
        try {
            final ObjectMapper mapper = new ObjectMapper();
            error = mapper.readValue(response.body().asReader(), ErrorResponse.class);
            if (error != null) {

            }
        } catch (final IOException e) {
            LOGGER.trace("The exception received,invalid format");
        }

        if (defaultException instanceof RetryableException) {
            return defaultException;
        }

        if (HttpStatus.valueOf(response.status()).is5xxServerError()) {

            //Requirement 1: retry on server error
            if (httpMethod.equals(Request.HttpMethod.GET)) {
                /*return new RetryableException(
                        "Internal Server error",
                        httpMethod,
                        new CausingSystemException(response.reason(), defaultException),
                        null
                );*/
            }
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
        }
        return new RuntimeException();
        //Requirement 4: return 500 on client error
        //return new ClientErrorResponseFromOtherSystemException("Client error " + response.status() + " from calling other system", defaultException);
    }

    private static void serviceLogs(final String service,
                                    final String operation,
                                    final String result) {
        LOGGER.info("External System Service Call consumer=CA-Apps system= service={} operation={} result={}",
                service, operation, result);
    }
}