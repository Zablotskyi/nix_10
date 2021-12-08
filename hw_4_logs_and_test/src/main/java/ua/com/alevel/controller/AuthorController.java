package ua.com.alevel.controller;

import ua.com.alevel.entity.Author;
import ua.com.alevel.service.AuthorService;

public class AuthorController {
    private final AuthorService authorService = new AuthorService();

    public void create(String name, String lastName, String bookName) {
        authorService.create(name, lastName, bookName);
    }

    public void update(String name, String lastName, String bookName) {
        authorService.update(name, lastName, bookName);
    }

    public void delete(long id) {
        authorService.delete(id);
    }

    public void findById(long id) {
        authorService.findById(id);

    }

    public void findAll() {
        Author[] authors = authorService.findAll();
        if (authors != null && authors.length != 0) {
            for (Author author : authors) {
                if (authors != null) {
                    System.out.println("пользователь: = " + author);
                }
            }
        } else {
            System.out.println("таблица пустая");
        }
    }
}
