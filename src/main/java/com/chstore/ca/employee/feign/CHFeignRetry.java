package com.chstore.ca.employee.feign;

import feign.RetryableException;
import feign.Retryer;

public class CHFeignRetry implements Retryer {

    private final int maxAttempts;
    private final long backoff;
    int attempt;

    public CHFeignRetry() {
        this(2000, 3);
    }

    public CHFeignRetry(long backoff, int maxAttempts) {
        this.backoff = backoff;
        this.maxAttempts = maxAttempts;
        this.attempt = 1;
    }

    public void continueOrPropagate(RetryableException e) {
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
        return new CHFeignRetry(backoff, maxAttempts);
    }
}