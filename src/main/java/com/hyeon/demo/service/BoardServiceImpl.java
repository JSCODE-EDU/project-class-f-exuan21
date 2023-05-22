package com.hyeon.demo.service;

import com.hyeon.demo.dto.BoardRequest;
import com.hyeon.demo.Entity.Board;
import com.hyeon.demo.Repository.BoardRepository;
import com.hyeon.demo.exception.ErrorCode;
import com.hyeon.demo.exception.domain.MyCustomException;
import org.hibernate.dialect.identity.MySQLIdentityColumnSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    BoardRepository repository;

    @Autowired
    public BoardServiceImpl(BoardRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Board> findAll(String title, Pageable pageable) {
        return repository.findByTitleContaining(title, pageable);
    }

    @Override
    public Board save(BoardRequest boardRequest) {
        return repository.save(boardRequest.toEntity());
    }

    @Override
    public Board findOne(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new MyCustomException(ErrorCode.NOT_FOUND));
    }

    @Override
    public Board update(int id, BoardRequest boardRequest) {
        Optional<Board> board = repository.findById(id);
        if(board.isPresent()) {
            board.get().update(boardRequest.getTitle(), boardRequest.getContent());
            return board.get();
        } else {
            throw new MyCustomException(ErrorCode.NOT_FOUND);
        }
    }

    @Override
    public boolean delete(int id) {
        Optional<Board> board = repository.findById(id);
        if(board.isPresent()) {
            repository.deleteById(id);
            return true;
        } else {
            throw new MyCustomException(ErrorCode.NOT_FOUND);
        }
    }
}
