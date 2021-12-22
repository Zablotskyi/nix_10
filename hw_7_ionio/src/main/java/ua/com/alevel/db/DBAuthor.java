package ua.com.alevel.db;

import ua.com.alevel.Application;
import ua.com.alevel.entity.Author;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DBAuthor implements Serializable {
    private static DBAuthor instance;
    private List<Author> authorsList;
    private static DBAuthor dbAuthor;
    private static DBBook dbBook;
    private static File fileName = new File("./src/main/resources/dbAuthor.txt");
    Application application = new Application();

    public DBAuthor() {
        authorsList = new ArrayList<>();
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
        writeAuthorToFile(author);
    }

    public void update(Author author) {
        Author current = findById(author.getId());
        current.setName(author.getName());
        current.setLastName(author.getLastName());
        current.setBookName(author.getBookName());
        writeAuthorToFile(current);
    }

    public void delete(long id) {
        try {
            readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String authorLastName = null;
        for (int i = 0; i < authorsList.size(); i++) {
            if (authorsList.get(i) != null && authorsList.get(i).getId() == id) {
                authorLastName = authorsList.get(i).getLastName();
                authorsList.remove(i);
            }
        }
        for (int i = 0; i < dbBook.getBooksList().size(); i++) {
            if (dbBook.getBooksList().get(i) != null && dbBook.getBooksList().get(i).getAuthorName().contains(authorLastName) &&
                    !dbBook.getBooksList().get(i).getAuthorName().contains("/")) {
                dbBook.getBooksList().remove(i);
                break;
            }
        }
        updateAuthorsInFile();
    }

    public Author findById(long id) {
        Author current = null;
        for (Author author : authorsList) {
            if (id == author.getId() && author != null) {
                return author;
            } else {
                System.out.println("Автор не найден");
                application.runAuthors();
            }
        }
        return current;
    }

    public List<Author> findAll() {
        try {
            readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (authorsList.isEmpty()) {
            System.out.println("Список автров пуст");
        }
        return authorsList;
    }

    public void writeAuthorToFile(Author author) {
        boolean isAuthorFound = false;

        for (int i = 0; i < authorsList.size(); i++) {
            if (authorsList.get(i) != null && author.getId() == authorsList.get(i).getId()) {
                authorsList.set(i, author);
                isAuthorFound = true;
            }
        }
        if (!isAuthorFound) {
            authorsList.add(author);
        }

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(authorsList);
        } catch (IOException e) {
            System.out.println("Файл с базой авторов не найден");
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void updateAuthorsInFile() {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(authorsList);
        } catch (IOException e) {
            System.out.println("Файл с базой авторов не найден");
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void readFromFile() throws IOException {
        authorsList.clear();
        ObjectInputStream objectinputstream = null;
        try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            List<Author> readCase = null;
            while (streamIn.available() > 0) {
                readCase = (List<Author>) objectinputstream.readObject();
                if (readCase != null) {
                    authorsList = readCase;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (objectinputstream != null) {
                objectinputstream.close();
            }
        }
    }
}