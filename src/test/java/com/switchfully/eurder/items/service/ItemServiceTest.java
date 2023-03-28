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
    /*@Test
    void givenACreatingItem_WhenCallingServiceAddItemMethod_ThenShouldAddItemToDB(){
        //GIVEN
        CreatingItem customerToAdd = new CreatingItem("Sipho", "Nophore", "zooids@gmail.com",
                new Address("rue deepsea 15", "2050", "Atlantique"), "0544955119");
        //WHEN
        ItemDto customerAdded = service.addItem(customerToAdd);
        //THEN
        Assertions.assertThat(repo.getAll()).contains(mapper.dtoToItemKeepingId(customerAdded));
    }*/

}
