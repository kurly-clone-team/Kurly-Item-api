package com.example.kurlyitem.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ExceptionCode {

    NOT_FOUND_CATEGORY(HttpStatus.BAD_REQUEST, "존재하지 않는 카테고리입니다."),
    NOT_FOUND_ITEM(HttpStatus.BAD_REQUEST, "존재하지 않는 상품입니다."),
    IN_USE_ITEM_NAME(HttpStatus.BAD_REQUEST, "사용 중인 상품명입니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
