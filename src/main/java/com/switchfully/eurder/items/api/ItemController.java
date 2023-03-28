package com.switchfully.eurder.items.api;

import com.switchfully.eurder.customers.domain.CustomerDto;
import com.switchfully.eurder.items.domain.ItemDto;
import com.switchfully.eurder.items.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "items")
public class ItemController {
    private final ItemService service;

    public ItemController(ItemService service) {
        this.service = service;
    }
    @GetMapping(produces ="application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getItems(){
        return service.getAllItems();
    }
}
