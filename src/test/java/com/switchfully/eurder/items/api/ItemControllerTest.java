package com.switchfully.eurder.items.api;

import com.switchfully.eurder.items.domain.CreatingItem;
import com.switchfully.eurder.items.domain.ItemDto;
import com.switchfully.eurder.items.domain.ItemMapper;
import com.switchfully.eurder.items.repository.ItemDatabase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ItemControllerTest {
    @Autowired
    private ItemController controller;
    @Autowired
    private ItemDatabase database;
    @Autowired
    private ItemMapper mapper;
    @Test
    void whenGetAllItemsCall_ThenReturnListOfItemsDto(){
        //GIVEN
        List<ItemDto> itemsFromDB = mapper.listItemsToListDto(database.getItems());
        //WHEN
        List<ItemDto> itemsFromController = controller.getItems();
        //THEN
        Assertions.assertThat(itemsFromDB).hasSameElementsAs(itemsFromController);
    }
}