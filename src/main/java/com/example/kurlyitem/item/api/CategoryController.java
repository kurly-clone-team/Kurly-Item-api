package com.example.kurlyitem.item.api;

import com.example.kurlyitem.item.dto.ItemSimpleDto;
import com.example.kurlyitem.item.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/primary/{primaryCategoryKey}")
    public ResponseEntity<List<ItemSimpleDto>> findAllItemsByPrimaryCategory(@PathVariable String primaryCategoryKey) {
        List<ItemSimpleDto> itemSimpleDtos = categoryService.findAllItemByPrimaryCategory(primaryCategoryKey);
        return ResponseEntity.ok(itemSimpleDtos);
    }

    @GetMapping("/secondary/{secondaryCategoryKey}")
    public ResponseEntity<List<ItemSimpleDto>> findAllItemsSecondaryCategory(@PathVariable String secondaryCategoryKey) {
        List<ItemSimpleDto> itemSimpleDtos = categoryService.findAllItemBySecondaryCategory(secondaryCategoryKey);
        return ResponseEntity.ok(itemSimpleDtos);
    }

    @GetMapping("/{categoryId}/{pageNumber}/{lowPrice}/{highPrice}")
    public ResponseEntity<List<ItemSimpleDto>> findAllItemByFilteredPrice(@PathVariable Long categoryId, @PathVariable Long pageNumber,
                                                                      @PathVariable Long lowPrice, @PathVariable Long highPrice
    ) {
        List<ItemSimpleDto> itemSimpleDtos = categoryService.findAllItemByFilteredPrice(categoryId, pageNumber, lowPrice, highPrice);
        return ResponseEntity.ok(itemSimpleDtos);
    }
}
