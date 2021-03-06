package ua.com.alevel.entity;

import java.io.Serializable;

public class Author implements Serializable {
    static long count = 1;
    private long id;
    private String name;
    private String lastName;
    private String bookName;

    public Author(String name, String lastName, String bookName) {
        this.id = count;
        this.name = name;
        this.lastName = lastName;
        this.bookName = bookName;
        count++;
    }

    public Author(String name, String lastName) {
        this.id = count;
        this.name = name;
        this.lastName = lastName;
        count++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id: " + id +
                ", Имя: '" + name + '\'' +
                ", Фамилия: '" + lastName + '\'' +
                ", Название книг(и): '" + bookName + '\'' +
                '}';
    }
}
