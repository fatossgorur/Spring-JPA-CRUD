package com.hellospring.demo.service;

import com.hellospring.demo.domain.Author;
import com.hellospring.demo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Boolean createAuthor(Author author) {
        try {
            authorRepository.save(author);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Optional<Author> getAuthor(String id) {
        try {
            return authorRepository.findById(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Author> updateName(String id, String name) {
        try {
            authorRepository.updateName(id, name);
            return authorRepository.findById(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Author> updateSurname(String id, String surname) {
        try {
            authorRepository.updateSurname(id, surname);
            return authorRepository.findById(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<Author> updateBio(String id, String bio) {
        try {
            authorRepository.updateBio(id, bio);
            return authorRepository.findById(id);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Boolean deleteAuthor(String id) {
        try {
            authorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
