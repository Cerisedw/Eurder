package com.switchfully.eurder.items.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String id) {
        super(String.format("Item not found %s", id));
        Logger logger = LoggerFactory.getLogger(ItemNotFoundException.class);
        logger.error(format("Item not found %s", id));
    }
}
