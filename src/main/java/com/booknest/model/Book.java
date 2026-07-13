package com.booknest.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Represents a book in the personal library.
 *
 * The @Entity annotation tells JPA to treat this class as a persistent entity.
 * The @Table annotation maps the class to the books table in the database.
 */
@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be at most 100 characters")
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @NotBlank(message = "Author is required")
    @Size(max = 100, message = "Author must be at most 100 characters")
    @Column(name = "author", nullable = false, length = 100)
    private String author;

    @NotBlank(message = "ISBN is required")
    @Size(min = 10, max = 20, message = "ISBN must be between 10 and 20 characters")
    @Pattern(regexp = "^[A-Za-z0-9-]+$", message = "ISBN can contain only letters, numbers, and hyphens")
    @Column(name = "isbn", nullable = false, unique = true, length = 20)
    private String isbn;

    @NotBlank(message = "Genre is required")
    @Size(max = 50, message = "Genre must be at most 50 characters")
    @Column(name = "genre", nullable = false, length = 50)
    private String genre;

    @NotBlank(message = "Status is required")
    @Pattern(regexp = "^(READING|COMPLETED|WISHLIST)$", message = "Status must be READING, COMPLETED, or WISHLIST")
    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "date_added", nullable = false)
    private LocalDate dateAdded;

    public Book() {
    }

    public Book(Long id, String title, String author, String isbn, String genre, String status, LocalDate dateAdded) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.status = status;
        this.dateAdded = dateAdded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genre='" + genre + '\'' +
                ", status='" + status + '\'' +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
