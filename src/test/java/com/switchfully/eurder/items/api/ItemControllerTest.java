package com.switchfully.eurder.items.api;


import com.switchfully.eurder.customers.service.CustomerService;
import com.switchfully.eurder.customers.domain.Feature;
import com.switchfully.eurder.items.domain.*;
import com.switchfully.eurder.items.repository.ItemDatabase;
import com.switchfully.eurder.customers.exceptions.UnauthorizatedException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    @DisplayName("Customer with id 2 is not authorized to add an item")
    void UnauthorizedUserThrows() {
        assertThatThrownBy(() -> customerService.validateAuthorization("2", Feature.ADD_ITEM))
                .isInstanceOf(UnauthorizatedException.class);
    }
}