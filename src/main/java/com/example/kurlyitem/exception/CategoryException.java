package com.example.kurlyitem.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CategoryException extends RuntimeException {

    private final ExceptionCode exceptionCode;
}
