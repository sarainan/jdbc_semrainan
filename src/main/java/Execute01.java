import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.Step : Registration to driver

        Class.forName("org.postgresql.Driver"); //This is not neccessary since JDBC 4

//2.Step: Create connection to database

        Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");

        //3 Step : Create Statement

       Statement statement =  connection.createStatement();

       //4. Step : Execute query
        //execute() method can be used in ddl (data definition language -create table,drop table, alter table)
        //1) if you use execute  method in ddl everytime you will get false because you will not get any data

        //dql(data quary language- select)
        //1) if you use execute  method in dgl everytime you will get false or true because may get a data from select query






        String sql1 = "create table workers(worker_id VARCHAR(50), worker_name varchar(50), worker_salary int)";
        boolean sqlResult = statement.execute(sql1);
        System.out.println(sqlResult);

        String sql2 = "alter table workers add worker_address varchar(100)";
        statement.execute(sql2);


//        String dropTable = " drop table workers";
//        statement.execute(dropTable);


        //5. Step : Close the connection and statement

        connection.close();
        statement.close();









    }
}
