package a.jdbcintro;

import java.sql.*;
import java.sql.SQLException;

public class AJDBCIntroduction {
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
    static String invalidMysqlDBConnectorPath = "com.mysql.cj.jdbc.Driver"; // This is the default MYSQL Driver Path


    public static void main(String[] args) throws SQLException {

        System.out.println("1. SQL Code without Defined Exception - SQLException ");
//        // 1. Load MySQL Driver
//        Class.forName(mysqlDBConnectorPath); // This is the default address - com.mysql.cj.jdbc.Driver to  load mySQL Driver
//
//        // Step 2: Connect to DB
//        // Connection is the interface that helps to create connection of MySQL DB Connection
//        // DriverManager is the class that helps take DB Parameters such as MYSQLDB URL Address,
//        //MYSQL Username & Password
//      Connection createSQLConnection = DriverManager.getConnection( // Once the user defines DriverManager.getConnection it ask for Unhandled exception: java.sql.SQLException
//              mysqlDBURL,  // In the following line jdbc:mysql://localhost:3306/dbname; jdbc:mysql: is the default address, 3306 is the default port,
//              mySQLDBUsername,  // root is the MYSQL DB username
//              mySQLDBPassword // MYSQL DB password
//        );
//
//      //Step 3: Create Statement of the DB
//        // Create Statement is the interface which helps to create Statement
//        // which the help of createSQLConnection Object of Connection Interface call the createStatement() inbuilt method
//      Statement createSQLStatementExecute = createSQLConnection.createStatement(); //Once the user defines createSQLConnection.createStatement() it ask for Unhandled exception: java.sql.SQLException
//
//
//      //Step 4 Display the mySQL DB Result using ResultSet
//
//        // ResultSet is the Interface that helps to execute SQL Query.
//        // which the help of createSQLConnection Object of Connection Interface call the executeQuery(String) inbuilt method
//
//
//        ResultSet displaySQLResultOutput = createSQLStatementExecute.executeQuery(mySqlQuery); //Once the user defines createSQLStatementExecute.executeQuery(mySqlQuery) it ask for Unhandled exception: java.sql.SQLException
//        // System.out.println("1. Printing My SQL DB Table Output When the Columns Names arent known ");
//        // in the following code we dont know the columns names, only count is remember
//        // we have mentioned the column indexes instead of Names
////        while (displaySQLResultOutput.next()) {   // next refers to no of row with dedicated columns
////            System.out.println(
////                    displaySQLResultOutput.getInt(1) + " | " +   // student_id
////                            displaySQLResultOutput.getString(2) + " | " + // name
////                            displaySQLResultOutput.getDate(3) + " | " +   // dob
////                            displaySQLResultOutput.getString(4) + " | " + // gender
////                            displaySQLResultOutput.getString(5) + " | " + // email
////                            displaySQLResultOutput.getLong(6) + " | " +   // phone
////                            displaySQLResultOutput.getString(7) + " | " + // address
////                            displaySQLResultOutput.getDouble(8) + " | " + // marks
////                            displaySQLResultOutput.getDouble(9) + " | " + // percentage
////                            displaySQLResultOutput.getBoolean(10) + " | " + // is_active
////                            displaySQLResultOutput.getTimestamp(11) + " | " + // created_at
////                            displaySQLResultOutput.getString(12) + " | " + // photo
////                            displaySQLResultOutput.getString(13) + " | " + // hobbies
////                            displaySQLResultOutput.getString(14)           // extra_info
////            );
////        }
////
////        System.out.println("2. Printing My SQL DB Table Output When the Columns Names are known ");
////        //In the following Code we have names of Columns Names known for particular Row
////        while (displaySQLResultOutput.next()) {
////            System.out.println(
////                    displaySQLResultOutput.getInt("student_id") + " | " +
////                            displaySQLResultOutput.getString("name") + " | " +
////                            displaySQLResultOutput.getDate("dob") + " | " +
////                            displaySQLResultOutput.getString("gender") + " | " +
////                            displaySQLResultOutput.getString("email") + " | " +
////                            displaySQLResultOutput.getLong("phone") + " | " +
////                            displaySQLResultOutput.getString("address") + " | " +
////                            displaySQLResultOutput.getDouble("marks") + " | " +
////                            displaySQLResultOutput.getDouble("percentage") + " | " +
////                            displaySQLResultOutput.getBoolean("is_active") + " | " +
////                            displaySQLResultOutput.getTimestamp("created_at") + " | " +
////                            displaySQLResultOutput.getString("photo") + " | " +
////                            displaySQLResultOutput.getString("hobbies") + " | " +
////                            displaySQLResultOutput.getString("extra_info")
////            );
////        }
//
//        System.out.println("3. Printing My SQL DB Table Output When the Columns & Rows Names arent known, This Is very Effective Way");
//        // ResultSetMetaData is the interface which helps to get the MySQL DB Table Detail
//        //with the help of displaySQLResultOutput Object of ResultSet Interface call the getMetaData() inbuilt method
//        // getMetaData() is the inbuilt method which helps to find MySQL DB Table Detail
//        //with the help of sqlTableDetails Object of ResultSetMetaData Interface call the getColumnCount() inbuilt method
//        // getColumnCount() is the inbuilt method of ResultSetMetaData Interface which helps to find MySQL DB Table column Count
//
//        ResultSetMetaData sqlTableMetaDataDetails = displaySQLResultOutput.getMetaData();
//        int tableColumnCount = sqlTableMetaDataDetails.getColumnCount();
//
//
//        // In the following code we have used for loop to iterate each column
//        //with the help of sqlTableDetails Object of ResultSetMetaData Interface call the getColumnName() inbuilt method
//        // getColumnName() is the inbuilt method of ResultSetMetaData Interface which helps to find MySQL DB Table columns Names
//
//
//        for (int i = 1; i <= tableColumnCount; i++) {
//            System.out.print(sqlTableMetaDataDetails.getColumnName(i) + "\t"); //Once the user defines createSQLConnection.createStatement() it ask for Unhandled exception: java.sql.SQLException
//        }
//        System.out.println();
//
//        // Print rows
//        while (displaySQLResultOutput.next()) {
//            for (int i = 1; i <= tableColumnCount; i++) {
//                System.out.print(displaySQLResultOutput.getString(i) + "\t");  // getString in the inbuilt method of ResultSet which helps to print the MySql DB Table Data
//            }
//            System.out.println();
//        }
//        createSQLConnection.close(); // createSQLConnection is the object of Connection Interface,To Avoid the Memory Leakage its always good practice to close connection
//        createSQLStatementExecute.close(); // createSQLStatementExecute is the object of Statement Interface, To Avoid the Memory Leakage its always good practice to close connection
//        displaySQLResultOutput.close(); // displaySQLResultOutput is the object of ResultSet Interface,To Avoid the Memory Leakage its always good practice to close connection



    }
}
