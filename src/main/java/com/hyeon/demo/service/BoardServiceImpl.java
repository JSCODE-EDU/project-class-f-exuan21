package com.hyeon.demo.service;

import com.hyeon.demo.dto.BoardRequest;
import com.hyeon.demo.Entity.Board;
import com.hyeon.demo.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class BoardServiceImpl implements BoardService {

    BoardRepository repository;

    @Autowired
    public BoardServiceImpl(BoardRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Board> findAll(String title, String order, Pageable pageable) {
        if(order.equalsIgnoreCase("DESC")) {
            return repository.findByTitleContainingOrderByCreatedAtDesc(title, pageable);
        } else {
            return repository.findByTitleContainingOrderByCreatedAtAsc(title, pageable);
        }
    }

    @Override
    public Board save(BoardRequest boardRequest) {
        return repository.save(boardRequest.toEntity());
    }

    @Override
    public Board findOne(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
    }

    @Override
    @Transactional
    public Board update(int id, BoardRequest boardRequest) {
        Board board = repository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("not found : " + id));
        board.update(boardRequest.getTitle(), boardRequest.getContent());
        return board;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
