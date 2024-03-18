package com.example.kurlyitem.item.dto;

import com.example.kurlyitem.item.Item;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemDetailsDto {

    private String name;

    private String description;

    private Long price;

    public static ItemDetailsDto of(Item item) {
        return ItemDetailsDto.builder()
                .name(item.getName())
                .price(item.getPrice())
                .build();
    }
}
