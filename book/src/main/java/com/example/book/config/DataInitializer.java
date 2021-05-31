package com.example.book.config;
import com.example.book.service.BookService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final BookService bookService;

    public DataInitializer(BookService bookService) {
        this.bookService = bookService;
    }

    @PostConstruct
    public void initData() {

        for (int i = 1; i < 11; i++) {
            this.bookService.create( 1L, " ", 1);
        }
    }
}
