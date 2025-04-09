package xyz.shreyagupta.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import xyz.shreyagupta.bookstore.entity.Book;
>>>>>>> 5706a16 (Refactored package to xyz.shreyagupta.bookstore, updated configs and removed old package):src/main/java/xyz/shreyagupta/bookstore/repository/BookRepository.java

public interface BookRepository extends JpaRepository<Book, Integer> {

    
    Page<Book> findByAuthor(String author, Pageable pageable);

    
    Page<Book> findByCategory(String category, Pageable pageable);

    
    Page<Book> findByRatingGreaterThanEqual(Double rating, Pageable pageable);

    
    Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    
    Page<Book> findByAuthorAndCategoryAndRatingGreaterThanEqual(String author, String category, Double rating, Pageable pageable);

    
    Page<Book> findByAuthorAndCategory(String author, String category, Pageable pageable);

    
    Page<Book> findByAuthorAndRatingGreaterThanEqual(String author, Double rating, Pageable pageable);

    
    Page<Book> findByCategoryAndRatingGreaterThanEqual(String category, Double rating, Pageable pageable);

    
    Page<Book> findAll(Pageable pageable);
}
