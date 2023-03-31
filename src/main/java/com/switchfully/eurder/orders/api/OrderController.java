package com.switchfully.eurder.orders.api;

import com.switchfully.eurder.items.service.ItemService;
import com.switchfully.eurder.orders.domain.OrderDto;
import com.switchfully.eurder.orders.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final OrderService service;
    private final ItemService itemService;

    public OrderController(OrderService service, ItemService itemService) {
        this.service = service;
        this.itemService = itemService;
    }
    @GetMapping(produces ="application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getOrders(){
        return service.getAllOrders();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto getOrderById(@PathVariable String id){
        return service.getOrderById(id);
    }
}
