package com.switchfully.eurder.orders.domain;

import com.switchfully.eurder.items.domain.Currency;
import com.switchfully.eurder.items.domain.Price;

import java.util.List;

public class CreatingOrder {

    private final List<String> itemIdList;
    private final Currency currency;

    public CreatingOrder(List<String> itemIdList, Currency currency) {
        this.itemIdList = itemIdList;
        this.currency = currency;
    }
    // region GETTER


    public List<String> getItemIdList() {
        return itemIdList;
    }

    public Currency getCurrency() {
        return currency;
    }

    // endregion
}
