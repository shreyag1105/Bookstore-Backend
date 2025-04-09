HEAD:src/main/java/xyz/seanchao/bookstore/controller/BookController.java
@GetMapping("/books")
public Page<Book> getBooks(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "asc") String direction,
        @RequestParam(required = false) String author,
        @RequestParam(required = false) String category,
        @RequestParam(required = false) Double rating
) {
    Sort sort = direction.equalsIgnoreCase("desc") 
        ? Sort.by(sortBy).descending() 
        : Sort.by(sortBy).ascending();
    
    Pageable pageable = PageRequest.of(page, size, sort);
    
    return bookService.getFilteredBooks(pageable, author, category, rating);
=======
package xyz.shreyagupta.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.shreyagupta.bookstore.entity.Book;
import xyz.shreyagupta.bookstore.service.BookService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/book/{id}")
    public Book findBook(@PathVariable("id") Integer id) {
        System.out.println("Searching book id: " + id);
        Book book = bookService.findBookById(id);
        System.out.println(book.getId() + " " + book.getName());
        return book;
    }

    @GetMapping(value = "/getBookAll")
    public List<Book> getBookAll() {
        return bookService.findAll();
    }

    @GetMapping(value = "/author/{name}")
    public List<Book> findByAuthor(@PathVariable("name") String author) {
        System.out.println("find books by author: " + author);
        return bookService.findByAuthor(author);
    }
>>>>>>> 5706a16 (Refactored package to xyz.shreyagupta.bookstore, updated configs and removed old package):src/main/java/xyz/shreyagupta/bookstore/controller/BookController.java
}
