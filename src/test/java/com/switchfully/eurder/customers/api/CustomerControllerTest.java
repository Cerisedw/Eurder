package com.switchfully.eurder.customers.api;

import com.switchfully.eurder.customers.domain.Customer;
import com.switchfully.eurder.customers.domain.CustomerDto;
import com.switchfully.eurder.customers.domain.CustomerMapper;
import com.switchfully.eurder.customers.repository.CustomerDatabase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerControllerTest {
    @Autowired
    private CustomerController controller;
    @Autowired
    private CustomerDatabase database;
    @Autowired
    private CustomerMapper mapper;
    @Test
    void whenGetAllCustomersCall_ThenReturnListOfCustomersDto(){
        //GIVEN
        List<CustomerDto> customersFromDB = mapper.listCustomersToListDto(database.getCustomers());
        //WHEN
        List<CustomerDto> customersFromController = controller.getCustomers();
        //THEN
        Assertions.assertThat(customersFromDB).hasSameElementsAs(customersFromController);
    }
}