package com.upc.demosec.service;


import com.upc.demosec.model.Item;
import com.upc.demosec.repository.ItemRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll () {
        return itemRepository.findAll();
    }
    public List<Item> findByWarehouseOrderByDescriptionDesc (Integer warehouse){
    //  return itemRepository.findAllByWarehouseOrderByDescription (warehouse);
        return itemRepository.search(warehouse);
    }
    public Item save (Item item) {
        return itemRepository.save(item);
    }

    public Item update (Item item, Long id)  {
        // Verifica que el Id exista
        Item itemUpdate = itemRepository.findById(id)
                .orElse( null);

        if (itemUpdate == null) { return itemUpdate; }

        Item itemDetalle = item;
        if (itemUpdate.equals(itemDetalle)) {  return itemUpdate; }

        // Modifica el registro existente con los valores proporcionados
        itemUpdate = itemRepository.getById(id);
        itemUpdate.setDescription(item.getDescription());
        itemUpdate.setUnit(item.getUnit());
        itemUpdate.setWarehouse(item.getWarehouse());

        return itemRepository.save(itemUpdate);
    }
}
