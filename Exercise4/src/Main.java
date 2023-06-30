import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String alter = "ALTER TABLE students ADD COLUMN country varchar(30);";

        String update1 = "UPDATE students SET country = 'italy' WHERE student_id = 1;";
        String update2 = "UPDATE students SET country = 'italy' WHERE student_id = 2;";
        String update3 = "UPDATE students SET country = 'germany' WHERE student_id = 3;";
        String update4 = "UPDATE students SET country = 'germany' WHERE student_id = 4;";

        String select = "SELECT * FROM students";
        
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer","devpass");
            Statement statement = connection.createStatement();

            statement.executeUpdate(alter);
            statement.executeUpdate(update1);
            statement.executeUpdate(update2);
            statement.executeUpdate(update3);
            statement.executeUpdate(update4);

            ResultSet resultSet = statement.executeQuery(select);

            while(resultSet.next()) {
                System.out.print(resultSet.getString("last_name") + " " +
                        resultSet.getString("first_name") + " " +
                        "from: " + " " +
                        resultSet.getString("country") +
                        "\n");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}