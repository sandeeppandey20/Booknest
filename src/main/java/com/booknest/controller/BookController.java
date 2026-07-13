package com.booknest.controller;

import com.booknest.dto.BookDto;
import com.booknest.model.Book;
import com.booknest.service.BookService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String listBooks(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Book> books = bookService.searchBooks(keyword);
        model.addAttribute("books", books);
        model.addAttribute("keyword", keyword);
        return "books";
    }

    @GetMapping("/books/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new BookDto());
        return "add-book";
    }

    @PostMapping("/books/add")
    public String addBook(@Valid @ModelAttribute("book") BookDto bookDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes,
                           Model model) {
        if (bindingResult.hasErrors()) {
            return "add-book";
        }

        bookService.saveBook(bookDto);
        redirectAttributes.addFlashAttribute("successMessage", "Book added successfully.");
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        Book existingBook = bookService.getBook(id);
        BookDto bookDto = mapToDto(existingBook);
        model.addAttribute("book", bookDto);
        return "edit-book";
    }

    @PostMapping("/books/edit/{id}")
    public String updateBook(@PathVariable Long id,
                             @Valid @ModelAttribute("book") BookDto bookDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "edit-book";
        }

        bookService.updateBook(id, bookDto);
        redirectAttributes.addFlashAttribute("successMessage", "Book updated successfully.");
        return "redirect:/books";
    }

    @GetMapping("/books/delete/{id}")
    public String deleteBook(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        bookService.deleteBook(id);
        redirectAttributes.addFlashAttribute("successMessage", "Book deleted successfully.");
        return "redirect:/books";
    }

    @GetMapping("/books/search")
    public String searchBooks(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        return listBooks(keyword, model);
    }

    @PostMapping("/books/search")
    public String searchBooksPost(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        return listBooks(keyword, model);
    }

    private BookDto mapToDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setIsbn(book.getIsbn());
        bookDto.setGenre(book.getGenre());
        bookDto.setStatus(book.getStatus());
        bookDto.setDateAdded(book.getDateAdded());
        return bookDto;
    }
}
