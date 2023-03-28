package com.switchfully.eurder.items.api;


import com.switchfully.eurder.customers.domain.Feature;
import com.switchfully.eurder.customers.service.CustomerService;
import com.switchfully.eurder.items.domain.CreatingItem;
import com.switchfully.eurder.items.domain.ItemDto;
import com.switchfully.eurder.items.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping(value = "items")
public class ItemController {
    private final ItemService service;
    private final CustomerService customerService;

    public ItemController(ItemService service, CustomerService customerService) {
        this.service = service;
        this.customerService = customerService;
    }
    @GetMapping(produces ="application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getItems(){
        return service.getAllItems();
    }
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addItem(@RequestBody CreatingItem creatingItem, @RequestHeader String authorization){
        String authorizationDecoded = decode(authorization);
        customerService.validateAuthorization(authorizationDecoded, Feature.ADD_ITEM);
        return service.addItem(creatingItem);
    }
    private String decode(String authorization) {
        String decodedAuthorization = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        return decodedAuthorization.substring(0, decodedAuthorization.length() - 1);
    }
}
