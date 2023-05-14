package com.hyeon.demo.service;

import com.hyeon.demo.dao.BoardRequest;
import com.hyeon.demo.dto.Board;
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
    public List<Board> findAll() {
        return repository.findAll();
    }

    @Override
    public Board save(BoardRequest boardRequest) {
        return repository.save(boardRequest.toEntity());
    }
}
