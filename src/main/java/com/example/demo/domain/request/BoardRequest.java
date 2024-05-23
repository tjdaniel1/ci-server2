package com.example.demo.domain.request;

import com.example.demo.domain.entity.Board;

public record BoardRequest(
        String name, String text
) {
    public Board toEntity(){
        return new Board(null, name, text);
    }
}
