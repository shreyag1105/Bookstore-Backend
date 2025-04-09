package xyz.shreyagupta.bookstore.service;

<<<<<<< HEAD:src/main/java/xyz/shreyagupta/bookstore/service/BookService.java
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import xyz.seanchao.bookstore.entity.Book;
import xyz.shreyagupta.bookstore.entity.Book;

public interface BookService {
    Book findBookById(Integer id);

    List<Book> findAll();

    List<Book> findByAuthor(String author);

    Page<Book> getFilteredBooks(Pageable pageable, String author, String category, Double rating);
}
