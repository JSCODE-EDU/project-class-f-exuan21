package com.hyeon.demo.Repository;

import com.hyeon.demo.Entity.Board;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    List<Board> findByTitleContainingOrderByCreatedAtDesc(String title, Pageable pageable);

    List<Board> findByTitleContainingOrderByCreatedAtAsc(String title, Pageable pageable);

}
