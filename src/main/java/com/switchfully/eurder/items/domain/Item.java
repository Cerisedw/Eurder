package com.switchfully.eurder.items.domain;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return amount == item.amount && Objects.equals(id, item.id) && Objects.equals(name, item.name) && Objects.equals(descritpion, item.descritpion) && Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, descritpion, price, amount);
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
