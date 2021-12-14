package ua.com.alevel.controller;

import ua.com.alevel.entity.Author;
import ua.com.alevel.service.AuthorService;

public class AuthorController {
    private final AuthorService authorService = new AuthorService();

    public void create(String authorNameAndLastName) {
        authorService.create(authorNameAndLastName);
    }

    public void create(String authorNameAndLastName, String bookName) {
        authorService.create(authorNameAndLastName, bookName);
    }

    public void update(long id, String authorNameAndLastName, String bookName) {
        authorService.update(id, authorNameAndLastName, bookName);
    }

    public void update(long id, String authorNameAndLastName) {
        authorService.update(id, authorNameAndLastName);
    }

    public void delete(long id) {
        authorService.delete(id);
    }

    public Author findById(long id) {
        return authorService.findById(id);
    }

    public void findAll() {
        Author[] authors = authorService.findAll();
        boolean isSomeAuthorFound = false;

        for (Author author : authors) {
            if (author != null) {
                isSomeAuthorFound = true;
                System.out.println("автор: " + author);
            }
        }
        if (!isSomeAuthorFound) {
            System.out.println("Таблица пустая");
        }
    }
}