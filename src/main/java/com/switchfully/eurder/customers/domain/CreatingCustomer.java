package com.switchfully.eurder.customers.domain;

public class CreatingCustomer {
    private String firstName;
    private String lastName;
    private final String email;
    private Address address;
    private String phoneNumber;

    public CreatingCustomer(String firstName, String lastName, String email, Address address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    // region GETTER
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    // endregion
}
