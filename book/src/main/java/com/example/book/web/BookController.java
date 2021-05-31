package com.example.book.web;
import com.example.book.model.Book;
import com.example.book.service.AuthorService;
import com.example.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping({"/", "/books"})
    public String showProducts(@RequestParam(required = false) String nameSearch, Model model) {
        List<Book> books;
        books = this.bookService.listAllBooks();
        model.addAttribute("books", books);
        return "list.html";
    }

    @GetMapping("/books/add")
    public String showAdd(Model model) {
        List<Book> books = this.bookService.listAllBooks();
        model.addAttribute("books", books);
        return "form.html";
    }

    @GetMapping("/books/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model) {
        Book book = this.bookService.findById(id);
        model.addAttribute("book", book);
        return "form.html";
    }

    @PostMapping("/books")
    public String create(@RequestParam Long id, @RequestParam String name,
                         @RequestParam Integer releaseYear) {
        this.bookService.create(id, name, releaseYear);
        return "redirect:/books";
    }

    @PostMapping("/books/{id}")
    public String update(@RequestParam Long id, @RequestParam String name,
                         @RequestParam Integer releaseYear) {
        this.bookService.update(id, name, releaseYear);
        return "redirect:/books";
    }

    @PostMapping("/books/{id}/delete")
    public String delete(@PathVariable Long id) {
        this.bookService.delete(id);
        return "redirect:/books";
    }
}