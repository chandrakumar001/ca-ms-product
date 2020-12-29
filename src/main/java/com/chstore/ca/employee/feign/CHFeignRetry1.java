package com.chstore.ca.employee.feign;

import feign.RetryableException;
import feign.Retryer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//@Configuration
//@ConfigurationProperties(prefix = "comtest")
//@PropertySource(
//        factory = YamlPropertySourceFactory.class,
//        value = "classpath:application-feign.yml",
//        ignoreResourceNotFound = true
//)
public class CHFeignRetry1 implements Retryer {

    private static final int DEFAULT_ATTEMPT = 1;

    private final int maxAttempts;
    private final long backoff;
    int attempt;

    public CHFeignRetry1(long backoff,
                         int maxAttempts) {
        this.backoff = backoff;
        this.maxAttempts = maxAttempts;
        this.attempt = DEFAULT_ATTEMPT;
    }

    public void continueOrPropagate(final RetryableException e) {

        if (attempt++ >= maxAttempts) {
            throw e;
        }

        try {
            Thread.sleep(backoff);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public Retryer clone() {
        return new CHFeignRetry1(backoff, maxAttempts);
    }
}