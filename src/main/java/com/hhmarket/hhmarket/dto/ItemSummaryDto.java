package com.hhmarket.hhmarket.dto;

import com.hhmarket.hhmarket.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemSummaryDto {
    private Long id;
    private String title;
    private int price;
    private String username;

    public ItemSummaryDto(Item item){
        this.id = item.getId();
        this.title = item.getTitle();
        this.price = item.getPrice();
        this.username = item.getUsername();
    }
}
