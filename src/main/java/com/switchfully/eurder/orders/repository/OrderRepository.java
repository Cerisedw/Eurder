package com.switchfully.eurder.orders.repository;

import com.switchfully.eurder.customers.exceptions.CustomerNotFoundException;
import com.switchfully.eurder.orders.exceptions.OrderNotFoundException;
import org.springframework.stereotype.Repository;
import com.switchfully.eurder.orders.domain.Order;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public class OrderRepository {
    private final OrderDatabase database;

    public OrderRepository(OrderDatabase database) {
        this.database = database;
    }
    public List<Order> getAll(){
        return database.getOrders();
    }
    public Order addOrder(Order order){
        database.getOrders().add(order);
        return order;
    }
    public Order getOrderById(String id){
        long longId = Long.parseLong(id);
        return database.getOrders().stream().filter(o->o.getId() == longId).findFirst().orElseThrow(
                () -> new OrderNotFoundException("Order with " + id + " id doesn't exist")
        );
    }

    public List<Order> getAllFromCustomer(String idCustomer) {
        long longIdCustomer = Long.parseLong(idCustomer);
        return database.getOrders().stream().filter(o->o.getIdUser() == longIdCustomer).collect(Collectors.toList());
    }
}
