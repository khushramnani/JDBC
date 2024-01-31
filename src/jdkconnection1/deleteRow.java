package jdkconnection1;

import java.sql.*;
import java.util.Scanner;


public class deleteRow {
     public static void main(String[] args) throws ClassNotFoundException {
         try{
             Class.forName("oracle.jdbc.driver.OracleDriver");
             Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","manager");
             Statement smt = con.createStatement();
             Scanner in = new Scanner(System.in);
             System.out.print("enter your id for deletion: ");
             int Gid = in.nextInt();
             
             int delete = smt.executeUpdate("DELETE FROM jdk1 WHERE id="+Gid);
             
             if(delete>0){
                 System.out.println("Row Deleted Succesfully");
             }else System.out.println("Invalid Oparation");
                     

         }catch(Exception e){
             System.out.println(e);
         }
    }
   
}
