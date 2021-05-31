package com.example.book.service;
import com.example.book.model.Book;
import java.util.List;

public interface BookService {

    List<Book> listAllBooks();

    Book findById(Long id);

    Book create(Long id, String name, Integer releaseYear);

    Book update(Long id, String name, Integer releaseYear);

    Book delete(Long id);


}
