package com.chstore.ca.employee.feign;

import feign.RetryableException;
import feign.Retryer;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CHFeignRetryTest implements Retryer {

    private final int maxAttempts;
    private final long backoff;
    int attempt;

    public CHFeignRetryTest(long backoff, int maxAttempts) {
        this.backoff = backoff;
        this.maxAttempts = maxAttempts;
        this.attempt = 1;
    }

    public void continueOrPropagate(RetryableException e) {
        System.out.println("Retry-----" + attempt);
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
        return new CHFeignRetryTest(backoff, maxAttempts);
    }
}