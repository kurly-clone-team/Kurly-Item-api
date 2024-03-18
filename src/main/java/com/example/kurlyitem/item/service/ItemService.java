package com.example.kurlyitem.item.service;

import com.example.kurlyitem.exception.ExceptionCode;
import com.example.kurlyitem.exception.ItemException;
import com.example.kurlyitem.item.Item;
import com.example.kurlyitem.item.dto.ItemDetailsDto;
import com.example.kurlyitem.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemDetailsDto findItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemException(ExceptionCode.NOT_FOUND_ITEM));

        return ItemDetailsDto.of(item);
    }
}