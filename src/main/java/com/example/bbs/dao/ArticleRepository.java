package com.example.bbs.dao;

import com.example.bbs.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long>
{
}
