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

    public Optional<Article> getArticle(String id) {
        try {
            return articleRepository.findById(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Article> updateTitle(String id, String title) {
        try {
            articleRepository.updateTitle(id, title);
            return articleRepository.findById(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Article> updateContent(String id, String content) {
        try {
            articleRepository.updateContent(id, content);
            return articleRepository.findById(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Boolean deleteArticle(String id) {
        try {
            articleRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
