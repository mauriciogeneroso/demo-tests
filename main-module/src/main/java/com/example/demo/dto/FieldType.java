package com.example.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FieldType {
    STRING("string"),
    NUMBER("number");

    private final String name;
}
