package com.switchfully.eurder.customers.api;

import com.switchfully.eurder.customers.domain.*;
import com.switchfully.eurder.customers.exceptions.CustomerNotFoundException;
import com.switchfully.eurder.customers.repository.CustomerDatabase;
import com.switchfully.eurder.items.exceptions.ItemNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class CustomerControllerTest {
    @Autowired
    private CustomerController controller;
    @Autowired
    private CustomerDatabase database;
    @Autowired
    private CustomerMapper mapper;
    private String adminIdBasic;
    @BeforeEach
    void setup(){
        adminIdBasic = "Basic MT0=";
    }
    @Test
    void whenGetAllCustomersCall_ThenReturnListOfCustomersDto(){
        //GIVEN
        List<CustomerDto> customersFromDB = mapper.listCustomersToListDto(database.getCustomers());
        //WHEN
        List<CustomerDto> customersFromController = controller.getCustomers(adminIdBasic);
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
    @Test
    void givenId_WhenGetCustomerByIdCall_ThenReturnedCustomerDto(){
        //GIVEN
        String id = "1";
        //WHEN
        CustomerDto customerReturned = controller.getCustomerById(id, adminIdBasic);
        Customer customerFromDB = database.getCustomers().stream()
                .filter(c->c.getId() == Long.parseLong(id)).findFirst().orElseThrow();
        //THEN
        Assertions.assertThat(customerReturned).isNotNull();
        Assertions.assertThat(customerReturned).isEqualTo(mapper.customerToDto(customerFromDB));
    }
    @Test
    void CustomerNotFoundExceptionThrows(){
        assertThatThrownBy(() -> controller.getCustomerById("15545658", adminIdBasic))
                .isInstanceOf(CustomerNotFoundException.class);
    }

}