package com.example.demo.controller;

import com.example.demo.domain.response.BoardResponse;
import com.example.demo.service.BoardServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(BoardController.class)
class BoardControllerTest {
    @MockBean
    private BoardServiceImpl boardService;
    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllBoard() throws Exception {
        //given
        BDDMockito.given(boardService.getAll())
                .willReturn(List.of(
                        new BoardResponse(1l,"test1","test1"),
                        new BoardResponse(2l,"test2","test2"),
                        new BoardResponse(3l,"test3","test3")
                ));
        //when & then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/boards"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3))//검증
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print()); //하는거

    }

    @Test
    void getByIdBoard() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/boards/1"))
//                .andExpect(MockMvcResultMatchers.status().is5xxServerError());
        //given
        BDDMockito.given(boardService.getById(1l))
                .willReturn(new BoardResponse(1l, "test1", "test1"));


        //when & then
        mockMvc.perform(MockMvcRequestBuilders.get("/api/boards/1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(3))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void saveBoard() {
    }
}