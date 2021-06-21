import java.sql.*;
import java.sql.Date;
import java.util.*;

public class ShowInTable implements SQLConnection{
    public void ShowInTable() throws SQLException {
        //Подключаемся к БД
        Connection connection = null;
        Statement statement = null;
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        //Делаем запрос
        String SQL = "SELECT id,header,text,date FROM Notes";
        ResultSet resultSet  = statement.executeQuery(SQL);
        //Добавляем полученные данные в список
        List<String> list = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String head = resultSet.getString(2);
            String text = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            list.add( "\n\n"+" Заголовок - " +head+"\n Текст заметки - "+text+"\n Дата создания - "+ date);
        }
        System.out.println(list+"\n");

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
