package com.switchfully.eurder.items.repository;

import com.switchfully.eurder.items.domain.Currency;
import com.switchfully.eurder.items.domain.Item;
import com.switchfully.eurder.items.domain.Price;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemDatabase {
    private final List<Item> items;
    public ItemDatabase() {
        this.items = new ArrayList<>();
        populateDataBase();
    }

    private void populateDataBase() {
        items.addAll(List.of(
                new Item("Orange", "a juicy fruit", new Price(1, Currency.EURO), 5),
                new Item("Nintendo WiiU", "video game console", new Price(250, Currency.DOLLAR), 1),
                new Item("Aquarium", "to put water and fish in", new Price (1000, Currency.YEN), 2)
        ));
    }

    public List<Item> getItems() {
        return items;
    }
}
