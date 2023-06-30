import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String table_create = "CREATE TABLE students(" +
                "student_id int(10) NOT NULL AUTO_INCREMENT," +
                "last_name varchar(30)," +
                "first_name varchar(30)," +
                "CONSTRAINT students_pk PRIMARY KEY (student_id));";

        String insert_students = "INSERT INTO students (last_name, first_name) " +
                "VALUES ('Wright', 'Phoenix'), " +
                        "('Edgeworth', 'Miles'), "+
                        "('Fey', 'Maya'), " +
                        "('Von Karma', 'Franziska')";

        String select_students_surname = "SELECT * FROM students";


        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer","devpass");

            Statement statement = connection.createStatement();

            //statement.executeUpdate(table_create);

            //statement.executeUpdate(insert_students);

            ResultSet resultSet = statement.executeQuery(select_students_surname);

            while(resultSet.next()) {
                System.out.print(resultSet.getString("last_name") + " " +
                                 resultSet.getString("first_name") + "\n");

            }



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

