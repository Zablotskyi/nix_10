package ua.com.alevel.entity;

import java.io.Serializable;

public class Book implements Serializable {
    static long count = 1;
    private long id;
    private String name;
    private int yearOfPrinting;
    private String authorName;

    public Book(String name, int yearOfPrinting, String authorName) {
        this.id = count;
        this.name = name;
        this.yearOfPrinting = yearOfPrinting;
        this.authorName = authorName;
        count++;
    }

    public Book(String name, String authorName) {
        this.id = count;
        this.name = name;
        this.authorName = authorName;
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

    public int getYearOfPrinting() {
        return yearOfPrinting;
    }

    public void setYearOfPrinting(int yearOfPrinting) {
        this.yearOfPrinting = yearOfPrinting;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id: " + id +
                ", Название: '" + name + '\'' +
                ", Год издания: " + yearOfPrinting +
                ", Автор(ы): '" + authorName + '\'' +
                '}';
    }
}