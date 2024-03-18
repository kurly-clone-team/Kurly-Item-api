package com.example.kurlyitem.item.api;

import com.example.kurlyitem.item.dto.ItemDetailsDto;
import com.example.kurlyitem.item.service.ItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/goods")
@Tag(name = "Item API", description = "상품 관련 API 제공")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemDetailsDto> findItemById(@PathVariable Long itemId) {
        ItemDetailsDto itemDetailsDto = itemService.findItem(itemId);
        return ResponseEntity.ok(itemDetailsDto);
    }
}
