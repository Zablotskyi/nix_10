package ua.com.alevel.service;

import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Book;

public class BookService {
    private final BookDao bookDao = new BookDao();

    public void create(String name, int yearOfPrinting, String authorName) {
        Book book = new Book(name, yearOfPrinting, authorName);
        book.setName(name);
        book.setYearOfPrinting(yearOfPrinting);
        book.setAuthorName(authorName);
        bookDao.create(book);
    }

    public void update(String name, int yearOfPrinting, String authorName) {
        Book book = new Book(name, yearOfPrinting, authorName);
        book.setName(name);
        book.setYearOfPrinting(yearOfPrinting);
        book.setAuthorName(authorName);
        bookDao.update(book);
    }

    public void delete(long id) {
        bookDao.delete(id);
    }

    public void findById(long id) {
        bookDao.findById(id);
    }

    public Book[] findAll() {
        return bookDao.findAll();
    }
}
