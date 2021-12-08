package ua.com.alevel.controller;

import ua.com.alevel.entity.Book;
import ua.com.alevel.service.BookService;

public class BookController {
    private final BookService bookService = new BookService();

    public void create(String name, int yearOfPrinting, String authorName) {
        bookService.create(name, yearOfPrinting, authorName);
    }

    public void update(String name, int yearOfPrinting, String authorName) {
        bookService.update(name, yearOfPrinting, authorName);
    }

    public void delete(long id) {
        bookService.delete(id);
    }

    public void findById(long id) {
        bookService.findById(id);
    }
    public Book[] findAll() {
        return bookService.findAll();
    }
}
