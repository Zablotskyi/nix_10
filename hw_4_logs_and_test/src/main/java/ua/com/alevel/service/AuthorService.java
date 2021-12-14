package ua.com.alevel.service;

import ua.com.alevel.Application;
import ua.com.alevel.dao.AuthorDao;
import ua.com.alevel.entity.Author;

public class AuthorService {
    private final AuthorDao authorDao = new AuthorDao();

    public void create(String authorNameAndLastName, String bookName) {
        parseAuthorsName(authorNameAndLastName);
        Author author = new Author(parseAuthorsName(authorNameAndLastName)[0], parseAuthorsName(authorNameAndLastName)[1], bookName);
        author.setName(parseAuthorsName(authorNameAndLastName)[0]);
        author.setLastName(parseAuthorsName(authorNameAndLastName)[1]);
        author.setBookName(bookName);
        authorDao.create(author);
    }

    public void create(String authorNameAndLastName) {
        Author author = new Author(parseAuthorsName(authorNameAndLastName)[0], parseAuthorsName(authorNameAndLastName)[1]);
        author.setName(parseAuthorsName(authorNameAndLastName)[0]);
        author.setLastName( parseAuthorsName(authorNameAndLastName)[1]);
        authorDao.create(author);
    }

    public void update(long id, String authorNameAndLastName, String bookName) {
        Author current = authorDao.findById(id);
        current.setName(parseAuthorsName(authorNameAndLastName)[0]);
        current.setLastName(parseAuthorsName(authorNameAndLastName)[1]);
        current.setBookName(bookName);
        authorDao.update(current);
    }

    public void update(long id, String authorNameAndLastName) {
        Author current = authorDao.findById(id);
        current.setName(parseAuthorsName(authorNameAndLastName)[0]);
        current.setLastName(parseAuthorsName(authorNameAndLastName)[1]);
        authorDao.update(current);
    }

    public void delete(long id) {
        authorDao.delete(id);
    }

    public Author findById(long id) {
        return authorDao.findById(id);
    }

    public Author[] findAll() {
        return authorDao.findAll();
    }

    public String[] parseAuthorsName(String string) {
        try {
            String[] tmpArray = string.split(" ");
            return tmpArray;
        } catch (Exception e) {
            System.out.println("Вы неправильно ввели данные автора. Повторите попытку");
            new Application().runBooks();
        }
        return null;
    }
}