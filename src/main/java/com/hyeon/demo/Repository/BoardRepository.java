package com.hyeon.demo.Repository;

import com.hyeon.demo.dto.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
