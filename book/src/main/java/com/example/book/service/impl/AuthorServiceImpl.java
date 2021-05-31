package com.example.book.service.impl;

import com.example.book.model.Author;
import com.example.book.model.exceptions.InvalidAuthorIdException;
import com.example.book.repository.AuthorRepository;
import com.example.book.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository.findById(id).orElseThrow(InvalidAuthorIdException::new);
    }

    @Override
    public List<Author> listAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author create(String name) {
        return null;
    }

    //  @Override
    // public Author create(String name) {
    //     Author author=new Author(name);
    //    return this.authorRepository.save(author);
    // }
}
