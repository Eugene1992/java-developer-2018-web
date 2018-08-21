package jdbc.dao;

import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private static final String ID = "id";
    private static final String USERNAME = "username";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String ROLE = "role";
    private Connection connection;

    public UserDaoJDBCImpl() {
        this.connection = ConnectionFactory.getConnection();
    }

    @Override
    public User create(User employee) {
        return null;
    }

    @Override
    public User update(User employee) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public User get(Integer integer) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getByLoginAndPassword(String login, String password) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        User user = null;

        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM \"user\" u WHERE login = ? AND password = ?");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            user = new User(
                    resultSet.getInt(ID),
                    resultSet.getString(USERNAME),
                    resultSet.getString(LOGIN),
                    resultSet.getString(PASSWORD),
                    getRoleName(resultSet.getInt(ROLE))
            );

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    private String getRoleName(int id) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String role = null;

        try {

            preparedStatement = connection.prepareStatement("SELECT * FROM role WHERE id = ?");
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            resultSet.next();
            role = resultSet.getString("name");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return role;
    }

    @Override
    public List<User> getByRole(String role) {
        return null;
    }
}
