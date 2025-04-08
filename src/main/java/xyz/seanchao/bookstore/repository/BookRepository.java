package xyz.seanchao.bookstore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import xyz.seanchao.bookstore.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

    // Search by author (with pagination)
    Page<Book> findByAuthor(String author, Pageable pageable);

    // Search by category (with pagination)
    Page<Book> findByCategory(String category, Pageable pageable);

    // Filter by rating >= value (with pagination)
    Page<Book> findByRatingGreaterThanEqual(Double rating, Pageable pageable);

    // Search by title (case-insensitive partial match, with pagination)
    Page<Book> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    // Combination: author + category + rating
    Page<Book> findByAuthorAndCategoryAndRatingGreaterThanEqual(String author, String category, Double rating, Pageable pageable);

    // Combination: author + category
    Page<Book> findByAuthorAndCategory(String author, String category, Pageable pageable);

    // Combination: author + rating
    Page<Book> findByAuthorAndRatingGreaterThanEqual(String author, Double rating, Pageable pageable);

    // Combination: category + rating
    Page<Book> findByCategoryAndRatingGreaterThanEqual(String category, Double rating, Pageable pageable);

    // Fallback for all books with pagination and sorting
    Page<Book> findAll(Pageable pageable);
}
