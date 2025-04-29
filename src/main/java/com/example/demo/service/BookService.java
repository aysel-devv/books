package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(@Qualifier("bookRepoV1") BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void init() {
        System.out.println("BookService initialized!");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("BookService is being cleaned up!");
    }

    public List<Book> getAvailableBooks() {
        System.out.println("Fetching available books...");

        return bookRepository.getBookList()
                .stream()
                .filter(Book::isInStock)
                .collect(Collectors.toList());
    }

    public List<Book> getBooksCheaperThan(double maxPrice) {
        return bookRepository.getBookList()
                .stream()
                .filter(book -> book.getPrice()<maxPrice)
                .collect(Collectors.toList());
    }

    public List<String> getAuthors(){
        return bookRepository.getBookList()
                .stream()
                .map(Book::getAuthor)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
