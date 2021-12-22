package ua.com.alevel.db;

import ua.com.alevel.Application;
import ua.com.alevel.entity.Author;
import ua.com.alevel.entity.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DBBook implements Serializable {
    private static DBBook instance;
    private List<Book> booksList;
    private static DBBook dbBook;
    private static File fileName = new File("./hw_7_ionio/src/main/resources/dbBook.txt");
    Application application = new Application();

    public DBBook() {
        booksList = new ArrayList<>();
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public static DBBook getInstance() {
        if (instance == null) {
            instance = new DBBook();
            dbBook = DBBook.getInstance();
        }
        return instance;
    }

    public void create(Book book) {
        book.setId(book.getId());
        writeAuthorToFile(book);
    }

    public void update(Book book) {
        Book current = findById(book.getId());
        current.setName(book.getName());
        current.setYearOfPrinting(book.getYearOfPrinting());
        current.setAuthorName(book.getAuthorName());
        writeAuthorToFile(current);
    }

    public void delete(long id) {
        try {
            readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i) != null && booksList.get(i).getId() == id) {
                booksList.remove(i);
                break;
            }
        }
        updateBooksInFile();
    }

    public Book findById(long id) {
        Book current = null;
        for (Book book : booksList) {
            if (id == book.getId() && book != null) {
                return book;
            } else {
                System.out.println("такой книги не существует в базе");
                application.runAuthors();
            }
        }
        return current;
    }

    public List<Book> findAll() {
        try {
            readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (booksList.isEmpty()) {
            System.out.println("Список книг пуст");
        }
        return booksList;
    }

    public void writeAuthorToFile(Book book) {
        boolean isAuthorFound = false;

        for (int i = 0; i < booksList.size(); i++) {
            if (booksList.get(i) != null && book.getId() == booksList.get(i).getId()) {
                booksList.set(i, book);
                isAuthorFound = true;
            }
        }
        if (!isAuthorFound) {
            booksList.add(book);
        }

        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(booksList);
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

    public void updateBooksInFile() {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(booksList);
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
        booksList.clear();
        ObjectInputStream objectinputstream = null;
        try {
            FileInputStream streamIn = new FileInputStream(fileName);
            objectinputstream = new ObjectInputStream(streamIn);
            List<Book> readCase = null;
            while (streamIn.available() > 0) {
                readCase = (List<Book>) objectinputstream.readObject();
                if (readCase != null) {
                    booksList = readCase;
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