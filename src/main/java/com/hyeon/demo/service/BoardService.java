package com.hyeon.demo.service;

import com.hyeon.demo.model.Board;

import java.util.List;

public interface BoardService {

    // 리스트 조회
    List<Board> findAllBoards();

    // 특정 한 게시글 조회
    Board findOneBoard(String boardId);

    // 게시글 등록
    Board insertBoard(Board board);

    // 게시글 업데이트
    Board updateBoard(Board board);

    // 게시글 삭제
    Board deleteBoard(Board board);

}
