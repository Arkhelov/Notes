import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class FindInTable implements SQLConnection{
    public void FindInTable(String keyWord) throws SQLException {
        //Подключаемся к БД
        Connection connection = null;
        Statement statement = null;
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        //Делаем запрос
        String SQL = "SELECT * " +
                " FROM Notes" +
                " WHERE header LIKE '%" + keyWord + "%' OR text LIKE '%" + keyWord + "%';";
        ResultSet resultSet = statement.executeQuery(SQL);
        Set<String> list = new HashSet<>();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String head = resultSet.getString(2);
            String text = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            list.add(head + "\n" + text + "\n" + date + "\n");
        }
         if (list.isEmpty()){
             System.out.println("Ничего не найдено\n");
         } else {
        System.out.println(list);
         }

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
