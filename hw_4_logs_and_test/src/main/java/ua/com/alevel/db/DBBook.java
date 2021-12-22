package ua.com.alevel.db;

import ua.com.alevel.entity.Book;
import java.util.Arrays;

public class DBBook {
    private static DBBook instance;
    private Book[] booksArray;
    private static DBBook dbBook;

    private DBBook() {
        booksArray = new Book[10];
    }

    public Book[] getBooksArray() {
        return booksArray;
    }

    public static DBBook getInstance() {
        if (instance == null) {
            instance = new DBBook();
            dbBook = DBBook.getInstance();
        }
        return instance;
    }

    public void create(Book book) {
        book.setId(book.getId());
        for (int i = 0; i < booksArray.length; i++) {
            if (booksArray[i] == null) {
                booksArray[i] = book;
                break;
            }
        }
        ifArrayBookIsFull(booksArray);
    }

    public void update(Book book) {
        Book current = findById(book.getId());
        current.setName(book.getName());
        current.setYearOfPrinting(book.getYearOfPrinting());
        current.setAuthorName(book.getAuthorName());
    }

    public void delete(long id) {
        for (int i = 0; i < booksArray.length; i++) {
            if (booksArray[i] != null && booksArray[i].getId() == id) {
                booksArray[i] = null;
                break;
            }
        }
    }

    public Book findById(long id) {
        for (Book book : booksArray) {
            if (book != null && id == (book.getId())) {
                return book;
            }
        }
        throw new RuntimeException("такой книги не существует в базе");
    }

    public Book[] findAll() {
        if (booksArray != null) {
            return booksArray;
        } else {
            System.out.println("Список книг пуст");
        }
        return booksArray;
    }

    private void arrayBooksSizeUp() {
        booksArray = Arrays.copyOf(booksArray, booksArray.length + 1);
    }

    private void ifArrayBookIsFull(Book[] booksArray) {
        int count = 0;
        int currentSizeArray = 0;
        for (Book book : booksArray) {
            if (book == null) {
                count++;
            } else {
                currentSizeArray++;
            }
            if (count == booksArray.length - currentSizeArray) {
                arrayBooksSizeUp();
            }
        }
    }
}