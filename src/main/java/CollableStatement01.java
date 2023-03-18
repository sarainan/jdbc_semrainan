import java.sql.*;
import java.util.LinkedList;

public class CollableStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");
        Statement statement = connection.createStatement();

        String sql1 = " create or replace function additionF(x numeric,  y numeric) returns numeric language plpgsql as $$ begin return x+y; end  $$";
        statement.execute(sql1);
        CallableStatement cs1 =connection.prepareCall("{? = call additionF(?,?)}");

        cs1.registerOutParameter(1,Types.NUMERIC);
        cs1.setInt(2,6);
        cs1.setInt(3,4);


        cs1.execute();

        System.out.println(cs1.getObject(1));





    }
}
