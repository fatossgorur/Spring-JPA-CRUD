package com.hellospring.demo.service;

import com.hellospring.demo.domain.Author;
import com.hellospring.demo.repository.ArticleRepository;
import com.hellospring.demo.repository.AuthorRepository;
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
class AuthorServiceTest {
    @InjectMocks
    AuthorService authorService;

    @Mock
    AuthorRepository authorRepository;

    @Test
    void it_should_create_author() {
        //given
        Author author = Mockito.mock(Author.class);

        //when
        Boolean isCreated = authorService.createAuthor(author);

        //then
        verify(authorRepository).save(author);
        assertThat(isCreated).isTrue();
    }

    @Test
    void it_should_not_create_author_when_exception_occurred() {
        //given
        Author author = Mockito.mock(Author.class);
        given(authorRepository.save(author)).willThrow(RuntimeException.class);
        //when
        Boolean isCreated = authorService.createAuthor(author);

        //then
        assertThat(isCreated).isFalse();

    }
}