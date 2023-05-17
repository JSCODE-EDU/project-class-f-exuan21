package com.hyeon.demo.controller;

import com.hyeon.demo.dto.BoardRequest;
import com.hyeon.demo.Entity.Board;
import com.hyeon.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/boards")
public class BoardController {

    BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping()
    public ResponseEntity<List<Board>> findAllBoards(@RequestParam String title, @RequestParam String order, Pageable pageable) {
        List<Board> boards = boardService.findAll(title, order, pageable);
        return ResponseEntity.status(HttpStatus.OK)
                .body(boards);
    }

    @PostMapping()
    public ResponseEntity<?> addBoard(@Validated @RequestBody BoardRequest boardRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(errorMessages);
        }
        Board board = boardService.save(boardRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(board);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOneBoard(@PathVariable int id) {
        Board board = boardService.findOne(id);
        if(board == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Invalid Board Id.");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(board);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable int id, @Validated @RequestBody BoardRequest boardRequest, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            List<String> errorMessages = bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(errorMessages);
        }
        Board board = boardService.update(id, boardRequest);
        return ResponseEntity.status(HttpStatus.OK)
                .body(board);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable int id) {
        boolean isDeleted = boardService.delete(id);
        if(!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Invalid Board Id.");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .build();
    }

}
