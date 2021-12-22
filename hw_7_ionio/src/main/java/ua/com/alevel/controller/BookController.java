package ua.com.alevel.controller;

import ua.com.alevel.entity.Book;
import ua.com.alevel.service.BookService;

import java.util.List;

public class BookController {
    private final BookService bookService = new BookService();

    public void create(String name, int yearOfPrinting, String authorNameAndLastName) {
        bookService.create(name, yearOfPrinting, authorNameAndLastName);
    }

    public void create(String name, String authorName) {
        bookService.create(name, authorName);
    }

    public void update(long id, String name, int yearOfPrinting, String authorName) {
        bookService.update(id, name, yearOfPrinting, authorName);
    }

    public void delete(long id) {
        bookService.delete(id);
    }

    public Book findById(long id) {
        return bookService.findById(id);
    }

    public void findAll() {
        List<Book> books = bookService.findAll();
        boolean isSomeAuthorFound = false;

        for (Book book : books) {
            if (book != null) {
                isSomeAuthorFound = true;
                System.out.println("Книга: " + book);
            }
        }
        if (!isSomeAuthorFound) {
            System.out.println("Таблица пустая");
        }
    }
}