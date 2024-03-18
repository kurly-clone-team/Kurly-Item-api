package com.example.kurlyitem.item.service;

import com.example.kurlyitem.item.Item;
import com.example.kurlyitem.item.categories.PrimaryCategories;
import com.example.kurlyitem.item.categories.SecondaryCategories;
import com.example.kurlyitem.item.dto.ItemSimpleDto;
import com.example.kurlyitem.item.repository.ItemRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ItemRepository itemRepository;

    @AfterEach
    void afterEach() {
        itemRepository.deleteAll();
    }

    @Test
    void 카테고리_테스트 () {
        final PrimaryCategories testPrimaryCategory = PrimaryCategories.SNACK;
        final SecondaryCategories testSecondaryCategory = SecondaryCategories.CRACKER;
        final int count = 2;
        // given
        IntStream.rangeClosed(1, count)
                .forEach(i -> {
                    Item item = Item.builder()
                            .name("item-" + i)
                            .price(1000L)
                            .stock(100L)
                            .primaryCategory(testPrimaryCategory)
                            .secondaryCategory(testSecondaryCategory)
                            .build();

                    itemRepository.save(item);
                });

        // when & then
        List<ItemSimpleDto> items = categoryService.findAllItemByPrimaryCategory(testPrimaryCategory.name());
        assertEquals(count, items.size());
        assertTrue(items.stream()
                .allMatch(i -> i.getPrimaryCategory().equals(testPrimaryCategory.getName())));
        assertTrue(items.stream()
                .allMatch(i -> i.getSecondaryCategory().equals(testSecondaryCategory.getName())));

        items = categoryService.findAllItemByPrimaryCategory(PrimaryCategories.MEAT.name());
        assertTrue(items.isEmpty());
    }
}