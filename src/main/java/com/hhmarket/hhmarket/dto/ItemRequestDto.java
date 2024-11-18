package com.hhmarket.hhmarket.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemRequestDto {
    private String title;

    private String content;

    private int price;

    private String username;
}
