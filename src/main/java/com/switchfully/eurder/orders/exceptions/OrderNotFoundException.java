package com.switchfully.eurder.orders.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String id) {
        super(String.format("Order not found %s", id));
        Logger logger = LoggerFactory.getLogger(OrderNotFoundException.class);
        logger.error(format("Order not found %s", id));
    }
}
