package com.switchfully.eurder.items.repository;

import com.switchfully.eurder.items.domain.Item;
import com.switchfully.eurder.items.exceptions.ItemNotFoundException;
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
    public Item getItemById(String id){
        long longId = Long.parseLong(id);
        return database.getItems().stream().filter(c->c.getId() == longId).findFirst().orElseThrow(
                () -> new ItemNotFoundException("Item with " + id + " id doesn't exist")
        );
    }
    public Item updateItem(String id, Item item){
        int index = database.getItems().indexOf(getItemById(id));
        database.getItems().set(index, item);
        return item;
    }

}
