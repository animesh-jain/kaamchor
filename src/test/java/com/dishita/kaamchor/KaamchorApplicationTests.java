package com.dishita.kaamchor;

import com.dishita.kaamchor.enums.Category;
import com.dishita.kaamchor.model.Item;
import com.dishita.kaamchor.service.ItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class KaamchorApplicationTests {

	@Autowired
	private ItemService itemService;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void contextLoads() {
	}

	@Test
	void testItemCreation() throws JsonProcessingException {
		Item item = new Item();
		item.setName("test");
		item.setDescription("test");
		item.setCategory(Category.ELECTRONICS);
		item.setPrice(99.0);
		item.setQuantityInStock(10);
		Item i = itemService.postItem(item);
		System.out.println("Item : " + mapper.writeValueAsString(i));
	}

	@Test
	void testItemGet() throws JsonProcessingException {
		Item item = new Item();
		item.setName("testX");
		item.setDescription("test");
		item.setCategory(Category.ELECTRONICS);
		item.setPrice(99.0);
		item.setQuantityInStock(10);
		Item i = itemService.postItem(item);
		Item i2 = itemService.getItemById(i.getId());
		System.out.println("Item : " + mapper.writeValueAsString(i2));
	}

	@Test
	void testItemUpdate() throws JsonProcessingException {
		Item item = new Item();
		item.setName("test change");
		item.setDescription("test");
		item.setCategory(Category.ELECTRONICS);
		item.setPrice(99.0);
		item.setQuantityInStock(10);
		Integer id = 1;
		Item i = itemService.updateItem(id, item);
		System.out.println("Item : " + mapper.writeValueAsString(i));
	}


	@Test
	void testItemSearch() throws JsonProcessingException {
		Item item = new Item();
		long time = System.currentTimeMillis();
		item.setName("test change " + time);
		item.setDescription("test");
		item.setCategory(Category.ELECTRONICS);
		item.setPrice(99.0);
		item.setQuantityInStock(10);
		itemService.postItem(item);
		Item i = itemService.findByName("test change " + time);
		System.out.println("Item : " + mapper.writeValueAsString(i));
	}

	@Test
	void testItemCategorySearch() throws JsonProcessingException {
		List<Item> items = itemService.getItemsByCategory(Category.ELECTRONICS);
		System.out.println("Item : " + mapper.writeValueAsString(items));
	}

	@Test
	void testItemAdjustPrice() throws JsonProcessingException {
		itemService.adjustItemPrice(20, Category.ELECTRONICS);
		List<Item> items = itemService.getItemsByCategory(Category.ELECTRONICS);
		System.out.println("Item : " + mapper.writeValueAsString(items));
	}


	@Test
	void testItemDelete() throws JsonProcessingException {

		itemService.deleteItem(6);
		Item i = itemService.getItemById(6);
		System.out.println("Item : " + mapper.writeValueAsString(i));
	}
}
