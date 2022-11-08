package com.example.bbs.controller;

import com.example.bbs.dao.ArticleRepository;
import com.example.bbs.domain.dto.ArticleDto;
import com.example.bbs.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository repository) {
        this.articleRepository = repository;
    }

    @GetMapping("/new")
    public String createArticle(){
        return "articles/new";
    }

    @PostMapping("/post")
    public String articles(ArticleDto articleDto) {
        log.info(articleDto.toString());
        articleRepository.save(articleDto.toEntity());
        return "";
    }
}