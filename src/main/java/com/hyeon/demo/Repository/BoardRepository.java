package com.hyeon.demo.Repository;

import com.hyeon.demo.model.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BoardRepository {

    // 리스트 조회
    List<Board> findAllBoards();

    // 특정 한 게시글 조회
    Board findOneBoard(String boardId);

    // 게시글 등록
    void insertBoard(Board board);

    // 게시글 업데이트
    void updateBoard(Board board);

    // 게시글 삭제
    void deleteBoard(int boardId);

}
