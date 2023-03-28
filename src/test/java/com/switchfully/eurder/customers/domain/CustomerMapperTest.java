package com.switchfully.eurder.customers.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerMapperTest {
    @Autowired
    private CustomerMapper mapper;
    private Customer customer1;
    private CreatingCustomer creatingCustomer1;
    @BeforeEach
    void setup(){
        customer1 = new Customer("Manta", "Ray", "manta-ray@gmail.com",
                new Address("street c 42", "Namur", "5080"), "0432585228");
        creatingCustomer1 = new CreatingCustomer("Sipho", "Nophore", "zooids@gmail.com",
                new Address("rue deepsea 15", "2050", "Atlantique"), "0544955119");
    }
    @Test
    void givenCustomer_WhenCallingCustomerToDTOMethod_ThenReturnCustomerDtoWithSameData(){
        //WHEN
        CustomerDto customerDto = mapper.customerToDto(customer1);
        //THEN
        Assertions.assertThat(customerDto).isInstanceOf(CustomerDto.class);
        assertEquals(customer1.getId(), customerDto.getId());
        assertEquals(customer1.getFirstName(), customerDto.getFirstName());
        assertEquals(customer1.getLastName(), customerDto.getLastName());
        assertEquals(customer1.getEmail(), customerDto.getEmail());
        assertEquals(customer1.getAddress(), customerDto.getAddress());
        assertEquals(customer1.getPhoneNumber(), customerDto.getPhoneNumber());
    }
    @Test
    void givenCreatingCustomer_WhenCallingCreatingCustomerToCustomerMethod_ThenReturnCustomerWithSameData(){
        //WHEN
        Customer customerToTest = mapper.creatingCustomerToCustomer(creatingCustomer1);
        //THEN
        Assertions.assertThat(customerToTest).isInstanceOf(Customer.class);
        assertEquals(creatingCustomer1.getFirstName(), customerToTest.getFirstName());
        assertEquals(creatingCustomer1.getLastName(), customerToTest.getLastName());
        assertEquals(creatingCustomer1.getEmail(), customerToTest.getEmail());
        assertEquals(creatingCustomer1.getAddress(), customerToTest.getAddress());
        assertEquals(creatingCustomer1.getPhoneNumber(), customerToTest.getPhoneNumber());
    }
    @Test
    void givenCustomerDtoWithId_WhenCallingDtoToCustomerKeepingId_ThenReturnCustomerWithSameId(){
        //GIVEN
        CustomerDto customerDto = new CustomerDto(54, "Nice", "Death", "deathcorp@gmail.com",
                new Address("deathstreet 2", "Somewhere", "666"), "55566612");
        //WHEN
        Customer customerMapped = mapper.dtoToCustomerKeepingId(customerDto);
        //THEN
        assertEquals(customerDto.getId(), customerMapped.getId());
    }
}
