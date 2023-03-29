package com.switchfully.eurder.items.service;

import com.switchfully.eurder.items.domain.CreatingItem;
import com.switchfully.eurder.items.domain.Item;
import com.switchfully.eurder.items.domain.ItemDto;
import com.switchfully.eurder.items.repository.ItemRepository;
import com.switchfully.eurder.items.domain.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    private final ItemRepository repo;
    private final ItemMapper mapper;

    public ItemService(ItemRepository repo, ItemMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
    public List<ItemDto> getAllItems(){
        return mapper.listItemsToListDto(repo.getAll());
    }
    public ItemDto addItem(CreatingItem creatingItem){
        Item itemAdded = repo.addItem(mapper.creatingItemToItem(creatingItem));
        return mapper.itemToDto(itemAdded);
    }

    public ItemDto getItemById(String id) {
        return mapper.itemToDto(repo.getItemById(id));
    }
    public ItemDto updateItem(String id, CreatingItem creatingItem){
        // Item itemNotChanged = repo.getItemById(id);
        Item itemChanged = new Item(Long.parseLong(id), creatingItem.getName(),
                creatingItem.getDescritpion(), creatingItem.getPrice(),
                creatingItem.getAmount());
        return mapper.itemToDto(repo.updateItem(id, itemChanged));
    }
}
