package com.example.demo.repository;

import com.example.demo.model.Book;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookRepoV2")
@Scope("prototype")
public class AnotherBookRepositoryImpl implements BookRepository{
    List<Book> bookList=List.of(
            new Book("To Kill a Mockingbird", "Harper Lee", 29.99, true),
            new Book("1984", "George Orwell", 24.99, false)
    );
    @Override
    public List<Book> getBookList() {
        return List.of();
    }
}
