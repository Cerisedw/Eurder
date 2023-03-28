package com.switchfully.eurder.customers.service;

import com.switchfully.eurder.customers.domain.*;
import com.switchfully.eurder.customers.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    private CustomerService service;
    @Autowired
    private CustomerRepository repo;
    @Autowired
    private CustomerMapper mapper;
    @Test
    void whenCallingServiceGetAllCustomersMethod_ThenShouldReturnNotEmptyListOfCustomersDto(){
        //WHEN
        List<CustomerDto> customersFromRepo = service.getAllCustomers();
        //THEN
        Assertions.assertThat(customersFromRepo).isNotEmpty();
    }
    @Test
    void givenACreatingCustomer_WhenCallingServiceAddCustomerMethod_ThenShouldAddCustomerToDB(){
        //GIVEN
        CreatingCustomer customerToAdd = new CreatingCustomer("Sipho", "Nophore", "zooids@gmail.com",
                new Address("rue deepsea 15", "2050", "Atlantique"), "0544955119");
        //WHEN
        CustomerDto customerAdded = service.addCustomer(customerToAdd);
        //THEN
        Assertions.assertThat(repo.getAll()).contains(mapper.dtoToCustomerKeepingId(customerAdded));
    }
}
