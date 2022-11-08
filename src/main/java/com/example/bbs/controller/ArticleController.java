package com.example.bbs.controller;

import com.example.bbs.dao.ArticleRepository;
import com.example.bbs.domain.dto.ArticleDto;
import com.example.bbs.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articlerepository) {
        this.articleRepository = articlerepository;
    }

    @GetMapping("/new")
    public String createArticle(){
        return "articles/new";
    }

    @GetMapping("/{id}")
    public String selectSingle(@PathVariable Long id, Model model){
        Optional<Article> optionalArticle = articleRepository.findById(id);

        if(!optionalArticle.isEmpty()){
            model.addAttribute("article", optionalArticle.get());
            return "articles/show";
        } else {
            return "articles/error";
        }
    }

//    @GetMapping("/list")
//    public String list(){
//        return "articles/list";
//    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articles = articleRepository.findAll();
        model.addAttribute("articles", articles);
        return "articles/list";

    }

    @GetMapping("")
    public String index(){
        return "redirect:/articles/list";
    }


    @PostMapping("")
    public String add(ArticleDto articleDto) {
        log.info(articleDto.getTitle());
        Article savedArticle = articleRepository.save(articleDto.toEntity());
        log.info("generatedId:{}", savedArticle.getId());
        // souf %d %s
        return String.format("redirect:/articles/%d", savedArticle.getId());
    }
}