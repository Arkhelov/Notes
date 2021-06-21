import java.sql.*;

public class AddInTable implements SQLConnection{
    public void AddInTable(String header, String text, Date date) throws SQLException {

        Connection connection = null;
        Statement statement = null;
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        String SQL = "INSERT INTO " + "Notes" + " (header, text, date)  VALUES (?,?,?)";
        PreparedStatement stmt = connection.prepareStatement(SQL);;
        stmt.setString(1, header);
        stmt.setString(2, text);
        stmt.setDate(3, date);

        stmt.executeUpdate();

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
