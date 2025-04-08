package xyz.seanchao.bookstore.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.seanchao.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    Book findBookById(Integer id);

    List<Book> findAll();

    List<Book> findByAuthor(String author);

    Page<Book> getFilteredBooks(Pageable pageable, String author, String category, Double rating);
}
