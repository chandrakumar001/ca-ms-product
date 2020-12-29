package com.chstore.ca.employee.feign;

import com.chstore.ca.ms.tracking.CHRequestContext;
import feign.Logger.Level;
import feign.Request.Options;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Retryer;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static feign.Logger.Level.BASIC;

@Slf4j
@Configuration
public class CHFeignAutoConfig {

    @Autowired
    CHRequestContext chRequestContext;

    /**
     * Logging levels are BASIC, FULL, HEADERS, NONE
     *
     * @return
     */
    @Bean
    public Level configureLogLevel() {
        return BASIC;
    }

    /**
     * Request.Options allows you to configure the connection and
     * read timeout values that will be used by the client for each
     * request
     *
     * @return Request.Options
     */
    @Bean
    public Options timeoutConfiguration() {

        return new Options(0, 0);
    }

    /**
     * Request interceptor adds HTTP header for basic auth
     * using the values supplied
     *
     * @return
     */
  /* @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {

        return new BasicAuthRequestInterceptor("user", "password");
    }*/

    /**
     * An example of a custom RequestInterceptor. In this instance we
     * add a custom header. This is a common enough use case for a
     * request header
     *
     * @return RequestInterceptor
     */
/*
    @Bean
    public RequestInterceptor headerRequestInterceptor() {

        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate requestTemplate) {
                System.out.println("Called Interceptor"+chRequestContext.getJwt());
                System.out.println("Called Interceptor end");
            }
        };
    }*/

   /* @Bean
    public RequestInterceptor headerRequestInterceptor() {

        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {

                log.info("Adding header [testHeader / testHeaderValue] to request");
                template.header("testHeader", "testHeaderValue");
            }
        };
    }*/
    @Bean
    public RequestInterceptor headerRequestInterceptor(final CHRequestContext chRequestContext) {
        return new CHFeignInterceptor(chRequestContext);
    }


    /**
     * Default Retryer will retry 5 times, backing off (exponentially) between retries.
     * You can provide your own retry logic by implementing the Retry interface if you need
     * some specific behaviour.
     *
     * @return Retryer
     */
    @Bean
    public Retryer chFeignRetryTest() {
        return new CHFeignRetryTest(2000, 4);
    }

    @Bean
    public ErrorDecoder myErrorDecoder() {
        return new CHFeignErrorDecoder();
    }

   /* @Bean
    Feign chFeign(
            final CHFeignRetryTest retryer,
            final Options timeoutConfiguration,
            final Level configureLogLevel
    ) {

        return Feign.builder()
                .options(timeoutConfiguration)
                .logLevel(configureLogLevel)
                .retryer(retryer)
                .build()
                //  .contract(feignContract)
                // .encoder(new JacksonDecoder(mapper))
                // .decoder(new JacksonDecoder(mapper))
                ;
    }*/


/*    @Bean
    public CHFeignInterceptor myCHFeignInterceptor(final CHRequestContext chRequestContext) {
        return new CHFeignInterceptor(chRequestContext);
    }*/

   /* @Bean
    Feign chFeign(final CHFeignErrorDecoder myErrorDecoder,
                  final CHFeignRetryTest chFeignRetryTest,
                  final CHRequestContext chRequestContext
                  //final Request.Options feignOptions
    ) {

        return Feign.builder()
                //.options(feignOptions)
                .requestInterceptor(new CHFeignInterceptor(
                        chRequestContext
                ))
                .errorDecoder(new CHFeignErrorDecoder())
                .retryer(chFeignRetryTest)
                .build()
                //  .contract(feignContract)
                // .encoder(new JacksonDecoder(mapper))
                // .decoder(new JacksonDecoder(mapper))
                ;
    }*/
}