package ua.com.alevel.entity;

public class Customer {

    private String name;
    private String lastName;
    private String birthDay; //dd-mm-yyyy
    private Long id; //+38(code)xxxxxxx
    private String favouriteStores;

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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long phoneNumber) {
        this.id = phoneNumber;
    }

    public String getFavouriteStores() {
        return favouriteStores;
    }

    public void setFavouriteStores(String favouriteStores) {
        this.favouriteStores = favouriteStores;
    }

    @Override
    public String toString() {
        return "Покупатель " +
                " имя: " + name + ';' +
                " фамилия: " + lastName + ';' +
                " дата рождения: " + birthDay + ';' +
                " номер тел.: " + id + ';' +
                " предпочтительные магазины: " + favouriteStores;
    }
}