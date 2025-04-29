package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookRepoV1")
@Scope("singleton")
public class BookRepositoryImpl implements BookRepository{
    List<Book> bookList=List.of(
            new Book("The Great Gatsby", "F. Scott Fitzgerald", 39.99, true),
            new Book("Pride and Prejudice", "Jane Austen", 44.99, true),
            new Book("Moby-Dick", "Herman Melville", 34.99, false)
    );

    @Override
    public List<Book> getBookList() {
        return List.of();
    }
}
