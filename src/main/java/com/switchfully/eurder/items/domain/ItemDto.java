package com.switchfully.eurder.items.domain;

import java.util.Objects;

public class ItemDto {
    private final Long id;
    private final String name;
    private final String descritpion;
    private final Price price;
    private final int amount;

    public ItemDto(Long id, String name, String descritpion, Price price, int amount) {
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
        ItemDto itemDto = (ItemDto) o;
        return amount == itemDto.amount && Objects.equals(id, itemDto.id) && Objects.equals(name, itemDto.name) && Objects.equals(descritpion, itemDto.descritpion) && Objects.equals(price, itemDto.price);
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
