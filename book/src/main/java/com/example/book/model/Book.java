package com.example.book.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    
    public Book() {
    }

    public Book(Long id, String name, Integer releaseYear) {
        this.id = id;
        this.name = name;
        this.releaseYear = releaseYear;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "releaseYear")
    private Integer releaseYear;

    @Enumerated(EnumType.STRING)
    private TypeBook e_book;

    @Enumerated(EnumType.STRING)
    private TypeBook printCopy;



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public TypeBook getE_book() {
        return e_book;
    }

    public TypeBook getPrintCopy() {
        return printCopy;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setE_book(TypeBook e_book) {
        this.e_book = e_book;
    }

    public void setPrintCopy(TypeBook printCopy) {
        this.printCopy = printCopy;
    }

}