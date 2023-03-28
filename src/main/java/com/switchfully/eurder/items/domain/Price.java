package com.switchfully.eurder.items.domain;

public class Price {
    private int amount;
    private Currency currency;

    public Price(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
    // region GETTER

    public int getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    // endregion
}
