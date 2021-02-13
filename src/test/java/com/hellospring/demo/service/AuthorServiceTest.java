package com.hellospring.demo.service;

import com.hellospring.demo.domain.Author;
import com.hellospring.demo.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doThrow;
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

    @Test
    void it_should_get_author_with_id() {
        //given
        Author author = new Author();
        author.setId("123");
        author.setName("name");
        author.setSurname("surname");
        author.setBio("bio");
        author.setArticleCount(5);
        author.setCreateDate(new Date());
        author.setUpdateDate(new Date());

        given(authorRepository.findById("123")).willReturn(Optional.of(author));

        //when
        Optional<Author> optAuthor = authorService.getAuthor("123");

        //then
        assert optAuthor.isPresent();
        Author originalAuthor = optAuthor.get();
        assertThat(originalAuthor.getId()).isEqualTo("123");
        assertThat(originalAuthor.getName()).isEqualTo("name");
        assertThat(originalAuthor.getSurname()).isEqualTo("surname");
        assertThat(originalAuthor.getBio()).isEqualTo("bio");
        assertThat(originalAuthor.getArticleCount()).isEqualTo(5);
        assertThat(originalAuthor.getCreateDate()).isNotNull();
        assertThat(originalAuthor.getUpdateDate()).isNotNull();
    }

    @Test
    void it_should_not_get_author_when_exception_occurred() {
        //given
        given(authorRepository.findById("123")).willThrow(RuntimeException.class);

        //when
        Optional<Author> optAuthor = authorService.getAuthor("123");

        //then
        assert optAuthor.isEmpty();
    }

    @Test
    void it_should_update_author_name() {
        //given
        Author author = new Author();
        author.setId("123");
        author.setName("new_name");
        author.setSurname("surname");
        author.setBio("bio");
        author.setArticleCount(5);
        author.setCreateDate(new Date());
        author.setUpdateDate(new Date());

        given(authorRepository.findById("123")).willReturn(Optional.of(author));

        //when
        Optional<Author> optAuthor = authorService.updateName("123", "new_name");

        //then
        verify(authorRepository).updateName("123", "new_name");
        assert optAuthor.isPresent();
        Author originalAuthor = optAuthor.get();
        assertThat(originalAuthor.getId()).isEqualTo("123");
        assertThat(originalAuthor.getName()).isEqualTo("new_name");
        assertThat(originalAuthor.getSurname()).isEqualTo("surname");
        assertThat(originalAuthor.getBio()).isEqualTo("bio");
        assertThat(originalAuthor.getArticleCount()).isEqualTo(5);
        assertThat(originalAuthor.getCreateDate()).isNotNull();
        assertThat(originalAuthor.getUpdateDate()).isNotNull();
    }

    @Test
    void it_should_not_update_author_name_when_exception_occurred() {
        //given
        given(authorRepository.findById("123")).willThrow(RuntimeException.class);
        //when
        Optional<Author> optAuthor = authorService.updateName("123", "new_name");

        //then
        verify(authorRepository).updateName("123", "new_name");
        assert optAuthor.isEmpty();
    }

    @Test
    void it_should_update_author_surname_with_id() {
        //given
        Author author = new Author();
        author.setId("123");
        author.setName("name");
        author.setSurname("new_surname");
        author.setBio("bio");
        author.setArticleCount(5);
        author.setCreateDate(new Date());
        author.setUpdateDate(new Date());

        given(authorRepository.findById("123")).willReturn(Optional.of(author));

        //when
        Optional<Author> optAuthor = authorService.updateSurname("123", "new_surname");

        //then
        verify(authorRepository).updateSurname("123", "new_surname");
        assert optAuthor.isPresent();
        Author originalAuthor = optAuthor.get();
        assertThat(originalAuthor.getId()).isEqualTo("123");
        assertThat(originalAuthor.getName()).isEqualTo("name");
        assertThat(originalAuthor.getSurname()).isEqualTo("new_surname");
        assertThat(originalAuthor.getBio()).isEqualTo("bio");
        assertThat(originalAuthor.getArticleCount()).isEqualTo(5);
        assertThat(originalAuthor.getCreateDate()).isNotNull();
        assertThat(originalAuthor.getUpdateDate()).isNotNull();
    }

    @Test
    void it_should_not_update_author_surname_when_exception_occurred() {
        //given
        given(authorRepository.findById("123")).willThrow(RuntimeException.class);

        //when
        Optional<Author> optAuthor = authorService.updateSurname("123", "new_surname");

        //then
        verify(authorRepository).updateSurname("123", "new_surname");
        assert optAuthor.isEmpty();
    }

    @Test
    void it_should_update_author_bio_with_id() {
        //given
        Author author = new Author();
        author.setId("123");
        author.setName("name");
        author.setSurname("surname");
        author.setBio("new_bio");
        author.setArticleCount(5);
        author.setCreateDate(new Date());
        author.setUpdateDate(new Date());

        given(authorRepository.findById("123")).willReturn(Optional.of(author));

        //when
        Optional<Author> optAuthor = authorService.updateBio("123", "new_bio");

        //then
        verify(authorRepository).updateBio("123", "new_bio");
        assert optAuthor.isPresent();
        Author originalAuthor = optAuthor.get();
        assertThat(originalAuthor.getId()).isEqualTo("123");
        assertThat(originalAuthor.getName()).isEqualTo("name");
        assertThat(originalAuthor.getSurname()).isEqualTo("surname");
        assertThat(originalAuthor.getBio()).isEqualTo("new_bio");
        assertThat(originalAuthor.getArticleCount()).isEqualTo(5);
        assertThat(originalAuthor.getCreateDate()).isNotNull();
        assertThat(originalAuthor.getUpdateDate()).isNotNull();

    }

    @Test
    void it_should_not_update_author_bio_when_exception_occurred() {
        //given
        given(authorRepository.findById("123")).willThrow(RuntimeException.class);

        //when
        Optional<Author> optAuthor = authorService.updateBio("123", "new_bio");

        //then
        verify(authorRepository).updateBio("123", "new_bio");
        assert optAuthor.isEmpty();
    }

    @Test
    void it_should_delete_author() {
        //given&&when
        Boolean isDeleted = authorService.deleteAuthor("123");

        //then
        verify(authorRepository).deleteById("123");
        assert isDeleted;
    }

    @Test
    void it_should_not_delete_author_when_exception_occurred() {
        //given
        doThrow(RuntimeException.class).when(authorRepository).deleteById("123");

        //when
        Boolean isDeleted = authorService.deleteAuthor("123");

        //then
        assert !isDeleted;
    }
}