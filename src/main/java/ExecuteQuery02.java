import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {
       Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
    Statement statement = connection.createStatement();



    String sql1 =
            "select company, number_of_employees from companies order by number_of_employees desc\n" +
            "offset 1 row limit 1";

ResultSet rs1 = statement.executeQuery(sql1);
rs1.next();
        System.out.println(rs1.getString("company")+rs1.getInt("number_of_employees"));


    //
        connection.close();
        statement.close();

    }
}
