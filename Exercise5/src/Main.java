import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        String italian_view = "CREATE VIEW italian_students AS " +
                              "SELECT first_name, last_name " +
                              "FROM students WHERE country = 'italy';";
        String german_view = "CREATE VIEW german_students AS " +
                            "SELECT first_name, last_name " +
                            "FROM students WHERE country = 'germany';";
        String italian_select = "SELECT first_name, last_name FROM italian_students;";
        String german_select = "SELECT first_name, last_name FROM german_students;";

        ArrayList<Students> italianStudents = new ArrayList<>();
        ArrayList<Students> germanStudents = new ArrayList<>();

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer","devpass");

            Statement statement = connection.createStatement();

            statement.executeUpdate(italian_view);
            statement.executeUpdate(german_view);

            ResultSet resultSet = statement.executeQuery(italian_select);
            while (resultSet.next()) {
                String name = resultSet.getString("first_name");
                String surname = resultSet.getString("last_name");
                italianStudents.add(new Students(name,surname));
            }

            resultSet = statement.executeQuery(german_select);
            while (resultSet.next()) {
                String name = resultSet.getString("first_name");
                String surname = resultSet.getString("last_name");
                germanStudents.add(new Students(name, surname));
            }

            System.out.println("------Italian Students------");
            for(Students student : italianStudents) {
                System.out.println(student.getName() + " " + student.getSurname());
            }

            System.out.println("------German Students------");
            for(Students student : germanStudents) {
                System.out.println(student.getName() + " " + student.getSurname());
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}