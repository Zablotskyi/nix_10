package ua.com.alevel.service;

import ua.com.alevel.Application;
import ua.com.alevel.dao.BookDao;
import ua.com.alevel.entity.Book;

import java.util.List;

public class BookService {
    private final BookDao bookDao = new BookDao();

    public void create(String name, int yearOfPrinting, String authorName) {
        Book book = new Book(name, yearOfPrinting, authorName);
        book.setName(name);
        book.setYearOfPrinting(yearOfPrinting);
        book.setAuthorName(authorName);
        parseAuthorsName(authorName);
        bookDao.create(book);
    }

    public void create(String name, String authorName) {
        Book book = new Book(name, authorName);
        book.setName(name);
        book.setAuthorName(authorName);
        parseAuthorsName(authorName);
        bookDao.create(book);
    }

    public void update(long id, String name, int yearOfPrinting, String authorName) {
        Book current = bookDao.findById(id);
        current.setName(name);
        current.setYearOfPrinting(yearOfPrinting);
        current.setAuthorName(authorName);
        parseAuthorsName(authorName);
        bookDao.update(current);
    }

    public void delete(long id) {
        bookDao.delete(id);
    }

    public Book findById(long id) {
        return bookDao.findById(id);
    }

    public List<Book> findAll() {
        return bookDao.findAll();
    }

    public void parseAuthorsName(String string) {
        String[] authorNameAndLastNameArray = string.split(" / ");
        for (int i = 0; i < authorNameAndLastNameArray.length; i++) {
            try {
                String[] tmpArray = authorNameAndLastNameArray[i].split(" ");
            } catch (Exception e) {
                System.out.println("Вы неправильно ввели данные автора. Повторите попытку");
                new Application().runBooks();
            }
        }
    }
}