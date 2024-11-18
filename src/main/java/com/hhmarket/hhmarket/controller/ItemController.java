package com.hhmarket.hhmarket.controller;

import com.hhmarket.hhmarket.dto.ItemRequestDto;
import com.hhmarket.hhmarket.dto.ItemResponseDto;
import com.hhmarket.hhmarket.dto.ItemSummaryDto;
import com.hhmarket.hhmarket.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    // 판매 게시글 작성
    @PostMapping("/post")
    public ItemResponseDto createPost(@RequestBody ItemRequestDto itemRequestDto){
        return itemService.createPost(itemRequestDto);
    }

    // 판매 게시글 전체 리스트 조회
    @GetMapping("/post")
    public List<ItemSummaryDto> getAllPosts(){
        return itemService.getAllPosts();
    }

    // 판매글 수정
    @PutMapping("/post/{id}")
    public ItemResponseDto updatePost(@PathVariable Long id, @RequestBody ItemRequestDto itemRequestDto){
        return itemService.updatePost(id, itemRequestDto);
    }

    // 판매글 삭제
    @DeleteMapping("/post/{id}")
    public ResponseEntity<Map<String,String>> deletePost(@PathVariable Long id){

        try {
            itemService.deletePost(id);
            //성공 시 응답 메시지 반환
            Map<String, String> response = new HashMap<>();
            response.put("msg","삭제완료");
            return ResponseEntity.ok(response);
        }catch (IllegalArgumentException e){
            //예외 발생 시 응답
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("msg", e.getMessage());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }


}
