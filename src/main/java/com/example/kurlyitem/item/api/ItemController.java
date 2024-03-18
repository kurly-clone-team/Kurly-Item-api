package com.example.kurlyitem.item.api;

import com.example.kurlyitem.item.dto.ItemDetailsDto;
import com.example.kurlyitem.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/goods")
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemDetailsDto> findItemById(@PathVariable Long itemId) {
        ItemDetailsDto itemDetailsDto = itemService.findItem(itemId);
        return ResponseEntity.ok(itemDetailsDto);
    }
}
