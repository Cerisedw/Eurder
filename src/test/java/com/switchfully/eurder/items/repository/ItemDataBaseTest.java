package com.switchfully.eurder.items.repository;

import com.switchfully.eurder.items.domain.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ItemDataBaseTest {
    @Autowired
    private ItemDatabase database;
    @Test
    void whenCallingDataBaseGetItemsMethod_ThenShouldReturnNotEmptyListOfItems(){
        //WHEN
        List<Item> itemsFromDB = database.getItems();
        //THEN
        Assertions.assertThat(itemsFromDB).isNotEmpty();
    }
}
