package com.switchfully.eurder.orders.domain;

import com.switchfully.eurder.items.domain.Currency;
import com.switchfully.eurder.items.domain.Price;
import com.switchfully.eurder.orders.domain.itemGroups.ItemGroup;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Order {
    private static final AtomicLong counter = new AtomicLong();
    private final Long id;
    private final long idUser;
    private final List<ItemGroup> itemGroupList;
    private final Price totalToPay;

    public Order(long idUser, List<ItemGroup> itemGroupList, Currency currency) {
        this.id = counter.incrementAndGet();
        this.idUser = idUser;
        this.itemGroupList = itemGroupList;
        this.totalToPay = calculatePriceWhenOrdering(currency);
    }

    public Order(Long id, long idUser, List<ItemGroup> itemGroupList, Currency currency) {
        this.id = id;
        this.idUser = idUser;
        this.itemGroupList = itemGroupList;
        this.totalToPay = calculatePriceWhenOrdering(currency);
    }

    private Price calculatePriceWhenOrdering(Currency currency){
        getItemGroupList().forEach(i -> i.getPriceOfItem().convertTo(currency));
        double total = getItemGroupList()
                .stream().map(i -> i.getPriceOfItem().getAmount())
                .reduce((double) 0, Double::sum);
        return new Price(total, currency);
    }
    //region GETTER
    public long getIdUser() {
        return idUser;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    public Price getTotalToPay() {
        return totalToPay;
    }

    public Long getId() {
        return id;
    }
//endregion
}
