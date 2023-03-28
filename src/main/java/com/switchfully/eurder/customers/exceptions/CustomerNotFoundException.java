package com.switchfully.eurder.customers.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

import static java.lang.String.format;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String id) {
        Logger logger = LoggerFactory.getLogger(CustomerNotFoundException.class);
        logger.error(format("Customer not found %s", id));
    }
}
