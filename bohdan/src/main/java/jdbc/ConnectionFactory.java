package jdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static final String CREDS_PROPERTIES = "postgresql_creds.properties";
    private static final String DRIVER = "driver";
    private static final String URL = "url";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static Properties credsProperties;
    private static Connection connection;

    static {
        try {
            credsProperties = new Properties();
            credsProperties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(CREDS_PROPERTIES));

            Class.forName(credsProperties.getProperty(DRIVER));
            connection = DriverManager.getConnection(
                    credsProperties.getProperty(URL),
                    credsProperties.getProperty(USERNAME),
                    credsProperties.getProperty(PASSWORD)
            );

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ConnectionFactory() {
    }

    public static Connection getConnection() {
        return connection;
    }
}
