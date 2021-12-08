package ua.com.alevel.db;

import ua.com.alevel.entity.Author;
import java.util.Arrays;

public class DBAuthor {
    private static DBAuthor instance;
    private Author[] authors;

    private DBAuthor() {
        authors = new Author[10];
    }

    public static DBAuthor getInstance() {
        if (instance == null) {
            instance = new DBAuthor();
        }
        return instance;
    }

    public void create(Author author) {
        author.setId(author.getId());
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                authors[i] = author;
                break;
            }
        }
        ifArrayAuthorIsFull(authors);
    }

    public void update(Author author) {
        Author current = findById(author.getId());
        current.setName(author.getName());
        current.setLastName(author.getLastName());
    }

    public void delete(long id) {
        for (Author author : authors) {
            if (id == (author.getId())) {
                author = null;
            }
        }
        arrayAuthorsSizeDown();
    }

    public Author findById(long id) {
        for (Author author : authors) {
            if (id == (author.getId())) {
                return author;
            }
        }
        throw new RuntimeException("такого автора не существует в базе");
    }

    public Author[] findAll() {
        return authors;
    }

    private void arrayAuthorsSizeUp() {
        authors = Arrays.copyOf(authors, authors.length + 1);
    }

    private void arrayAuthorsSizeDown() {
        Author[] tempArrayAuthor = Arrays.copyOf(authors, authors.length);
        authors = new Author[tempArrayAuthor.length - 1];

        int count = 0;
        for (int i = 0; i < tempArrayAuthor.length; i++) {
            if (tempArrayAuthor[count] != null) {
                authors[count] = tempArrayAuthor[i];
                count++;
            }
        }
    }

    private void ifArrayAuthorIsFull(Author[] authors) {
        int count = 0;
        int currentSizeArray = 0;
        for (Author element : authors) {
            if (element == null) {
                count++;
            } else {
                currentSizeArray++;
            }
            if (count == authors.length - currentSizeArray) {
                arrayAuthorsSizeUp();
            }
        }
    }
}
