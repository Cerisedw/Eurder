package com.switchfully.eurder.customers.repository;

import com.switchfully.eurder.customers.domain.Address;
import com.switchfully.eurder.customers.domain.Customer;
import com.switchfully.eurder.customers.domain.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDatabase {
    private final List<Customer> customers;

    public CustomerDatabase() {
        this.customers = new ArrayList<>();
        populateDataBase();
    }
    private void populateDataBase(){
        customers.addAll(List.of(
                new Customer("Elfy", "Dragu", "elfy@gmail.com",
                        new Address("street a 76", "Bruxelles", "1000"),
                        "0455633221", Role.ADMIN),
                new Customer("Max", "Goat", "max@gmail.com",
                        new Address("street b 81", "LA", "14500"),
                        "0444877441", Role.MEMBER),
                new Customer("Manta", "Ray", "manta-ray@gmail.com",
                        new Address("street c 42", "Namur", "5080"),
                        "0432585228", Role.MEMBER)
        ));
    }

    public List<Customer> getCustomers() {
        if(customers == null  || customers.isEmpty()) return new ArrayList<>();
        else return customers;
    }
}