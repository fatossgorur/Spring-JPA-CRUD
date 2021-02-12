package com.hellospring.demo.service;

import com.hellospring.demo.domain.Author;
import com.hellospring.demo.repository.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Boolean createAuthor(Author author){
        try {
            authorRepository.save(author);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
