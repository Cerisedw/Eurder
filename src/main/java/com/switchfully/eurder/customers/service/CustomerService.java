package com.switchfully.eurder.customers.service;

import com.switchfully.eurder.customers.domain.*;
import com.switchfully.eurder.customers.exceptions.CustomerNotFoundException;
import com.switchfully.eurder.customers.exceptions.UnauthorizatedException;
import com.switchfully.eurder.customers.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository repo;
    private final CustomerMapper mapper;

    public CustomerService(CustomerRepository repo, CustomerMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
    public List<CustomerDto> getAllCustomers(){
        return mapper.listCustomersToListDto(repo.getAll());
    }
    public CustomerDto addCustomer(CreatingCustomer creatingCustomer){
        Customer customerAdded = repo.addCustomer(mapper.creatingCustomerToCustomer(creatingCustomer));
        return mapper.customerToDto(customerAdded);
    }
    public CustomerDto getCustomerById(String id){
        return mapper.customerToDto(repo.getCustomerById(id));
    }

    public void validateAuthorization(String authorization, Feature feature) {
        try {
            Customer customer = repo.getCustomerById(authorization);
            if (!customer.hasAccessTo(feature)) {
                throw new UnauthorizatedException(authorization, feature);
            }
        }catch(CustomerNotFoundException e){
            throw new CustomerNotFoundException(authorization);
        }
    }

}
