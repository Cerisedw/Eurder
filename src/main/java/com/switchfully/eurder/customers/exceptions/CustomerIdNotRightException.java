package com.switchfully.eurder.customers.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


import static java.lang.String.format;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class CustomerIdNotRightException extends RuntimeException{
    public CustomerIdNotRightException(String id) {
        super(format("Customer %s is not the right customer to do that", id));
        Logger logger = LoggerFactory.getLogger(CustomerIdNotRightException.class);
        logger.error(format("Customer %s is not the right customer to do that", id));
    }
}
