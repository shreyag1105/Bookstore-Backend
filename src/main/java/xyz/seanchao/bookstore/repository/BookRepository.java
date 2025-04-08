package xyz.seanchao.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import xyz.seanchao.bookstore.entity.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    // Filter by author (exact match)
    List<Book> findByAuthor(String author);

    // Filter by category (exact match)
    List<Book> findByCategory(String category);

    // Filter by rating (equal or greater than)
    List<Book> findByRatingGreaterThanEqual(Double rating);

    // Search by title (case-insensitive, partial match)
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Support for filtering + pagination + sorting (Spring handles it)
    Page<Book> findAll(Pageable pageable);
}
