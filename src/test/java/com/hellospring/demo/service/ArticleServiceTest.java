package com.hellospring.demo.service;

import com.hellospring.demo.domain.Article;
import com.hellospring.demo.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {
    @InjectMocks
    ArticleService articleService;

    @Mock
    ArticleRepository articleRepository;

    @Test
    void it_should_create_article() {
        //given
        var article = Mockito.mock(Article.class);

        //when
        Boolean isCreated = articleService.createArticle(article);

        //then
        verify(articleRepository).save(article);
        assertThat(isCreated).isTrue();

    }

    @Test
    void it_should_not_create_article_when_exception_occurred() {
        //given
        Article article = Mockito.mock(Article.class);
        given(articleRepository.save(article)).willThrow(RuntimeException.class);

        //when
        Boolean isCreated = articleService.createArticle(article);

        //then
        assertThat(isCreated).isFalse();

    }

    @Test
    void it_should_get_article_with_id() {
        //given
        Article article = new Article();
        article.setId("123");
        article.setTitle("title");
        article.setAuthorId("111");
        article.setContent("content");
        article.setCreateDate(new Date());
        article.setUpdateDate(new Date());

        given(articleRepository.findById("123")).willReturn(Optional.of(article));

        //when
        Optional<Article> optArticle = articleService.getArticle("123");

        //then
        assertThat(optArticle.isPresent()).isTrue();
        Article originalArticle = optArticle.get();
        assertThat(originalArticle.getId()).isEqualTo("123");
        assertThat(originalArticle.getTitle()).isEqualTo("title");
        assertThat(originalArticle.getAuthorId()).isEqualTo("111");
        assertThat(originalArticle.getContent()).isEqualTo("content");
        assertThat(originalArticle.getCreateDate()).isNotNull();
        assertThat(originalArticle.getUpdateDate()).isNotNull();
    }

    @Test
    void it_should_not_get_article_with_id() {
        //given
        given(articleRepository.findById("123")).willReturn(Optional.empty());

        //when
        Optional<Article> optArticle = articleService.getArticle("123");

        //then
        assertThat(optArticle.isPresent()).isFalse();

    }

    @Test
    void it_should_not_get_article_when_exception_occurred() {
        //given
        given(articleRepository.findById("123")).willThrow(RuntimeException.class);

        //when
        Optional<Article> optArticle = articleService.getArticle("123");

        //then
        assertThat(optArticle.isPresent()).isFalse();
    }
}