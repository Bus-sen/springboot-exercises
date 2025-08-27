package com.busra.springbootexercises.controller;

import com.busra.springbootexercises.model.Book;
import com.busra.springbootexercises.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/create")
    public void createBook(@RequestBody Book book) {
        bookService.createBook(book);
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }
}
