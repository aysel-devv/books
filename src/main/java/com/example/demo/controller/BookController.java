package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/available")
    public List<Book> getAvailableBooks(){
        return bookService.getAvailableBooks();
    }

    @GetMapping("/price/{maxPrice}")
    public List<Book> getBooksCheaperThan(@PathVariable double maxPrice){
        return bookService.getBooksCheaperThan(maxPrice);
    }

    @GetMapping("/authors")
    public List<String> getAuthors(){
        return bookService.getAuthors();
    }
}
