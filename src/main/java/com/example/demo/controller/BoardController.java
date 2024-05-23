package com.example.demo.controller;

import com.example.demo.domain.request.BoardRequest;
import com.example.demo.domain.response.BoardResponse;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/boards")
@RequiredArgsConstructor
@CrossOrigin(
        allowedHeaders = "*",
        origins = "*",
        methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE, RequestMethod.OPTIONS }
)
public class BoardController {
    private final BoardService boardService;
    @GetMapping
    public List<BoardResponse> getAllBoard(){
        return boardService.getAll();
    }
    @GetMapping("{id}")
    public BoardResponse getByIdBoard(@PathVariable("id") Long id){
        return boardService.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBoard(@RequestBody BoardRequest request){
        boardService.saveBoard(request);
    }
}
