import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
       Statement statement = connection.createStatement();
        // Statement statement = connection.createStatement();

        //1.step Create prepared statement query

        String sql1 = "update companies set number_of_employees= ? where company  = ? ";

        //2.step: Create prepared statement Object

        PreparedStatement ps1 = connection.prepareStatement(sql1);

        //3.step : assign the values by using 'setInt(), setString().... methods'
        ps1.setInt(1,9999);
        ps1.setString(2,"IBM");

        //4.step: execute the query


        int numberOfRecords=ps1.executeUpdate();
        System.out.println(numberOfRecords);

        String sql2 = "select * from companies";
        ResultSet rs1 = statement.executeQuery(sql2);
        while(rs1.next()){
            System.out.println(rs1.getObject(1)+ " "+rs1.getObject(2) + " "+rs1.getObject(3));
        }








    }
}
