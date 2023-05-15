package com.hyeon.demo.service;

import com.hyeon.demo.dao.BoardRequest;
import com.hyeon.demo.dto.Board;

import java.util.List;

public interface BoardService {

    // 리스트 조회
    List<Board> findAll();

    // 저장
    Board save(BoardRequest boardRequest);

    // 특정 게시판 하나만 조회
    Board findOne(int id);

    // 수정
    Board update(int id, BoardRequest boardRequest);

    // 삭제
    void delete(int id);
}
