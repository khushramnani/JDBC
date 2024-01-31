package jdkconnection1;

import java.sql.*;


public class showTable {
    public static void main(String[] args) throws ClassNotFoundException {
        
       try{
           
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
        
        Statement smt = con.createStatement();
        ResultSet rs = smt.executeQuery("SELECT * FROM JDK1");
        
        while(rs.next()){
            int sid = rs.getInt(1);
            String sname = rs.getString(2);
            int sage = rs.getInt(3);
            
            System.out.println("ID: " + sid);
            System.out.println("Name: "+ sname);
            System.out.println("Age: "+ sage);
            System.out.println("");
            
        }
           
       }catch(Exception  e){
           System.out.println(e);
       }
        
        
        
    }
}
