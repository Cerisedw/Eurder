package com.switchfully.eurder.items.api;


import com.switchfully.eurder.customers.service.CustomerService;
import com.switchfully.eurder.customers.domain.Feature;
import com.switchfully.eurder.items.domain.*;
import com.switchfully.eurder.items.exceptions.ItemNotFoundException;
import com.switchfully.eurder.items.repository.ItemDatabase;
import com.switchfully.eurder.customers.exceptions.UnauthorizatedException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ItemControllerTest {
    @Autowired
    private ItemController controller;
    @Autowired
    private ItemDatabase database;
    @Autowired
    private ItemMapper mapper;
    @Autowired
    private CustomerService customerService;
    @Test
    void whenGetAllItemsCall_ThenReturnListOfItemsDto(){
        //GIVEN
        List<ItemDto> itemsFromDB = mapper.listItemsToListDto(database.getItems());
        //WHEN
        List<ItemDto> itemsFromController = controller.getItems();
        //THEN
        Assertions.assertThat(itemsFromDB).hasSameElementsAs(itemsFromController);
    }
    @Test
    void givenCreatingItem_WhenAddItemCall_ThenAddItemToDataBase(){
        //GIVEN
        CreatingItem creatingItem = new CreatingItem("Something", "Something description",
                new Price(155, Currency.YEN), 1);
        //WHEN
        ItemDto customerAdded = controller.addItem(creatingItem, "Basic MT0=");
        //THEN
        Assertions.assertThat(database.getItems()).contains(mapper.dtoToItemKeepingId(customerAdded));
    }
    @Test
    void givenId_WhenGetItemByIdCall_ThenReturnedItemDto(){
        //GIVEN
        String id = "1";
        //WHEN
        ItemDto itemReturned = controller.getItemById(id);
        Item itemFromDB = database.getItems().stream()
                .filter(c->c.getId() == Long.parseLong(id)).findFirst().orElseThrow();
        //THEN
        Assertions.assertThat(itemReturned).isNotNull();
        Assertions.assertThat(itemReturned).isEqualTo(mapper.itemToDto(itemFromDB));
    }
    @Test
    void givenIdAndCreatingItemAndIdAdmin_WhenUpdateItemCalled_ThenReturnedItemDtoUpdated(){
        //GIVEN
        String id = "1";
        String idAdminCustomer = "Basic MT0=";
        CreatingItem itemUpdate = new CreatingItem( "Something", "Somthing description",
                new Price(155, Currency.YEN), 1);
        //WHEN
        ItemDto itemReturnedAfterUpdate = controller.updateItem(itemUpdate, id, idAdminCustomer);
        //THEN
        assertEquals(Long.parseLong(id), itemReturnedAfterUpdate.getId());
        assertEquals(itemUpdate.getName(), itemReturnedAfterUpdate.getName());
        assertEquals(itemUpdate.getDescritpion(), itemReturnedAfterUpdate.getDescritpion());
        assertEquals(itemUpdate.getPrice(), itemReturnedAfterUpdate.getPrice());
        assertEquals(itemUpdate.getAmount(), itemReturnedAfterUpdate.getAmount());
    }
    @Test
    @DisplayName("Item with id 2 is not authorized to add an item")
    void UnauthorizedUserThrows() {
        assertThatThrownBy(() -> customerService.validateAuthorization("2", Feature.ADD_ITEM))
                .isInstanceOf(UnauthorizatedException.class);
    }
    @Test
    void ItemNotFoundExceptionThrows(){
        assertThatThrownBy(() -> controller.getItemById("15545658"))
                .isInstanceOf(ItemNotFoundException.class);
    }
}