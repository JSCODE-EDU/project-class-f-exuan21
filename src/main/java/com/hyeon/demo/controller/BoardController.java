package com.hyeon.demo.controller;

import com.hyeon.demo.dto.BoardRequest;
import com.hyeon.demo.dao.Board;
import com.hyeon.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
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

    @GetMapping("/{id}")
    public ResponseEntity<Board> findOneBoard(@PathVariable int id) {
        Board board = boardService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(board);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> updateBoard(@PathVariable int id, @RequestBody BoardRequest boardRequest) {
        Board board = boardService.update(id, boardRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(board);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable int id) {
        boardService.delete(id);
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }

}
