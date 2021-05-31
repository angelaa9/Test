package com.example.book.service.impl;
import com.example.book.model.Book;
import com.example.book.model.exceptions.InvalidBookIdException;
import com.example.book.repository.BookRepository;
import com.example.book.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAllBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepository.findById(id).orElseThrow(InvalidBookIdException::new);
    }

    @Override
    public Book create(Long id, String name, Integer releaseYear) {
        Book book = new Book(id, name, releaseYear);
        return this.bookRepository.save(book);
    }

    @Override
    public Book update(Long id, String name, Integer releaseYear) {
        Book book=this.findById(id);
        book.setName(name);
        book.setReleaseYear(releaseYear);
        return this.bookRepository.save(book);
    }

    @Override
    public Book delete(Long id) {
        Book book = this.findById(id);
        this.bookRepository.delete(book);
        return book;
    }


}
