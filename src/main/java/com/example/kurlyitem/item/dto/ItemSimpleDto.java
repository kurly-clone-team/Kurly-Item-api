package com.example.kurlyitem.item.dto;

import com.example.kurlyitem.item.Item;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ItemSimpleDto {

    private String name;

    private Long price;

    private String primaryCategory;

    private String secondaryCategory;

    public static ItemSimpleDto of(Item item) {
        return ItemSimpleDto.builder()
                .name(item.getName())
                .price(item.getPrice())
                .primaryCategory(item.getPrimaryCategory().getName())
                .secondaryCategory(item.getSecondaryCategory().getName())
                .build();
    }
}
