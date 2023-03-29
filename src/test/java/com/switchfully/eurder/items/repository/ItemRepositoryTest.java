package com.switchfully.eurder.items.repository;

import com.switchfully.eurder.customers.domain.Customer;
import com.switchfully.eurder.items.domain.CreatingItem;
import com.switchfully.eurder.items.domain.Currency;
import com.switchfully.eurder.items.domain.Item;
import com.switchfully.eurder.items.domain.Price;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ItemRepositoryTest {
    @Autowired
    private ItemRepository repo;
    @Autowired
    private ItemDatabase database;
    @Test
    void whenCallingRepositoryGetAllMethod_ThenShouldReturnNotEmptyListOfItems(){
        //WHEN
        List<Item> itemsFromRepo = repo.getAll();
        //THEN
        Assertions.assertThat(itemsFromRepo).isNotEmpty();
    }
    @Test
    void givenAItem_WhenCallingRepositoryAddItemMethod_ThenNewItemShouldBeInDataBase(){
        //GIVEN
        Item itemToAdd = new Item("Something", "Somthing description",
                new Price(155, Currency.YEN), 1);
        //WHEN
        repo.addItem(itemToAdd);
        //THEN
        Assertions.assertThat(database.getItems()).contains(itemToAdd);
    }
    @Test
    void givenAnId_WhenCallingRepositoryGetItemById_ThenShouldReturnNotNullItem(){
        //GIVEN
        String id = "1";
        //WHEN
        Item itemReturnedByRepo = repo.getItemById(id);
        //THEN
        Assertions.assertThat(itemReturnedByRepo).isNotNull();
    }
    @Test
    void givenAnId_WhenCallingRepositoryGetItemById_ThenShouldReturnSameItemAsInDB(){
        //GIVEN
        String id = "1";
        //WHEN
        Item itemReturnedByRepo = repo.getItemById(id);
        Item itemReturnedByDB = database.getItems().stream()
                .filter(i->i.getId() == Long.parseLong(id)).findFirst().orElseThrow();
        //THEN
        Assertions.assertThat(itemReturnedByDB).isEqualTo(itemReturnedByRepo);
    }
    @Test
    void givenAnIdAndItem_WhenCallingRepositoryUpdateItem_ThenShouldChangeOldItemWithNewOneAtSameId(){
        //GIVEN
        String id = "1";
        Item itemUpdate = new Item(1L, "Something", "Somthing description",
                new Price(155, Currency.YEN), 1);
        //WHEN
        Item itemReturnedAfterUpdate = repo.updateItem(id, itemUpdate);
        //THEN
        assertEquals(itemUpdate.getId(), itemReturnedAfterUpdate.getId());
        assertEquals(itemUpdate.getName(), itemReturnedAfterUpdate.getName());
        assertEquals(itemUpdate.getDescritpion(), itemReturnedAfterUpdate.getDescritpion());
        assertEquals(itemUpdate.getPrice(), itemReturnedAfterUpdate.getPrice());
        assertEquals(itemUpdate.getAmount(), itemReturnedAfterUpdate.getAmount());
    }
}
