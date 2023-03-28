package com.switchfully.eurder.items.domain;

import com.switchfully.eurder.customers.domain.Customer;
import com.switchfully.eurder.customers.domain.CustomerDto;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ItemMapper {
    public ItemDto itemToDto(Item item){
        return new ItemDto(item.getId(), item.getName(),
                item.getDescritpion(), item.getPrice(),
                item.getAmount());
    }
    public Item dtoToItem(ItemDto itemDto){
        return new Item(itemDto.getName(), itemDto.getDescritpion(),
                itemDto.getPrice(), itemDto.getAmount());
    }
    public Item dtoToItemKeepingId(ItemDto itemDto){
        return new Item(itemDto.getId(),
                itemDto.getName(), itemDto.getDescritpion(),
                itemDto.getPrice(), itemDto.getAmount());
    }
    public Item creatingItemToItem(CreatingItem creatingItem){
        return new Item(creatingItem.getName(), creatingItem.getDescritpion(),
                creatingItem.getPrice(), creatingItem.getAmount());
    }
    public List<ItemDto> listItemsToListDto(List<Item> listItems){
        return listItems.stream()
                .map(this::itemToDto)
                .toList();
    }
    public List<Item> listDtoToListItems(List<ItemDto> listDto){
        return listDto.stream()
                .map(this::dtoToItem)
                .toList();
    }
}
