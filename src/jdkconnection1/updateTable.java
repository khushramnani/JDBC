
package jdkconnection1;

import java.sql.*;
import java.util.Scanner;

public class updateTable {
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement smt = con.createStatement();
            Scanner in = new Scanner(System.in);
            
            
            while(true){
            System.out.println("Enter which column you want to change ?: ");
            String Scol = in.next();
            
            System.out.print("Enter your Id Which you want to update: ");
            int Gid = in.nextInt();
            if(Scol.equalsIgnoreCase("name")){
                
                
                System.out.println("Enter your new name: ");
                String name = in.next();
                int upname = smt.executeUpdate("UPDATE jdk1 SET name = '"+name + "'WHERE id =" +Gid);
                if(upname>0){
                    System.out.println("Name changed succesfully");
                }else System.out.println("name not changed");
                
            }else if(Scol.equalsIgnoreCase("age")){
                System.out.println("Enter your new age: ");
                int Gage = in.nextInt();
                int Upage = smt.executeUpdate("UPDATE jdk1 SET age = "+Gage+"WHERE id = "+Gid);
                if(Upage>0){
                    System.out.println("AGE changed succesfully");
                    
                }else System.out.println("Age not changed");
            }
                System.out.println("do you want to changed more colums[yess/no]");
                String Check = in.next();
                if(Check.equalsIgnoreCase("no"))
                    break;
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
