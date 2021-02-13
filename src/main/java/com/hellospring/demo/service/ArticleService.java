package com.hellospring.demo.service;

import com.hellospring.demo.domain.Article;
import com.hellospring.demo.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Boolean createArticle(Article article) {
        try {
            articleRepository.save(article);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Optional<Article> getArticle(String id){
        try{
            return articleRepository.findById(id);
        }catch (Exception e){
            return Optional.empty();
        }

    }
}
