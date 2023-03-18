import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {

        Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
        Statement statement = connection.createStatement();


        //
        String sql1= "SELECT country_name from countries where region_id =1";
        boolean r1= statement.execute(sql1);//if you use execute() method, it will return true or false
        System.out.println(r1);

        //To see the records we have another method which is executeQuery()  that return Resultset
        ResultSet resultset1 = statement.executeQuery(sql1);
        resultset1.next();
        resultset1.next();
        resultset1.next();
        String country = resultset1.getString("country_name");
        System.out.println(country);


        ResultSet resultSet1=statement.executeQuery(sql1);
        while(resultSet1.next()){
            System.out.println( resultSet1.getString("country_name"));
        }


        System.out.println(" ");
        //2. example

        String sql2= "select country_id, country_name from countries where region_id>2";

         ResultSet resultSet2 =statement.executeQuery(sql2);

         while(resultSet2.next()){
             System.out.println(resultSet2.getString("country_id")+ "---->"+resultSet2.getString("country_name"));
         }

//Example 3

        String sql3= "select * from companies where number_of_employees =(select min(number_of_employees) from companies)";

ResultSet resultset3=statement.executeQuery(sql3);

while(resultset3.next()){
    System.out.println(resultset3.getInt(1)+resultset3.getString(2)+resultset3.getInt(3));
}








    }
}
