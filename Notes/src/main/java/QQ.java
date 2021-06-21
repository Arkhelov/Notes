import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class QQ {
    public void Red() throws SQLException {
        System.out.println("Введите номер команды:\n" +
                " 1.Просмотр списка заметок\n 2.Добавить заметку;\n 3.Удалить заметку;\n 4.Редактировать заметку;\n 5.Поиск по ключевому слову;");
        SQLConnector SQL = new SQLConnector();
        SQL.CreateTable();
        Scanner in = new Scanner(System.in);
        switch (in.nextLine()) {
            case ("1") :
                ShowInTable show = new ShowInTable();
                show.ShowInTable();
                break;

            case ("2") :
                System.out.println("Введите заголовок заметки");
                Scanner sc1 =new Scanner(System.in);
                String header = sc1.nextLine();
                System.out.println("Введите текст заметки");
                Scanner sc2 =new Scanner(System.in);
                String text = sc2.nextLine();
                java.util.Date utilDate = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String stringDate= dateFormat.format(utilDate);
                java.sql.Date sqlDate=  java.sql.Date.valueOf(stringDate);
                AddInTable add = new AddInTable();
                add.AddInTable(header, text, sqlDate);
                break;

            case ("3") :
                System.out.println("Введите заголовок заметки");
                Scanner sc3 =new Scanner(System.in);
                String header1 = sc3.nextLine();
                DeleteInTable delete = new DeleteInTable();
                delete.DeleteInTable(header1);
                break;

            case ("4") :
                System.out.println("Введите заголовок для редактирования заметки");
                Scanner sc5 =new Scanner(System.in);
                String header2 = sc5.nextLine();
                EditInTable edit = new EditInTable();
                edit.EditInTable(header2);
                break;

            case ("5") :
                System.out.println("Введите слово/часть слова для поиска");
                Scanner sc4 =new Scanner(System.in);
                String keyWord = sc4.nextLine();
                FindInTable find = new FindInTable();
                find.FindInTable(keyWord);
                break;
            default:
                System.out.println("Введите корректную команду");
        }
        QQ qq = new QQ();
        qq.Red();
    }
}
