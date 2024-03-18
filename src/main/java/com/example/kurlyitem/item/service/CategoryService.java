package com.example.kurlyitem.item.service;

import com.example.kurlyitem.item.Item;
import com.example.kurlyitem.item.categories.PrimaryCategories;
import com.example.kurlyitem.item.categories.SecondaryCategories;
import com.example.kurlyitem.item.dto.ItemSimpleDto;
import com.example.kurlyitem.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final ItemRepository itemRepository;

    public List<ItemSimpleDto> findAllItemByPrimaryCategory(String primaryCategoryKey) {
        PrimaryCategories primaryCategory = PrimaryCategories.getPrimaryCategory(primaryCategoryKey);

        List<Item> items = itemRepository.findAllByPrimaryCategory(primaryCategory);
        return items.stream()
                .map(ItemSimpleDto::of)
                .toList();
    }

    public List<ItemSimpleDto> findAllItemBySecondaryCategory(String secondaryCategoryKey) {
        SecondaryCategories secondaryCategory = SecondaryCategories.getSecondaryCategory(secondaryCategoryKey);

        List<Item> items = itemRepository.findAllBySecondaryCategory(secondaryCategory);
        return items.stream()
                .map(ItemSimpleDto::of)
                .toList();
    }

    public List<ItemSimpleDto> findAllItemByFilteredPrice(Long categoryId, Long pageNumber, Long lowPrice, Long highPrice) {
        return null;
    }
}
