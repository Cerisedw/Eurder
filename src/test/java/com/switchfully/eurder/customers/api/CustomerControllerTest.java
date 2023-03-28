package com.switchfully.eurder.customers.api;

import com.switchfully.eurder.customers.domain.*;
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
    @Test
    void givenCreatingCustomer_WhenAddCustomerCall_ThenAddCustomerToDataBase(){
        //GIVEN
        CreatingCustomer creatingCustomer = new CreatingCustomer("Nice", "Death", "deathcorp@gmail.com",
                new Address("deathstreet 2", "Somewhere", "666"), "55566612");
        //WHEN
        CustomerDto customerAdded = controller.addCustomer(creatingCustomer);
        //THEN
        Assertions.assertThat(database.getCustomers()).contains(mapper.dtoToCustomerKeepingId(customerAdded));
    }
}