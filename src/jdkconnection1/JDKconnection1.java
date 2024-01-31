package jdkconnection1;

import java.sql.*;

public class JDKconnection1 {


    public static void main(String[] args) throws ClassNotFoundException {
        try{
            //load driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
//            making connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            
            Statement stm = con.createStatement();
            stm.executeUpdate("CREATE TABLE Jdk1 (id NUMBER, name VARCHAR(12), age NUMBER)");
            System.out.println("Table Created succesfully");
            
            con.close();

            
            
        }catch(Exception e){
            System.out.println(e);
        }
            
        
    }
    
}
