package ua.com.alevel.dao;

import ua.com.alevel.db.DBAuthor;
import ua.com.alevel.entity.Author;

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

    public void findById(long id) {
        DBAuthor.getInstance().findById(id);
    }

    public Author[] findAll() {
        return DBAuthor.getInstance().findAll();
    }
}