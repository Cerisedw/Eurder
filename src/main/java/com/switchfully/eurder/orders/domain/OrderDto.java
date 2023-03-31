package com.switchfully.eurder.orders.domain;

import com.switchfully.eurder.items.domain.Currency;
import com.switchfully.eurder.items.domain.Price;

import java.util.List;

public class OrderDto {
    private final Long id;
    private final long idUser;
    private final List<ItemGroup> itemGroupList;
    private final Price totalToPay;

    public OrderDto(Long id, long idUser, List<ItemGroup> itemGroupList, Price totalToPay) {
        this.id = id;
        this.idUser = idUser;
        this.itemGroupList = itemGroupList;
        this.totalToPay = totalToPay;
    }
    // region GETTER
    public Long getId() {
        return id;
    }

    public long getIdUser() {
        return idUser;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public Price getTotalToPay() {
        return totalToPay;
    }
    // endregion
}
