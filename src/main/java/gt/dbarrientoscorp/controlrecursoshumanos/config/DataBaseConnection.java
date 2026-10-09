package main.java.gt.dbarrientoscorp.controlrecursoshumanos.config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author informatica
 */
public class DataBaseConnection {



    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(Credentials.URL_DB, Credentials.USER_DB, Credentials.PASSWORD_DB);
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver de MySQL no encontrado", e);
            }
        }
        return connection;
    }
}
