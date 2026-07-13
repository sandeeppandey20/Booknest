package com.booknest.service.impl;

import com.booknest.dto.BookDto;
import com.booknest.exception.DuplicateBookException;
import com.booknest.exception.ResourceNotFoundException;
import com.booknest.model.Book;
import com.booknest.repository.BookRepository;
import com.booknest.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public Book saveBook(BookDto bookDto) {
        validateDuplicateIsbn(bookDto.getIsbn());
        Book book = mapToEntity(bookDto);
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public Book updateBook(Long id, BookDto bookDto) {
        Book existingBook = getBook(id);
        if (!existingBook.getIsbn().equalsIgnoreCase(bookDto.getIsbn())
                && bookRepository.existsByIsbn(bookDto.getIsbn())) {
            throw new DuplicateBookException("A book with ISBN " + bookDto.getIsbn() + " already exists.");
        }

        existingBook.setTitle(bookDto.getTitle());
        existingBook.setAuthor(bookDto.getAuthor());
        existingBook.setIsbn(bookDto.getIsbn());
        existingBook.setGenre(bookDto.getGenre());
        existingBook.setStatus(bookDto.getStatus().toUpperCase());
        existingBook.setDateAdded(bookDto.getDateAdded());

        return bookRepository.save(existingBook);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {
        Book book = getBook(id);
        bookRepository.delete(book);
    }

    @Override
    @Transactional(readOnly = true)
    public Book getBook(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> searchBooks(String keyword) {
        String normalizedKeyword = keyword == null ? "" : keyword.trim();
        if (normalizedKeyword.isEmpty()) {
            return getAllBooks();
        }

        List<Book> titleMatches = bookRepository.findByTitleContainingIgnoreCase(normalizedKeyword);
        List<Book> authorMatches = bookRepository.findByAuthorContainingIgnoreCase(normalizedKeyword);
        List<Book> combined = new ArrayList<>();

        titleMatches.forEach(book -> {
            if (!combined.contains(book)) {
                combined.add(book);
            }
        });

        authorMatches.forEach(book -> {
            if (!combined.contains(book)) {
                combined.add(book);
            }
        });

        return combined;
    }

    @Override
    @Transactional(readOnly = true)
    public long countBooks() {
        return bookRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public long countCompletedBooks() {
        return bookRepository.findByStatus("COMPLETED").size();
    }

    @Override
    @Transactional(readOnly = true)
    public long countReadingBooks() {
        return bookRepository.findByStatus("READING").size();
    }

    @Override
    @Transactional(readOnly = true)
    public long countWishlistBooks() {
        return bookRepository.findByStatus("WISHLIST").size();
    }

    private void validateDuplicateIsbn(String isbn) {
        if (bookRepository.existsByIsbn(isbn)) {
            throw new DuplicateBookException("A book with ISBN " + isbn + " already exists.");
        }
    }

    private Book mapToEntity(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());
        book.setGenre(bookDto.getGenre());
        book.setStatus(bookDto.getStatus().toUpperCase());
        book.setDateAdded(bookDto.getDateAdded() == null ? LocalDate.now() : bookDto.getDateAdded());
        return book;
    }
}
