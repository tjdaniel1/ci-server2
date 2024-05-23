package com.example.demo.service;

import com.example.demo.domain.request.BoardRequest;
import com.example.demo.domain.response.BoardResponse;

import java.util.List;

public interface BoardService {
    List<BoardResponse> getAll();
    void saveBoard(BoardRequest request);
    BoardResponse getById(Long id);
    void deleteById(Long id);
}
