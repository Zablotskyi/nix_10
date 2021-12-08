package ua.com.alevel.dao;

import ua.com.alevel.db.DBBook;
import ua.com.alevel.entity.Book;

public class BookDao {

    public void create(Book book) {
        DBBook.getInstance().create(book);
    }

    public void update(Book book) {
        DBBook.getInstance().update(book);
    }

    public void delete(long id) {
        DBBook.getInstance().delete(id);
    }

    public void findById(long id) {
        DBBook.getInstance().findById(id);
    }

    public Book[] findAll() {
        return DBBook.getInstance().findAll();
    }


}
