
package exercise.pkg1;

import java.sql.*;
//import java.util.Scanner;

 public class Exercise1 {

    public static void main(String[] args) throws ClassNotFoundException{
       try{
           Class.forName("oracle.jdbc.driver.OracleDriver");
           Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
           Statement smt = con.createStatement();
           smt.executeQuery("CREATE TABLE COMPANY (Id NUMBER PRIMARY KEY , CompName VARCHAR(12), CompAddr VARCHAR(20),CompEmail VARCHAR(20) , CompPhone NUMBER(10))");


//             smt.executeUpdate("drop table COMPANY");
           
           System.out.println("TABLE CREATED SUCCESFULLY...");
           
//           System.out.println("db connected");
       }catch(ClassNotFoundException | SQLException e){
           System.out.println(e);
       }}
    }
    

