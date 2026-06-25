package a.jdbcintro;

import java.sql.*;

public class BJDBCCodeInvalid {
    /*
    points to remember
    JDBC stands for Java Data Base Connectivity
    Java helps to connect the database, execute the SQL Queries
    Prerequisites
    1. Ensure that your database must be setup and should be work properly Manually.
    In our case, we are using MySQL
    2. Download the MySQL JDBC Driver Jar File from https://dev.mysql.com/downloads/connector/j/, Download the Zip File & Extract the Zip File to Extract .jar File
    To Import MY SQL Connector In IntelliJ use the following steps -- Go to File Menu >>> Project Structure >> Modules >> Click on + icon and add the mySQL Connector Jar
    3. Load SQL Driver & Create Connection
    4. Create statement to pass the MySQL Db Query.
    5. Execute Query Through ResultSet
    6. Display the Output using while loop & next() inbuilt method of ResultSet
    7. To Avoid the Memory leakage, Close the Connection of Connection, Statement & ResultSet

    Note - Once the user writes the code of MySQL com.mysql.cj.jdbc.Drive it requires an compile Time Exception that is SQLException

     */

    static String mysqlDBConnectorPath = "com.mysql.cj.jdbc.Driver"; // This is the default MYSQL Driver Path
    static String mysqlDBURL = "jdbc:mysql://localhost:3306/learnsqldetail";   // this is 	//
    static String mySQLDBUsername = "root";
    static String mySQLDBPassword = "Uddeshya@1911";
    static String mySqlQuery = "SELECT * FROM student_detail;";
    static String invalidMysqlDBURL = "jdbc:mysql://localhost:2306/learnsqldetail";   // this is 	//
    static String invalidMySQLDBUsername = "root1";
    static String invalidMySQLDBPassword = "Uddeshya@19sd11";
    static String invalidMySqlQuery = "SELECT * FROM student_detail&*;";
    static String InvalidMysqlDBConnectorPath = "com.mysql.cj.jdbc.Driver"; // This is the default MYSQL Driver Path


    public static void main(String[] args) throws SQLException {


        System.out.println("1. SQL Code with Invalid Details");
        //Connection is the interface that helps to create connection of MySQL DB Connection
        // DriverManager is the class that helps take DB Parameters such as MYSQLDB URL Address,
        //MYSQL Username & Password
        Connection createSQLConnection2 = DriverManager.getConnection( // Once the user defines DriverManager.getConnection it ask for Unhandled exception: java.sql.SQLException,
                // To Handle Unhandled Exception, we need to use SQLException with try Catch Block or Add SQLException Exception to Method
                mysqlDBURL,  // In the following line jdbc:mysql://localhost:3306/dbname; jdbc:mysql: is the default address, 3306 is the default port,
                // invalidMysqlDBURL,  // In the following line we have passed invalid DBPath, its throws an RuntimeException named as ConnectionRefused Exception
                mySQLDBUsername,  // root is the Valid MYSQL DB username
               //   invalidMySQLDBUsername ---- root1 is the Invalid MYSQL DB username,
              //  it throws an RunTimeException Named as SQLException with the following message Exception in thread "main" java.sql.SQLException: Access denied for user 'root1'@'localhost' (using password: YES)
                mySQLDBPassword// MYSQL DB valid password
               // invalidMySQLDBPassword // root1 is the Invalid MYSQL DB password,
                //  it throws an RunTimeException Named as SQLException with the following message Exception in thread "main" java.sql.SQLException: Access denied for user 'root1'@'localhost' (using password: YES)

        );

        //Step 3: Create Statement of the DB
        // Create Statement is the interface which helps to create Statement
        // which the help of createSQLConnection Object of Connection Interface call the createStatement() inbuilt method
        Statement createSQLStatementExecute2 = createSQLConnection2.createStatement(); //Once the user defines createSQLConnection.createStatement() it ask for Unhandled exception: java.sql.SQLException
        // To Handle Unhandled Exception, we need to use SQLException with try Catch Block or Add SQLException Exception to Method

        //Step 4 Display the mySQL DB Result using ResultSet

        // ResultSet is the Interface that helps to execute SQL Query.
        // which the help of createSQLConnection Object of Connection Interface call the executeQuery(String) inbuilt method


      //  ResultSet displaySQLResultOutput = createSQLStatementExecute2.executeQuery(mySqlQuery); //Once the user defines createSQLStatementExecute.executeQuery(mySqlQuery) it ask for Unhandled exception: java.sql.SQLException

        ResultSet displaySQLResultOutput2  = createSQLStatementExecute2.executeQuery(invalidMySqlQuery); // In the following code we have defined Invalid SQL Query
        //It throw an Exception as Exception in thread "main" java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '&*' at line 1

        // To Handle Unhandled Exception, we need to use SQLException with try Catch Block or Add SQLException Exception to Method

    }
}
