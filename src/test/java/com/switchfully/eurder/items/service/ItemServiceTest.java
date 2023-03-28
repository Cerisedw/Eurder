package com.switchfully.eurder.items.service;

import com.switchfully.eurder.items.domain.CreatingItem;
import com.switchfully.eurder.items.domain.ItemDto;
import com.switchfully.eurder.items.domain.ItemMapper;
import com.switchfully.eurder.items.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ItemServiceTest {
    @Autowired
    private ItemService service;
    @Autowired
    private ItemRepository repo;
    @Autowired
    private ItemMapper mapper;
    @Test
    void whenCallingServiceGetAllItemsMethod_ThenShouldReturnNotEmptyListOfItemsDto(){
        //WHEN
        List<ItemDto> itemsFromRepo = service.getAllItems();
        //THEN
        Assertions.assertThat(itemsFromRepo).isNotEmpty();
    }
}
