package com.hyeon.demo.dto;

import com.hyeon.demo.Entity.Board;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BoardRequest {

    @NotBlank(message = "Title must not be null.")
    private String title;
    @NotBlank(message = "Content must not be null.")
    private String content;

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }

}
