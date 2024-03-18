package com.example.kurlyitem.item.categories;

import com.example.kurlyitem.exception.CategoryException;
import com.example.kurlyitem.exception.ExceptionCode;
import lombok.Getter;

import java.util.Locale;

@Getter
public enum PrimaryCategories {
    FRUIT("과일"),
    MEAT("정육"),
    SNACK("스낵"),
    BAKERY("베이커리");

    private final String name;

    PrimaryCategories(String name) {
        this.name = name;
    }

    public static PrimaryCategories getPrimaryCategory(String category) {
        try {
            if(category != null)
                return valueOf(category.toUpperCase(Locale.ROOT));
            throw new CategoryException(ExceptionCode.NOT_FOUND_CATEGORY);
        } catch (IllegalArgumentException e) {
            throw new CategoryException(ExceptionCode.NOT_FOUND_CATEGORY);
        }
    }
}