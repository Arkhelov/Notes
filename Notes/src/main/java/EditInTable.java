import java.sql.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class EditInTable implements SQLConnection{
    int id = 0;
    public void EditInTable(String header) throws SQLException {
        //Подключаемся к БД
        Connection connection = null;
        Statement statement = null;
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        //Делаем запрос
        String SQL = "SELECT * FROM Notes WHERE header='"+header+"'";
        ResultSet resultSet  = statement.executeQuery(SQL);
        Set<String> list = new HashSet<>();
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            this.id = id;
            String head = resultSet.getString(2);
            String text = resultSet.getString(3);
            Date date = resultSet.getDate(4);
            list.add(head+"\n"+text+"\n"+ date +"\n");
        }
        System.out.println("Вы выбрали следующую заметку для редактирования:\n"+list);
        System.out.println("Пожалуйста, введите новый текст заметки");
        Scanner scanner= new Scanner(System.in);
        String text = scanner.nextLine();

        String SQL1 = "UPDATE " + "Notes" + " SET text = '"+text+"' WHERE id = "+id;
        statement.executeUpdate(SQL1);
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
