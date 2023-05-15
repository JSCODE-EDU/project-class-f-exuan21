package com.hyeon.demo.dto;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity //Entity로 지정
@Getter
@DynamicInsert
public class Board {

    @Id // PK로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 자동으로 1씩 증가
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "is_deleted")
    @ColumnDefault("N") // 작동안함 jpa.hibernate.ddl-auto: create-drop 으로 설정하면 작동한다. -> 아예 create 구문을 돌릴 때 컬럼명 옆에 default "N"과 같이 속성을 넣겠단 의미
    private String isDeleted = "N";

    @Builder
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    protected Board() {

    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}
