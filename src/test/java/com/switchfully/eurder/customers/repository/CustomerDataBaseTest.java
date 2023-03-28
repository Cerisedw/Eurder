package com.switchfully.eurder.customers.repository;

import com.switchfully.eurder.customers.domain.Address;
import com.switchfully.eurder.customers.domain.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CustomerDataBaseTest {
    @Autowired
    private CustomerDatabase database;
    @Test
    void whenCallingDataBaseGetCustomersMethod_ThenShouldReturnNotEmptyListOfCustomers(){
        //WHEN
        List<Customer> customersFromDB = database.getCustomers();
        //THEN
        Assertions.assertThat(customersFromDB).isNotEmpty();
    }
}
