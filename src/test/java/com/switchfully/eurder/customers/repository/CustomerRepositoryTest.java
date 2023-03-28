package com.switchfully.eurder.customers.repository;

import com.switchfully.eurder.customers.domain.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository repo;
    @Test
    void whenCallingRepositoryGetAllMethod_ThenShouldReturnNotEmptyListOfCustomers(){
        //WHEN
        List<Customer> customersFromRepo = repo.getAll();
        //THEN
        Assertions.assertThat(customersFromRepo).isNotEmpty();
    }
}
