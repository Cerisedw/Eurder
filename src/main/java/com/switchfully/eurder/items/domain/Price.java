package com.switchfully.eurder.items.domain;

public class Price {
    private final double CONVERSION_YEN_EURO = 144.86;
    private final double CONVERSION_DOLLAR_EURO = 1.09;
    private final double CONVERSION_DOLLAR_YEN = 132.68;

    private double amount;
    private Currency currency;

    public Price(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }
    public void convertTo(Currency currency){
        if (currency.equals(Currency.EURO)) convertToEuro();
        else if (currency.equals(Currency.DOLLAR)) convertToDollar();
        else if (currency.equals(Currency.YEN)) convertToYen();
    }
    private void convertToEuro(){
        if(currency.equals(Currency.DOLLAR)) {
            currency = Currency.EURO;
            amount = Math.round(amount * CONVERSION_DOLLAR_EURO);
        }
        else if(currency.equals(Currency.YEN)) {
            currency = Currency.EURO;
            amount = Math.round(amount / CONVERSION_YEN_EURO);
        }
    }
    private void convertToYen(){
        if(currency.equals(Currency.DOLLAR)) {
            currency = Currency.YEN;
            amount = Math.round(amount * CONVERSION_DOLLAR_YEN);
        }
        else if(currency.equals(Currency.EURO)) {
            currency = Currency.YEN;
            amount = Math.round(amount * CONVERSION_YEN_EURO);
        }
    }
    private void convertToDollar(){
        if(currency.equals(Currency.YEN)) {
            currency = Currency.DOLLAR;
            amount = Math.round(amount / CONVERSION_DOLLAR_YEN);
        }
        else if(currency.equals(Currency.EURO)) {
            currency = Currency.DOLLAR;
            amount = Math.round(amount / CONVERSION_DOLLAR_EURO);
        }
    }
    // region GETTER

    public double getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    // endregion
}
