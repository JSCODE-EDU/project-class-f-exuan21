package com.hyeon.demo.service;

import com.hyeon.demo.model.Board;
import com.hyeon.demo.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    BoardRepository repository;

    @Autowired
    public BoardServiceImpl(BoardRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Board> findAllBoards() {
        return this.repository.findAllBoards();
    }

    @Override
    public Board findOneBoard(String boardId) {
        return this.repository.findOneBoard(boardId);
    }

    @Override
    public Board insertBoard(Board board) {
        this.repository.insertBoard(board);
        return board;
    }

    @Override
    public Board updateBoard(Board board) {
         this.repository.updateBoard(board);
         return board;
    }

    @Override
    public Board deleteBoard(Board board) {
        this.repository.deleteBoard(board.getId());
        return board;
    }
}
