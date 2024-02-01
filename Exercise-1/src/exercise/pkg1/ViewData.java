package exercise.pkg1;

import java.sql.*;
import java.util.Scanner;

public class ViewData {
    public static void main(String[] args) throws ClassNotFoundException{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement smt = con.createStatement();
            ResultSet rs = smt.executeQuery("SELECT * FROM COMPANY");
            Scanner in = new Scanner(System.in);
            while(rs.next()){
                int vid = rs.getInt(1);
                String vname = rs.getString(2);
                String vadd = rs.getString(3);
                String vemail = rs.getString(4);
                int vphno = rs.getInt(5);
                        
                System.out.println(vid);
                System.out.println(vname);
                System.out.println(vadd);
                System.out.println(vemail);
                System.out.println(vphno);
                System.out.println();
        
                        

            }
            
        
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
