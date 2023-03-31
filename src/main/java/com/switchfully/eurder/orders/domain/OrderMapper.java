package com.switchfully.eurder.orders.domain;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderMapper {
    public OrderDto orderToDto(Order order){
        return new OrderDto(order.getId(), order.getIdUser(), order.getItemGroupList(), order.getTotalToPay());
    }
    public Order dtoToOrder(OrderDto orderDto){
        return new Order(orderDto.getIdUser(), orderDto.getItemGroupList(), orderDto.getTotalToPay().getCurrency());
    }
    public Order dtoToOrderKeepingId(OrderDto orderDto){
        return new Order(orderDto.getId(), orderDto.getIdUser(), orderDto.getItemGroupList(), orderDto.getTotalToPay().getCurrency());
    }
    public Order creatingOrderToOrder(CreatingOrder creatingOrder){
        return new Order(creatingOrder.getIdUser(), creatingOrder.getItemGroupList(), creatingOrder.getCurrency());
    }
    public List<OrderDto> listOrdersToListDto(List<Order> listOrders){
        return listOrders.stream()
                .map(this::orderToDto)
                .toList();
    }
    public List<Order> listDtoToListOrders(List<OrderDto> listDto){
        return listDto.stream()
                .map(this::dtoToOrder)
                .toList();
    }
}
