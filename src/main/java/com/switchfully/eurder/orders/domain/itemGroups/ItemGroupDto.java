package com.switchfully.eurder.orders.domain.itemGroups;

import com.switchfully.eurder.items.domain.ItemDto;
import com.switchfully.eurder.items.domain.Price;

import java.time.LocalDate;

public class ItemGroupDto {
    private final ItemDto item;
    private final int amount;
    private final Price priceOfItem;
    private final LocalDate shippingDate;

    public ItemGroupDto(ItemDto item, int amount, Price priceOfItem, LocalDate shippingDate) {
        this.item = item;
        this.amount = amount;
        this.priceOfItem = priceOfItem;
        this.shippingDate = shippingDate;
    }
    // region GETTER
    public ItemDto getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }

    public Price getPriceOfItem() {
        return priceOfItem;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }
    // endregion
}
