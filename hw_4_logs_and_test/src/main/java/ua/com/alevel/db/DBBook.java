package ua.com.alevel.db;

import ua.com.alevel.entity.Book;

import java.util.Arrays;

public class DBBook {
    private static DBBook instance;
    private Book[] books;

    private DBBook() {
        books = new Book[10];
    }

    public static DBBook getInstance() {
        if (instance == null) {
            instance = new DBBook();
        }
        return instance;
    }

    public void create(Book book) {
        book.setId(book.getId());
        for (Book element : books) {
            if (element == null) {
                element = book;
                break;
            }
        }
        ifArrayBookIsFull(books);
    }

    public void update(Book book) {
        Book current = findById(book.getId());
        current.setName(book.getName());
        current.setYearOfPrinting(book.getYearOfPrinting());
    }

    public void delete(long id) {
        for (Book book : books) {
            if (id == (book.getId())) {
                book = null;
            }
        }
        arrayBooksSizeDown();
    }

    public Book findById(long id) {
        for (Book book : books) {
            if (id == (book.getId())) {
                return book;
            }
        }
        throw new RuntimeException("такой книги не существует в базе");
    }

    public Book[] findAll() {
        return books;
    }

    private void arrayBooksSizeUp() {
        books = Arrays.copyOf(books, books.length + 1);
    }

    private void arrayBooksSizeDown() {
        Book[] tempArrayBook = Arrays.copyOf(books, books.length);
        books = new Book[tempArrayBook.length - 1];

        int count = 0;
        for (int i = 0; i < tempArrayBook.length; i++) {
            if (tempArrayBook[count] != null) {
                books[count] = tempArrayBook[i];
                count++;
            }
        }
    }

    private void ifArrayBookIsFull(Book[] books) {
        int count = 0;
        int currentSizeArray = 0;
        for (Book book : books) {
            if (book == null) {
                count++;
            } else {
                currentSizeArray++;
            }
            if (count == books.length - currentSizeArray) {
                arrayBooksSizeUp();
            }
        }
    }
}
