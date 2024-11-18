package com.hhmarket.hhmarket.dto;

import com.hhmarket.hhmarket.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemResponseDto {
    private Long id;

    private String title;

    private String content;

    private int price;

    private String username;

    public ItemResponseDto(Item item){
        this.id = item.getId();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
        this.username = item.getUsername();
    }
}
