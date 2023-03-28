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
    @BeforeEach
    void setup(){
        customer1 = new Customer("Manta", "Ray", "manta-ray@gmail.com",
                new Address("street c 42", "Namur", "5080"), "0432585228");
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
}
