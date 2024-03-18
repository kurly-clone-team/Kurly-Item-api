package com.example.kurlyitem.exception.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExceptionResponse {

    private final String code;
    private final String message;
}
