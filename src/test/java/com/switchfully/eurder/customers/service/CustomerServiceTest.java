package com.switchfully.eurder.customers.service;

import com.switchfully.eurder.customers.domain.Customer;
import com.switchfully.eurder.customers.domain.CustomerDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    private CustomerService service;
    @Test
    void whenCallingServiceGetAllCustomersMethod_ThenShouldReturnNotEmptyListOfCustomersDto(){
        //WHEN
        List<CustomerDto> customersFromRepo = service.getAllCustomers();
        //THEN
        Assertions.assertThat(customersFromRepo).isNotEmpty();
    }

}
