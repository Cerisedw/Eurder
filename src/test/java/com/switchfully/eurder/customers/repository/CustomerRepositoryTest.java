package com.switchfully.eurder.customers.repository;

import com.switchfully.eurder.customers.domain.Address;
import com.switchfully.eurder.customers.domain.Customer;
import com.switchfully.eurder.customers.domain.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepository repo;
    @Autowired
    private CustomerDatabase database;
    @Test
    void whenCallingRepositoryGetAllMethod_ThenShouldReturnNotEmptyListOfCustomers(){
        //WHEN
        List<Customer> customersFromRepo = repo.getAll();
        //THEN
        Assertions.assertThat(customersFromRepo).isNotEmpty();
    }
    @Test
    void givenACustomer_WhenCallingRepositoryAddCustomerMethod_ThenNewCustomerShouldBeInDataBase(){
        //GIVEN
        Customer customerToAdd = new Customer("Sipho", "Nophore", "zooids@gmail.com",
                new Address("rue deepsea 15", "2050", "Atlantique"), "0544955119", Role.MEMBER);
        //WHEN
        repo.addCustomer(customerToAdd);
        //THEN
        Assertions.assertThat(database.getCustomers()).contains(customerToAdd);
    }
    @Test
    void givenAnId_WhenCallingRepositoryGetCustomerById_ThenShouldReturnNotNullCustomer(){
        //GIVEN
        String id = "1";
        //WHEN
        Customer customerReturnedByRepo = repo.getCustomerById(id);
        //THEN
        Assertions.assertThat(customerReturnedByRepo).isNotNull();
    }
    @Test
    void givenAnId_WhenCallingRepositoryGetCustomerById_ThenShouldReturnSameCustomerAsInDB(){
        //GIVEN
        String id = "1";
        //WHEN
        Customer customerReturnedByRepo = repo.getCustomerById(id);
        Customer customerReturnedByDB = database.getCustomers().stream()
                .filter(c->c.getId() == Long.parseLong(id)).findFirst().orElseThrow();
        //THEN
        Assertions.assertThat(customerReturnedByDB).isEqualTo(customerReturnedByRepo);
    }
}
