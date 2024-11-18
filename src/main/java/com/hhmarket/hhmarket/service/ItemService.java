package com.hhmarket.hhmarket.service;

import com.hhmarket.hhmarket.dto.ItemRequestDto;
import com.hhmarket.hhmarket.dto.ItemResponseDto;
import com.hhmarket.hhmarket.dto.ItemSummaryDto;
import com.hhmarket.hhmarket.entity.Item;
import com.hhmarket.hhmarket.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemResponseDto createPost(ItemRequestDto itemRequestDto) {
        Item item = itemRepository.save(new Item(itemRequestDto));
        return new ItemResponseDto(item);
    }


    public List<ItemSummaryDto> getAllPosts() {
        return itemRepository.findAll().stream().map(ItemSummaryDto::new).collect(Collectors.toList());
    }

    @Transactional
    public ItemResponseDto updatePost(Long id, ItemRequestDto itemRequestDto) {
        Item item = itemRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        item.update(itemRequestDto);
        return new ItemResponseDto(item);
    }

    public void deletePost(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시물이 존재하지 않습니다."));
        itemRepository.deleteById(id);
    }
}
