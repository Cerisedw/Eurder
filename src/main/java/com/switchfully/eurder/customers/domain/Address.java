package com.switchfully.eurder.customers.domain;

public class Address {
    private final String street;
    private final String city;
    private final String postalNumber;

    public Address(String street, String city, String postalNumber) {
        this.street = street;
        this.city = city;
        this.postalNumber = postalNumber;
    }
    // region GETTER
    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalNumber() {
        return postalNumber;
    }
    // endregion
}
