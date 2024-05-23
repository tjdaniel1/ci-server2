package com.example.demo.domain.response;

import com.example.demo.domain.entity.Board;

public record BoardResponse(
        Long id,
        String name,
        String text
) {
    public static BoardResponse of(Board board){
        return new BoardResponse(board.getId(), board.getName(), board.getText());
    }
}
