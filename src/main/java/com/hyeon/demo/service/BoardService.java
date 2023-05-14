package com.hyeon.demo.service;

import com.hyeon.demo.dao.BoardRequest;
import com.hyeon.demo.dto.Board;

import java.util.List;

public interface BoardService {

    // 리스트 조회
    List<Board> findAll();

    // 저장
    Board save(BoardRequest boardRequest);

}
