package com.switchfully.eurder.orders.repository;

import com.switchfully.eurder.items.domain.Currency;
import com.switchfully.eurder.items.repository.ItemRepository;
import com.switchfully.eurder.orders.domain.itemGroups.ItemGroup;
import com.switchfully.eurder.orders.domain.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class OrderDatabase {
    private final List<Order> orders;
    private ItemRepository itemRepo;
    public OrderDatabase(ItemRepository itemRepo){
        this.itemRepo = itemRepo;
        this.orders = new ArrayList<>();
        populateDataBase();
    }
    private void populateDataBase(){
        orders.addAll(List.of(
                new Order(1,
                        List.of(new ItemGroup(itemRepo.getItemById("1")), new ItemGroup(itemRepo.getItemById("2"))),
                        Currency.EURO), new Order(2,
                        List.of(new ItemGroup(itemRepo.getItemById("3"))), Currency.DOLLAR)
        ));
    }

    public List<Order> getOrders() {
        return orders;
    }
}
