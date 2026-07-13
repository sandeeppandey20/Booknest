package com.booknest.controller;

import com.booknest.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final BookService bookService;

    public HomeController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("totalBooks", bookService.countBooks());
        model.addAttribute("readingBooks", bookService.countReadingBooks());
        model.addAttribute("completedBooks", bookService.countCompletedBooks());
        model.addAttribute("wishlistBooks", bookService.countWishlistBooks());
        return "dashboard";
    }
}
