package ua.com.alevel.service;

import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.entity.Author;

public class AuthorService {
    private final AuthorDao authorDao = new AuthorDao();

    public void create(String name, String lastName, String bookName) {
        Author author = new Author(name, lastName , bookName);
        author.setName(name);
        author.setLastName(lastName);
        author.setBookName(bookName);
        authorDao.create(author);
    }

    public void update(String name, String lastName, String bookName) {
        Author author = new Author(name, lastName, bookName);
        author.setName(name);
        author.setLastName(lastName);
        author.setBookName(bookName);
        authorDao.update(author);
    }

    public void delete(long id) {
        authorDao.delete(id);
    }

    public void findById(long id) {
        authorDao.findById(id);
    }

    public Author[] findAll() {
        return authorDao.findAll();
    }
}
