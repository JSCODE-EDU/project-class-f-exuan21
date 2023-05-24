package com.hyeon.demo.dto;

import com.hyeon.demo.Entity.Board;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardRequest {

    @NotBlank(message = "제목은 NULL이 아니어야 합니다.")
    @Size(max = 15)
    private String title;

    @Size(min = 1, max = 1000)
    private String content;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }

}
