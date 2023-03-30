package com.switchfully.eurder.customers.api;

import com.switchfully.eurder.customers.domain.CreatingCustomer;
import com.switchfully.eurder.customers.domain.CustomerDto;
import com.switchfully.eurder.customers.domain.Feature;
import com.switchfully.eurder.customers.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
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
    public List<CustomerDto> getCustomers(@RequestHeader String authorization){
        String authorizationDecoded = decode(authorization);
        service.validateAuthorization(authorizationDecoded, Feature.GET_ALL_CUSTOMERS);
        return service.getAllCustomers();
    }
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto addCustomer(@RequestBody CreatingCustomer creatingCustomer){
        return service.addCustomer(creatingCustomer);
    }
    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomerById(@PathVariable String id, @RequestHeader String authorization){
        String authorizationDecoded = decode(authorization);
        service.validateAuthorization(authorizationDecoded, Feature.GET_DETAILS_CUSTOMER);
        return service.getCustomerById(id);
    }

    private String decode(String authorization) {
        String decodedAuthorization = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        return decodedAuthorization.substring(0, decodedAuthorization.length() - 1);
    }

}
