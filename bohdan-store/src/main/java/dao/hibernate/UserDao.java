package dao.hibernate;

import dao.model.User;

import java.util.List;

public interface UserDao extends GenericDao<Integer, User> {

    User getByLoginAndPassword(String login, String password);

    List<User> getByRole(String role);

}
