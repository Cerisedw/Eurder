package com.switchfully.eurder.items.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ItemMapperTest {
    @Autowired
    private ItemMapper mapper;
    private Item item1;
    private CreatingItem creatingItem1;
    @BeforeEach
    void setup(){
        item1 = new Item("jacket", "this is a jacket description",
                new Price(35, Currency.EURO), 1);
        creatingItem1 = new CreatingItem("Hat", "This is a hat description",
                new Price(15, Currency.EURO), 1);
    }
    @Test
    void givenItem_WhenCallingItemToDTOMethod_ThenReturnItemDtoWithSameData(){
        //WHEN
        ItemDto itemDto = mapper.itemToDto(item1);
        //THEN
        Assertions.assertThat(itemDto).isInstanceOf(ItemDto.class);
        assertEquals(item1.getId(), itemDto.getId());
        assertEquals(item1.getName(), itemDto.getName());
        assertEquals(item1.getDescritpion(), itemDto.getDescritpion());
        assertEquals(item1.getPrice(), itemDto.getPrice());
        assertEquals(item1.getAmount(), itemDto.getAmount());
    }
    @Test
    void givenCreatingItem_WhenCallingCreatingItemToItemMethod_ThenReturnItemWithSameData(){
        //WHEN
        Item itemToTest = mapper.creatingItemToItem(creatingItem1);
        //THEN
        Assertions.assertThat(itemToTest).isInstanceOf(Item.class);
        assertEquals(creatingItem1.getName(), itemToTest.getName());
        assertEquals(creatingItem1.getDescritpion(), itemToTest.getDescritpion());
        assertEquals(creatingItem1.getPrice(), itemToTest.getPrice());
        assertEquals(creatingItem1.getAmount(), itemToTest.getAmount());
    }
    @Test
    void givenItemDtoWithId_WhenCallingDtoToItemKeepingId_ThenReturnItemWithSameId(){
        //GIVEN
        ItemDto itemDto = new ItemDto(56L, "Mario Kart", "game for the SNES",
                new Price(50, Currency.DOLLAR), 1);
        //WHEN
        Item itemMapped = mapper.dtoToItemKeepingId(itemDto);
        //THEN
        assertEquals(itemDto.getId(), itemMapped.getId());
    }
}
