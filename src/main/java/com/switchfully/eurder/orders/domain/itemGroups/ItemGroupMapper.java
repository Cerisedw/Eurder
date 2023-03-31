package com.switchfully.eurder.orders.domain.itemGroups;

import com.switchfully.eurder.items.domain.ItemMapper;
import com.switchfully.eurder.items.service.ItemService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemGroupMapper {
    private final ItemService itemService;
    private final ItemMapper itemMapper;
    public ItemGroupMapper(ItemService itemService, ItemMapper itemMapper){
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }
    public ItemGroupDto itemGroupToDto(ItemGroup itemGroup){
        return new ItemGroupDto(itemService.getItemById(Long.toString(itemGroup.getItemId())),
                itemGroup.getAmount(), itemGroup.getPriceOfItem(), itemGroup.getShippingDate());
    }
    public ItemGroup dtoToItemGroup(ItemGroupDto itemGroupDto){
        return new ItemGroup(itemMapper.dtoToItem(
                itemService.getItemById(
                        Long.toString(itemGroupDto.getItem().getId())))
        );
    }
    public List<ItemGroupDto> listItemGroupsToListDto(List<ItemGroup> listItemGroups){
        return listItemGroups.stream()
                .map(this::itemGroupToDto)
                .toList();
    }
    public List<ItemGroup> listDtoToListItemGroups(List<ItemGroupDto> listDto){
        return listDto.stream()
                .map(this::dtoToItemGroup)
                .toList();
    }
}
