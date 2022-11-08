package com.example.bbs.domain.dto;


import com.example.bbs.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.web.bind.annotation.PostMapping;


@AllArgsConstructor
@Getter
@ToString
public class ArticleDto {
    private String title;

    public Article toEntity() {
        return new Article(this.title);
    }
}