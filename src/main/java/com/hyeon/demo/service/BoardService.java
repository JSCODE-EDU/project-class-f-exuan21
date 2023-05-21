package com.hyeon.demo.service;

import com.hyeon.demo.dto.BoardRequest;
import com.hyeon.demo.Entity.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BoardService {

    // 리스트 조회
    List<Board> findAll(String title, Pageable pageable);

    // 저장
    Board save(BoardRequest boardRequest);

    // 특정 게시판 하나만 조회
    Board findOne(int id);

    // 수정
    Board update(int id, BoardRequest boardRequest);

    // 삭제
    boolean delete(int id);
}
