package com.dishita.kaamchor.controller;

import com.dishita.kaamchor.enums.Category;
import com.dishita.kaamchor.model.Item;
import com.dishita.kaamchor.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping()
    public Item postItem(@RequestBody Item item){
        return itemService.postItem(item);
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Integer id){
        return itemService.getItemById(id);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable Integer id, @RequestBody Item item){
        return itemService.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Integer id){
        itemService.deleteItem(id);
        return "SUCCESS";
    }

    @GetMapping("/search")
    public Item searchItem(@RequestParam String name){
        return itemService.findByName(name);
    }

    @GetMapping("/category/{category}")
    public List<Item> getItemByCategory(@PathVariable Category category){
        return itemService.getItemsByCategory(category);
    }

    @GetMapping("/adjust-price")
    public String adjustItemPrice(@RequestParam Integer percentage, @RequestParam Category category){
        itemService.adjustItemPrice(percentage, category);
        return "SUCCESS";
    }
}
