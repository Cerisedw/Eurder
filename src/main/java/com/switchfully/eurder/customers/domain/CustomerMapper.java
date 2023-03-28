package com.switchfully.eurder.customers.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper {
    public CustomerDto customerToDto(Customer customer){
        return new CustomerDto(
                customer.getId(), customer.getFirstName(),
                customer.getLastName(), customer.getEmail(),
                customer.getAddress(), customer.getPhoneNumber()
        );
    }
    public Customer dtoToCustomer(CustomerDto customerDto){
        return new Customer(
                customerDto.getFirstName(), customerDto.getLastName(),
                customerDto.getEmail(), customerDto.getAddress(),
                customerDto.getPhoneNumber());
    }
    public List<CustomerDto> listCustomersToListDto(List<Customer> listCustomers){
        return listCustomers.stream()
                .map(this::customerToDto)
                .toList();
    }
    public List<Customer> listDtoToListCustomers(List<CustomerDto> listCustomersDto){
        return listCustomersDto.stream()
                .map(this::dtoToCustomer)
                .toList();
    }
}
