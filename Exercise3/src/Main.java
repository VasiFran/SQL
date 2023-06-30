import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        String select_query = "SELECT last_name FROM students";

        ArrayList<String> surnames = new ArrayList<>();

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer","devpass");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(select_query);

            while (resultSet.next()) {
                surnames.add(resultSet.getString("last_name"));
            }

            for (String surname : surnames) {
                System.out.println(surname);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}