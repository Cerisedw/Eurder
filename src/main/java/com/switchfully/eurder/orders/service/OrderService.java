package com.switchfully.eurder.orders.service;

import com.switchfully.eurder.orders.domain.CreatingOrder;
import com.switchfully.eurder.orders.domain.Order;
import com.switchfully.eurder.orders.domain.OrderDto;
import com.switchfully.eurder.orders.domain.OrderMapper;
import com.switchfully.eurder.orders.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository repo;
    private final OrderMapper mapper;
     public OrderService(OrderRepository repo, OrderMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
    public List<OrderDto> getAllOrders(){
        return mapper.listOrdersToListDto(repo.getAll());
    }
    public OrderDto addOrder(CreatingOrder creatingOrder){
        Order orderAdded = repo.addOrder(mapper.creatingOrderToOrder(creatingOrder));
        return mapper.orderToDto(orderAdded);
    }
     public OrderDto getOrderById(String id) {
        return mapper.orderToDto(repo.getOrderById(id));
    }
}
