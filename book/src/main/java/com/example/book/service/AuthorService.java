package com.example.book.service;
import com.example.book.model.Author;

import java.util.List;

public interface AuthorService {

    Author findById(Long id);

    List<Author> listAll();

    Author create(String name);
}
