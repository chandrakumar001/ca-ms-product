package com.chstore.ca.employee;

import com.chstore.ca.ms.error.CustomerNotFoundException;

public class CommonException {

    public static void fieldValidationException(String errorMsg) {
        throw new CustomerNotFoundException(errorMsg);
    }
}
