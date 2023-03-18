import java.sql.*;

public class ExecuteUpdate {
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
        Statement statement = connection.createStatement();


        String sql1= "update companies set number_of_employees = 16000 where number_of_employees<(select avg(number_of_employees) from companies)";
       int numOfRowsUpdated= statement.executeUpdate(sql1);//this methods tell you how many records updated
        System.out.println(numOfRowsUpdated);

        String sql2= "select * from companies";
        ResultSet resultSet = statement.executeQuery(sql2);


        while(resultSet.next()){
            System.out.println(resultSet.getObject(1) + " "+resultSet.getObject(2)+ " "+ resultSet.getObject(3));
        }

connection.close();
        statement.close();

    }

}
