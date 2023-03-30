package com.switchfully.eurder.orders.domain;

import com.switchfully.eurder.items.domain.Currency;
import com.switchfully.eurder.items.domain.Price;

import java.util.List;

public class Order {
    private final long idUser;
    private final List<ItemGroup> itemGroupList;
    private final Price totalToPay;

    public Order(long idUser, List<ItemGroup> itemGroupList, Currency currency) {
        this.idUser = idUser;
        this.itemGroupList = itemGroupList;
        totalToPay = calculatePriceWhenOrdering(currency);
    }
    private Price calculatePriceWhenOrdering(Currency currency){
        getItemGroupList().forEach(i -> i.getPriceOfItem().convertTo(currency));
        double total = getItemGroupList()
                .stream().map(i -> i.getPriceOfItem().getAmount())
                .reduce((double) 0, Double::sum);
        return new Price(total, currency);
    }
    //As a customer I want to order one or more items.
    //
    //    An Order contains one or more item groups
    //    The total price should be calculated and shown to the customer when ordering.
    //    Question: should an order keep a reference to an item or should it make some sort of copy?
    //        Tip: The the price of the item can change over time... What implications might this have?
    //    Obviously, we also need to keep track of who made the order (it has to be a known customer)
    //region GETTER
    public long getIdUser() {
        return idUser;
    }

    public List<ItemGroup> getItemGroupList() {
        return itemGroupList;
    }

    //endregion
}
