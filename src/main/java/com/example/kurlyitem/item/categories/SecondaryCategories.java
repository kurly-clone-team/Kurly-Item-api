package com.example.kurlyitem.item.categories;

import com.example.kurlyitem.exception.CategoryException;
import com.example.kurlyitem.exception.ExceptionCode;
import lombok.Getter;

import java.util.Locale;

@Getter
public enum SecondaryCategories {

    // fruit
    DOMESTIC("국산과일"),
    IMPORTED("수입과일"),
    FROZEN("냉동"),

    // meat
    BEEF("소고기"),
    PORK("돼지고기"),
    CHICKEN("닭*오리고기"),
    PORK_CUTLET("돈까스*떡갈비"),
    SAUSAGE("소시지"),
    bacon("베이컨"),

    // snack
    CRACKER("과자"),
    CHOCOLATE("초콜릿"),

    // bakery
    BREAD("식빵*베이글"),
    CAKE("케이크"),
    JAM("잼*스프레드");

    private final String name;

    SecondaryCategories(String name) {
        this.name = name;
    }

    public static SecondaryCategories getSecondaryCategory(String category) {
        try {
            if(category != null)
                return valueOf(category.toUpperCase(Locale.ROOT));
            throw new CategoryException(ExceptionCode.NOT_FOUND_CATEGORY);
        } catch (IllegalArgumentException e) {
            throw new CategoryException(ExceptionCode.NOT_FOUND_CATEGORY);
        }
    }
}
