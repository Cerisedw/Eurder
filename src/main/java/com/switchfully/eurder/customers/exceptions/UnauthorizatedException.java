package com.switchfully.eurder.customers.exceptions;
import com.switchfully.eurder.customers.domain.Feature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.apache.logging.log4j.message.ParameterizedMessage.format;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizatedException extends RuntimeException {
    public UnauthorizatedException(String id, Feature feature) {
        super(String.format("Customer %s does not have access to %s", id, feature));
        Logger logger = LoggerFactory.getLogger(CustomerNotFoundException.class);
        logger.error(String.format("Customer %s does not have access to %s", id, feature));
    }
}
