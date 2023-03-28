package com.switchfully.eurder.items.repository;

import com.switchfully.eurder.customers.domain.Customer;
import com.switchfully.eurder.customers.repository.CustomerDatabase;
import com.switchfully.eurder.items.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {
    private final ItemDatabase database;

    public ItemRepository(ItemDatabase database) {
        this.database = database;
    }
    public List<Item> getAll(){
        return database.getItems();
    }
    public Item addItem(Item item){
        database.getItems().add(item);
        return item;
    }

}
