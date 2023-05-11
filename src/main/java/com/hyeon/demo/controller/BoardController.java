package com.hyeon.demo.controller;

import com.hyeon.demo.model.Board;
import com.hyeon.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
        List<Board> boards = boardService.findAllBoards();
        return new ResponseEntity<>(boards, HttpStatus.OK);
    }

    @GetMapping("/{tableId}")
    public ResponseEntity<Board> findOneBoard(@PathVariable("tableId") String tableId) {
        Board board = boardService.findOneBoard(tableId);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Board> insertBoard(@RequestBody Board board) {
        boardService.insertBoard(board);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Board> updateBoard(@RequestBody Board board) {
        boardService.updateBoard(board);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Board> deleteBoard(@RequestBody Board board) {
        boardService.deleteBoard(board);
        return new ResponseEntity<>(board, HttpStatus.OK);
    }

}
