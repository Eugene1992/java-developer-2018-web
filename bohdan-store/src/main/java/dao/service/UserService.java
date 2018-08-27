package dao.service;

import dao.hibernate.UserDao;
import dao.hibernate.UserDaoHibernateImpl;
import dao.model.User;

import java.util.List;

public class UserService {

    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDaoHibernateImpl();
    }

    public User getUser(int id) {
        return userDao.get(id);
    }

    public void createUser(User user) {
        userDao.create(user);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    public User getUserByLoginAndPassword(String login, String password) {
        return userDao.getByLoginAndPassword(login, password);
    }

    public List<User> getUserByRole(String role) {
        return userDao.getByRole(role);
    }

}
