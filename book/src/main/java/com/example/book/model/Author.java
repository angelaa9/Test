package com.example.book.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Author {

    public Author (Long id, String name, String surname, Integer year, List<Book> books) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.books = books;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "year")
    private Integer year;

    @OneToMany
    private List<Book> books;

    public Author() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getYear() {
        return year;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
