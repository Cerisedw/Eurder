package com.switchfully.eurder.items.service;


import com.switchfully.eurder.items.domain.*;
import com.switchfully.eurder.items.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ItemServiceTest {
    @Autowired
    private ItemService service;
    @Autowired
    private ItemRepository repo;
    @Autowired
    private ItemMapper mapper;
    private CreatingItem newItem;
    @BeforeEach
    void setup(){
        newItem = new CreatingItem("Something", "Something description",
                new Price(155, Currency.YEN), 1);
    }
    @Test
    void whenCallingServiceGetAllItemsMethod_ThenShouldReturnNotEmptyListOfItemsDto(){
        //WHEN
        List<ItemDto> itemsFromRepo = service.getAllItems();
        //THEN
        Assertions.assertThat(itemsFromRepo).isNotEmpty();
    }
    @Test
    void givenACreatingItem_WhenCallingServiceAddItemMethod_ThenShouldAddItemToDB(){
        //WHEN
        ItemDto itemAdded = service.addItem(newItem);
        //THEN
        Assertions.assertThat(repo.getAll())
                .contains(mapper.dtoToItemKeepingId(itemAdded));
    }
    @Test
    void givenAnId_WhenCallingServiceGetItemById_ThenShouldReturnedNotNull(){
        //Given
        String id = "1";
        //WHEN
        ItemDto itemReturned = service.getItemById(id);
        //THEN
        Assertions.assertThat(itemReturned).isNotNull();
    }
    @Test
    void givenAnIdAndCreatingItem_WhenCallingRepositoryUpdateItem_ThenShouldChangeOldItemWithNewOneAtSameId(){
        //GIVEN
        String id = "1";
        CreatingItem itemUpdate = new CreatingItem( "Something", "Somthing description",
                new Price(155, Currency.YEN), 1);
        //WHEN
        ItemDto itemReturnedAfterUpdate = service.updateItem(id, itemUpdate);
        //THEN
        assertEquals(Long.parseLong(id), itemReturnedAfterUpdate.getId());
        assertEquals(itemUpdate.getName(), itemReturnedAfterUpdate.getName());
        assertEquals(itemUpdate.getDescritpion(), itemReturnedAfterUpdate.getDescritpion());
        assertEquals(itemUpdate.getPrice(), itemReturnedAfterUpdate.getPrice());
        assertEquals(itemUpdate.getAmount(), itemReturnedAfterUpdate.getAmount());
    }
}
