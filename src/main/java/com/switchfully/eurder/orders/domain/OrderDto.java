package com.switchfully.eurder.orders.domain;

import com.switchfully.eurder.items.domain.Price;
import com.switchfully.eurder.orders.domain.itemGroups.ItemGroupDto;

import java.util.List;

public class OrderDto {
    private final Long id;
    private final long idUser;
    private final List<ItemGroupDto> itemGroupList;
    private final Price totalToPay;
    public OrderDto(Long id, long idUser, List<ItemGroupDto> itemGroupList, Price totalToPay) {
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

    public List<ItemGroupDto> getItemGroupList() {
        return itemGroupList;
    }

    public Price getTotalToPay() {
        return totalToPay;
    }
    // endregion
}
