package com.switchfully.eurder.customers.repository;

import com.switchfully.eurder.customers.domain.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {
    private final CustomerDatabase database;

    public CustomerRepository(CustomerDatabase database) {
        this.database = database;
    }
    public List<Customer> getAll(){
        return database.getCustomers();
    }
    public Customer addCustomer(Customer customer){
        database.getCustomers().add(customer);
        return customer;
    }
}
