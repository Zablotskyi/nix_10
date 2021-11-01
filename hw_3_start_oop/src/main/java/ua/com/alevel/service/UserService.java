package ua.com.alevel.service;
import ua.com.alevel.dao.UserDao;
import ua.com.alevel.entity.User;

public class UserService {

    private final UserDao userDao = new UserDao();

    public void create(User user) {
        userDao.create(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(long id) {
        userDao.delete(id);
    }

    public User findById(long id) {
        return userDao.findById(id);
    }

    public User[] findAll() {
        return userDao.findAll();
    }
}
