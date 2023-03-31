package com.switchfully.eurder.orders.domain;

import com.switchfully.eurder.items.domain.Currency;
import com.switchfully.eurder.items.domain.Price;

import java.util.List;

public class CreatingOrder {

    private final long idUser;
    private final List<ItemGroup> itemGroupList;
    private final Currency currency;

    public CreatingOrder(long idUser, List<ItemGroup> itemGroupList, Currency currency) {
        this.idUser = idUser;
        this.itemGroupList = itemGroupList;
        this.currency = currency;
    }
    // region GETTER

    public long getIdUser() {
        return idUser;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public Currency getCurrency() {
        return currency;
    }

    // endregion
}
