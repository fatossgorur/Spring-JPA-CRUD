package com.hellospring.demo.service;

import com.hellospring.demo.domain.Article;
import com.hellospring.demo.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void it_should_create_article(){
        //given
        var article = Mockito.mock(Article.class);

        //when
        Boolean isCreated = articleService.createArticle(article);

        //then
        verify(articleRepository).save(article);
        assertThat(isCreated).isTrue();

    }
    @Test
    void it_should_not_create_article_when_exception_occurred(){
        //given
        Article article = Mockito.mock(Article.class);
        given(articleRepository.save(article)).willThrow(RuntimeException.class);

        //when
        Boolean isCreated = articleService.createArticle(article);

        //then
        assertThat(isCreated).isFalse();

    }

}