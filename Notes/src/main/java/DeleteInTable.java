import java.sql.*;

public class DeleteInTable implements SQLConnection{
    public void DeleteInTable(String header1) throws SQLException {
        //Подключаемся к БД
        Connection connection = null;
        Statement statement = null;
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        //Делаем запрос
        String SQL = "DELETE FROM " + "Notes" + " WHERE header='" +header1 + "'";
        PreparedStatement stmt = connection.prepareStatement(SQL);;

        stmt.executeUpdate();
        System.out.println("Удалена заметка с заголовком\t" + header1);

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
