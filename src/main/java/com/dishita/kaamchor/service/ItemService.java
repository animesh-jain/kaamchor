package com.dishita.kaamchor.service;

import com.dishita.kaamchor.enums.Category;
import com.dishita.kaamchor.model.Item;
import com.dishita.kaamchor.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item postItem(Item item) {
        return itemRepository.save(item);
    }

    public Item getItemById(Integer id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item updateItem(Integer id, Item item) {
        //find item, if not present throw error
        item.setId(id);
        return itemRepository.save(item);
    }

    public void deleteItem(Integer id) {
        itemRepository.deleteById(id);
    }

    public Item findByName(String name) {
        return itemRepository.findByName(name).orElseThrow();
    }

    public List<Item> getItemsByCategory(Category category) {
        return itemRepository.findAllByCategory(category);
    }

    @Transactional
    public void adjustItemPrice(Integer percentage, Category category) {
        //add redis lock
        List<Item> items = itemRepository.findAllByCategory(category);
        items.forEach(i->i.setPrice(getChangedPrice(i.getPrice(), percentage)));
        itemRepository.saveAll(items);//apply limit offset
        //release lock
    }

    private Double getChangedPrice(Double price, Integer percentage) {
        return price + (price * percentage)/100;
    }
}
