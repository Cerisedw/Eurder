package com.switchfully.eurder.orders.domain.itemGroups;

import com.switchfully.eurder.items.domain.Item;
import com.switchfully.eurder.items.domain.Price;

import java.time.LocalDate;

public class ItemGroup {
    private final long itemId;
    private final int amount;
    private final Price priceOfItem;
    private final LocalDate shippingDate;

    public ItemGroup(Item item) {
        this.itemId = item.getId();
        this.amount = item.getAmount();
        this.priceOfItem = item.getPrice();
        this.shippingDate = calculateShippingDate(item.getAmount());
    }
    private LocalDate calculateShippingDate(int amount){
        if (amount > 0) return LocalDate.now().plusDays(1);
        else return LocalDate.now().plusWeeks(1);
    }



    // region GETTER
    public Price getPriceOfItem() {
        return priceOfItem;
    }
    public long getItemId() {
        return itemId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    // endregion
}
