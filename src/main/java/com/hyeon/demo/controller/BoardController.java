package com.hyeon.demo.controller;

import com.hyeon.demo.dto.BoardRequest;
import com.hyeon.demo.Entity.Board;
import com.hyeon.demo.service.BoardService;
import jakarta.validation.constraints.NotBlank;
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
    public ResponseEntity<?> findAllBoards(@RequestParam("title") String title, Pageable pageable) {
        List<Board> boards = boardService.findAll(title.trim(), pageable);
        return ResponseEntity.status(HttpStatus.OK)
                .body(boards);
    }

    @PostMapping()
    public ResponseEntity<Board> addBoard(@Validated @RequestBody BoardRequest boardRequest) {
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
    public ResponseEntity<?> updateBoard(@PathVariable("id") int id, @Validated @RequestBody BoardRequest boardRequest) {
        Board board = boardService.update(id, boardRequest);
        if(board == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Invalid Board Id.");
        }
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
