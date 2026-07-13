package com.booknest.service;

import com.booknest.dto.BookDto;
import com.booknest.model.Book;

import java.util.List;

public interface BookService {

    /**
     * Persists a new book after validating business rules.
     *
     * @param bookDto the incoming book payload
     * @return the saved book entity
     */
    Book saveBook(BookDto bookDto);

    /**
     * Updates an existing book using the provided payload.
     *
     * @param id the book identifier
     * @param bookDto the updated book payload
     * @return the updated book entity
     */
    Book updateBook(Long id, BookDto bookDto);

    /**
     * Deletes a book by its identifier.
     *
     * @param id the book identifier to remove
     */
    void deleteBook(Long id);

    /**
     * Retrieves a single book by its identifier.
     *
     * @param id the book identifier
     * @return the matching book entity
     */
    Book getBook(Long id);

    /**
     * Returns every book stored in the system.
     *
     * @return a list of all books
     */
    List<Book> getAllBooks();

    /**
     * Searches books by title or author keyword.
     *
     * @param keyword the search text
     * @return matching books
     */
    List<Book> searchBooks(String keyword);

    /**
     * Counts all books.
     *
     * @return total book count
     */
    long countBooks();

    /**
     * Counts books whose status is COMPLETED.
     *
     * @return completed count
     */
    long countCompletedBooks();

    /**
     * Counts books whose status is READING.
     *
     * @return reading count
     */
    long countReadingBooks();

    /**
     * Counts books whose status is WISHLIST.
     *
     * @return wishlist count
     */
    long countWishlistBooks();
}
