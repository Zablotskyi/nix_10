package ua.com.alevel.entity;

public class Store {

    private String id;
    private String name;
    private String categories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return categories;
    }

    public void setType(String type) {
        this.categories = type;
    }

    @Override
    public String toString() {
        return "Магазин " + name + ';' +
                " категория: " + categories + ';' +
                " код магазина: " + id;
    }
}