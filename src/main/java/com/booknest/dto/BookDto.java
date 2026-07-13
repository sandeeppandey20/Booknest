package com.booknest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class BookDto {

    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be at most 100 characters")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(max = 100, message = "Author must be at most 100 characters")
    private String author;

    @NotBlank(message = "ISBN is required")
    @Size(min = 10, max = 20, message = "ISBN must be between 10 and 20 characters")
    @Pattern(regexp = "^[A-Za-z0-9-]+$", message = "ISBN can contain only letters, numbers, and hyphens")
    private String isbn;

    @NotBlank(message = "Genre is required")
    @Size(max = 50, message = "Genre must be at most 50 characters")
    private String genre;

    @NotBlank(message = "Status is required")
    @Pattern(regexp = "^(READING|COMPLETED|WISHLIST)$", message = "Status must be READING, COMPLETED, or WISHLIST")
    private String status;

    @NotNull(message = "Date added is required")
    private LocalDate dateAdded;

    public BookDto() {
    }

    public BookDto(Long id, String title, String author, String isbn, String genre, String status, LocalDate dateAdded) {
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
}
