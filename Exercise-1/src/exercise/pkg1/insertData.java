package exercise.pkg1;

import java.sql.*;
import java.util.Scanner;

public class insertData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
            try{
                        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
        PreparedStatement pmt = con.prepareStatement("INSERT INTO COMPANY VALUES(?,?,?,?,?)");
        Scanner in = new Scanner(System.in);
        
        System.out.println("Do you want to insert data into table");
        String Check = in.next();
        
        if(Check.equalsIgnoreCase("yes")){
        while(true){
            System.out.println("Enter your company id: ");
            int Id = in.nextInt();
            
            System.out.println("Enter your name: ");
            String name =in.next();
            
            System.out.println("Enter your Address: ");
            String add = in.next();
            
            System.out.println("Enter Your Email: ");
            String Email = in.next();
            
            System.out.println("enter Your Phone Number: ");
            int Phno = in.nextInt();
            
            pmt.setInt(1, Id);
            pmt.setString(2,name);
            pmt.setString(3,add);
            pmt.setString(4,Email);
            pmt.setInt(5,Phno);
            


            
            int insert = pmt.executeUpdate();
            
            if(insert>0){
                System.out.println("DATA ADDED SUCCESFULLY..");
            }else System.out.println("DATA NOT ADDED");
                 
            System.out.println("DO you want to insert more data [yess/no]");
            Check = in.next();
            if(Check.equalsIgnoreCase("no"))
            break;
            
        }
        
        }
        
            }catch(Exception e){
                System.out.println(e);
                        
            }
        
        
    }
}
