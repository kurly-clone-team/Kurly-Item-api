package com.example.kurlyitem.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ItemException extends RuntimeException{

    private final ExceptionCode exceptionCode;
}
