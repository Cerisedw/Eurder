package com.switchfully.eurder.items.repository;

import com.switchfully.eurder.items.domain.Currency;
import com.switchfully.eurder.items.domain.Item;
import com.switchfully.eurder.items.domain.Price;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

}
