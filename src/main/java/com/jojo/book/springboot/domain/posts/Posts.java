package com.jojo.book.springboot.domain.posts;

import com.jojo.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity //ex) SalesManager.java -> sales_manager table 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭한다.
public class Posts extends BaseTimeEntity {

    @Id //테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //(PK의 생성 규칙을 나타낸다)
    private Long id;

    @Column(length = 500, nullable =  false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
