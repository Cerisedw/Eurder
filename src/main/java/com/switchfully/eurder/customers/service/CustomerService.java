package com.switchfully.eurder.customers.service;

import com.switchfully.eurder.customers.domain.CustomerDto;
import com.switchfully.eurder.customers.domain.CustomerMapper;
import com.switchfully.eurder.customers.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
