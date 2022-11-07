package com.example.bbs.domain.dto;


import com.example.bbs.entity.Article;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.PostMapping;

@Getter
@ToString
public class ArticleDto {
    private Long id;
    private String title;
    private String content;

    public ArticleDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Article toEntity() {
        return new Article(title, content);
    }
}
