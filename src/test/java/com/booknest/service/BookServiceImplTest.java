package com.booknest.service;

import com.booknest.dto.BookDto;
import com.booknest.model.Book;
import com.booknest.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository.deleteAll();
    }

    @Test
    void shouldSaveAndCountBooksByStatus() {
        BookDto readingBook = new BookDto();
        readingBook.setTitle("Clean Code");
        readingBook.setAuthor("Robert C. Martin");
        readingBook.setIsbn("9780132350884");
        readingBook.setGenre("Programming");
        readingBook.setStatus("READING");
        readingBook.setDateAdded(LocalDate.now());

        BookDto completedBook = new BookDto();
        completedBook.setTitle("The Pragmatic Programmer");
        completedBook.setAuthor("Andrew Hunt");
        completedBook.setIsbn("9780201616224");
        completedBook.setGenre("Programming");
        completedBook.setStatus("COMPLETED");
        completedBook.setDateAdded(LocalDate.now());

        bookService.saveBook(readingBook);
        bookService.saveBook(completedBook);

        assertEquals(2, bookService.countBooks());
        assertEquals(1, bookService.countCompletedBooks());
        assertEquals(1, bookService.countReadingBooks());
        assertEquals(0, bookService.countWishlistBooks());
    }
}
