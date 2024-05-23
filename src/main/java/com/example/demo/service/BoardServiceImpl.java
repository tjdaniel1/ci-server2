package com.example.demo.service;

import com.example.demo.domain.entity.Board;
import com.example.demo.domain.request.BoardRequest;
import com.example.demo.domain.response.BoardResponse;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Override
    public BoardResponse getById(Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return BoardResponse.of(board);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Board> byId = boardRepository.findById(id);
        byId.orElseThrow(IllegalArgumentException::new);
        boardRepository.deleteById(id);
    }

    @Override
    public List<BoardResponse> getAll() {
        return boardRepository.findAll()
                .stream()
                .map(BoardResponse::of)
                .toList();
    }

    @Override
    public void saveBoard(BoardRequest request) {
        boardRepository.save(request.toEntity());
    }
}
