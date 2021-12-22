package ua.com.alevel.dao;

import ua.com.alevel.db.DBAuthor;
import ua.com.alevel.entity.Author;

import java.util.List;

public class AuthorDao {

    public void create(Author author) {
        DBAuthor.getInstance().create(author);
    }

    public void update(Author author) {
        DBAuthor.getInstance().update(author);
    }

    public void delete(long id) {
        DBAuthor.getInstance().delete(id);
    }

    public Author findById(long id) {
        return DBAuthor.getInstance().findById(id);
    }

    public List<Author> findAll() {
        return DBAuthor.getInstance().findAll();
    }
}