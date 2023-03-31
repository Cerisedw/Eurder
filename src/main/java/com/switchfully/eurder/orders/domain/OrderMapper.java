package com.switchfully.eurder.orders.domain;

import com.switchfully.eurder.items.repository.ItemRepository;
import com.switchfully.eurder.orders.domain.itemGroups.ItemGroup;
import com.switchfully.eurder.orders.domain.itemGroups.ItemGroupMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {
    private final ItemRepository itemRepo;
    private final ItemGroupMapper itemGroupMapper;
    public OrderMapper(ItemRepository itemRepo, ItemGroupMapper itemGroupMapper){
        this.itemRepo = itemRepo;
        this.itemGroupMapper = itemGroupMapper;
    }
    public OrderDto orderToDto(Order order){
        return new OrderDto(order.getId(), order.getIdUser(),
                itemGroupMapper.listItemGroupsToListDto(order.getItemGroupList()),
                order.getTotalToPay());
    }
    public Order dtoToOrder(OrderDto orderDto){
        return new Order(orderDto.getIdUser(),
                itemGroupMapper.listDtoToListItemGroups(orderDto.getItemGroupList()),
                orderDto.getTotalToPay().getCurrency());
    }
    public Order dtoToOrderKeepingId(OrderDto orderDto){
        return new Order(orderDto.getId(), orderDto.getIdUser(),
                itemGroupMapper.listDtoToListItemGroups(orderDto.getItemGroupList()),
                orderDto.getTotalToPay().getCurrency());
    }
    public Order creatingOrderToOrder(String idCustomer, CreatingOrder creatingOrder){
        List<ItemGroup> listItems = createListItemGroupFromItemId(creatingOrder.getItemIdList());
        return new Order(Long.parseLong(idCustomer), listItems, creatingOrder.getCurrency());
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


    private List<ItemGroup> createListItemGroupFromItemId(List<String> listItemId){
        List<ItemGroup> listItemGroups = new ArrayList<>();
        for (String idItem:listItemId) {
            listItemGroups.add(new ItemGroup(itemRepo.getItemById(idItem)));
        }
        return listItemGroups;
    }
}
