package com.example.kurlyitem.item.repository;

import com.example.kurlyitem.item.Item;
import com.example.kurlyitem.item.categories.PrimaryCategories;
import com.example.kurlyitem.item.categories.SecondaryCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    boolean existsByName(String name);

    List<Item> findAllByPrimaryCategory(PrimaryCategories primaryCategory);

    List<Item> findAllBySecondaryCategory(SecondaryCategories secondaryCategory);
}
