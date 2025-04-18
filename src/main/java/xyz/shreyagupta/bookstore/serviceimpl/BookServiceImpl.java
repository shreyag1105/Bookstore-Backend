package xyz.shreyagupta.bookstore.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import xyz.shreyagupta.bookstore.dao.BookDao;
import xyz.shreyagupta.bookstore.entity.Book;
import xyz.shreyagupta.bookstore.repository.BookRepository;
import xyz.shreyagupta.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book findBookById(Integer id) {
        return bookDao.findOne(id);
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookDao.findByAuthor(author);
    }

    @Override
    public Page<Book> getFilteredBooks(Pageable pageable, String author, String category, Double rating) {
        // Logic to apply optional filters
        if (author != null && category != null && rating != null) {
            return bookRepository.findByAuthorAndCategoryAndRatingGreaterThanEqual(author, category, rating, pageable);
        } else if (author != null && category != null) {
            return bookRepository.findByAuthorAndCategory(author, category, pageable);
        } else if (author != null) {
            return bookRepository.findByAuthor(author, pageable);
        } else if (category != null) {
            return bookRepository.findByCategory(category, pageable);
        } else {
            return bookRepository.findAll(pageable);
        }
    }
}
