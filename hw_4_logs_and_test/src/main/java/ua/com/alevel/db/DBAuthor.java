package ua.com.alevel.db;

import ua.com.alevel.entity.Author;
import java.util.Arrays;

public class DBAuthor {
    private static DBAuthor instance;
    private Author[] authorsArray;
    private static DBAuthor dbAuthor;
    private static DBBook dbBook;

    public DBAuthor() {
        authorsArray = new Author[10];
    }

    public static DBAuthor getInstance() {
        if (instance == null) {
            instance = new DBAuthor();
            dbAuthor = DBAuthor.getInstance();
            dbBook = DBBook.getInstance();
        }
        return instance;
    }

    public void create(Author author) {
        author.setId(author.getId());
        for (int i = 0; i < authorsArray.length; i++) {
            if (authorsArray[i] == null) {
                authorsArray[i] = author;
                break;
            }
        }
        ifArrayAuthorIsFull(authorsArray);
    }

    public void update(Author author) {
        Author current = findById(author.getId());
        current.setName(author.getName());
        current.setLastName(author.getLastName());
        current.setBookName(author.getBookName());
    }

    public void delete(long id) {
        String authorLastName = null;

        for (int i = 0; i < authorsArray.length; i++) {
            if (authorsArray[i] != null && authorsArray[i].getId() == id) {
                authorLastName = authorsArray[i].getLastName();
                authorsArray[i] = null;
                break;
            }
        }
        for (int i = 0; i < dbBook.getBooksArray().length; i++) {
            if (dbBook.getBooksArray()[i] != null && dbBook.getBooksArray()[i].getAuthorName().contains(authorLastName) &&
                    !dbBook.getBooksArray()[i].getAuthorName().contains("/")) {
                dbBook.getBooksArray()[i] = null;
                break;
            }
        }
    }

    public Author findById(long id) {
        for (Author author : authorsArray) {
            if (id == author.getId() && author != null) {
                return author;
            }
        }
        throw new RuntimeException("Автор не найден");
    }

    public Author[] findAll() {
        if (authorsArray != null) {
            return authorsArray;
        } else {
            System.out.println("Список автров пуст");
        }
        return authorsArray;
    }

    private void arrayAuthorsSizeUp() {
        authorsArray = Arrays.copyOf(authorsArray, authorsArray.length + 1);
    }

    private void ifArrayAuthorIsFull(Author[] authorsArray) {
        int count = 0;
        int currentSizeArray = 0;
        for (Author element : authorsArray) {
            if (element == null) {
                count++;
            } else {
                currentSizeArray++;
            }
            if (count == authorsArray.length - currentSizeArray) {
                arrayAuthorsSizeUp();
            }
        }
    }
}