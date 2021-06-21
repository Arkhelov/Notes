import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class SQLConnector implements SQLConnection{

        public void CreateTable() {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            String SQL ="CREATE TABLE IF NOT EXISTS " + "Notes" + " (id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY," +  "\n" +
                    "header VARCHAR (100), " + " text VARCHAR (1000),"  + " date DATE)";

            statement.executeUpdate(SQL);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}

