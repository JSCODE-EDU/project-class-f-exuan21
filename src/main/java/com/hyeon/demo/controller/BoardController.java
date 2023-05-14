package com.hyeon.demo.controller;

import com.hyeon.demo.dao.BoardRequest;
import com.hyeon.demo.dto.Board;
import com.hyeon.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping()
    public ResponseEntity<List<Board>> findAllBoards() {
        List<Board> boards = boardService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(boards);
    }

    @PostMapping()
    public ResponseEntity<Board> addBoard(@RequestBody BoardRequest boardRequest) {
        Board board = boardService.save(boardRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(board);
    }

}
