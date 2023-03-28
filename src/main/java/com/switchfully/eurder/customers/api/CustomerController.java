package com.switchfully.eurder.customers.api;

import com.switchfully.eurder.customers.domain.CustomerDto;
import com.switchfully.eurder.customers.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "customers")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping(produces ="application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getCustomers(){
        return service.getAllCustomers();
    }
}
