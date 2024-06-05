package com.dishita.kaamchor.repository;

import com.dishita.kaamchor.enums.Category;
import com.dishita.kaamchor.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

    Optional<Item> findByName(String name);

    List<Item> findAllByCategory(Category category);
}
