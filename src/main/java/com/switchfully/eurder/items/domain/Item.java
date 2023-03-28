package com.switchfully.eurder.items.domain;

import java.util.concurrent.atomic.AtomicLong;

public class Item {
    private static final AtomicLong counter = new AtomicLong();
    private final Long id;
    private final String name;
    private final String descritpion;
    private final Price price;
    private final int amount;

    public Item(String name, String descritpion, Price price, int amount) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.descritpion = descritpion;
        this.price = price;
        this.amount = amount;
    }

    public Item(Long id, String name, String descritpion, Price price, int amount) {
        this.id = id;
        this.name = name;
        this.descritpion = descritpion;
        this.price = price;
        this.amount = amount;
    }
    // region GETTER

    public Long getId() {
        return id;
    }

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
