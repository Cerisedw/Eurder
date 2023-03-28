package com.switchfully.eurder.items.domain;

public class CreatingItem {
    private final String name;
    private final String descritpion;
    private final Price price;
    private final int amount;

    public CreatingItem(String name, String descritpion, Price price, int amount) {
        this.name = name;
        this.descritpion = descritpion;
        this.price = price;
        this.amount = amount;
    }
    // region GETTER

    public String getName() {
        return name;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public Price getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    // endregion
}
