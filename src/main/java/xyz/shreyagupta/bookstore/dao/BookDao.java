package xyz.shreyagupta.bookstore.dao;

import java.util.List;

import xyz.shreyagupta.bookstore.entity.Book;

public interface BookDao {
    Book findOne(Integer id);

    List<Book> findAll();

    List<Book> findByAuthor(String author);
}
