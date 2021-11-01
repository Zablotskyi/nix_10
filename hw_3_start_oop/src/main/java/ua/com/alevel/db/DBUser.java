package ua.com.alevel.db;
import ua.com.alevel.entity.User;

import java.util.Arrays;

public class DBUser {

    private static DBUser instance;
    private User[] users;

    private DBUser() {
        users = new User[0];
    }

    public static DBUser getInstance() {
        if (instance == null) {
            instance = new DBUser();
        }
        return instance;
    }

    public void create(User user) {
        arrayUsersSizeUp();
        user.setId(user.getId());
        users[users.length - 1] = user;
    }

    public void update(User user) {
        User current = findById(user.getId());
        current.setName(user.getName());
        current.setAge(user.getAge());
    }

    public void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (id == (users[i].getId())) {
                users[i] = null;
            }
        }
        arrayUsersSizeDown();
    }

    public User findById(long id) {
        for (int i = 0; i < users.length; i++) {
            if (id == (users[i].getId())) {
                return users[i];
            }
        }
        throw new RuntimeException("пользователь не найден");
    }

    public User[] findAll() {
        return users;
    }

//    private String generateId() {
//        String id = UUID.randomUUID().toString();
//        if (users.stream().anyMatch(user -> user.getId().equals(id))) {
//            return generateId();
//        }
//        return id;
//    }

    //метод увеличивающий массил на одну ячейку
    private void arrayUsersSizeUp() {
        users = Arrays.copyOf(users, users.length + 1);
    }

    //метод который убирает ячейки по индексу с значением null
    private void arrayUsersSizeDown() {
        User[] tempArrayUsers = Arrays.copyOf(users, users.length);
        users = new User[tempArrayUsers.length - 1];

        int count = 0;
        for (int i = 0; i < tempArrayUsers.length; i++) {
            if (tempArrayUsers[count] != null) {
                users[count] = tempArrayUsers[i];
                count++;
            }
        }
    }
}
