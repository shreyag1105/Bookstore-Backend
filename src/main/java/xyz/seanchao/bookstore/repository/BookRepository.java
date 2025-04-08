@GetMapping("/books/search")
public List<Book> searchBooks(@RequestParam(required = false) String title,
                              @RequestParam(required = false) String author,
                              @RequestParam(required = false) String category,
                              @RequestParam(required = false) Double minRating) {
    if (title != null) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    } else if (author != null) {
        return bookRepository.findByAuthor(author);
    } else if (category != null) {
        return bookRepository.findByCategory(category);
    } else if (minRating != null) {
        return bookRepository.findByRatingGreaterThanEqual(minRating);
    }
    return bookRepository.findAll();
}
