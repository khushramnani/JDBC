package jdkconnection1;

import java.sql.*;
import java.util.Scanner;

public class JDK_insert {

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "manager");
            PreparedStatement pmt = con.prepareStatement("INSERT INTO jdk1 VALUES(?,?,?)");
            Scanner in = new Scanner(System.in);

            while (true) {
                System.out.print("Enter your ID: ");
                int id = in.nextInt();

                System.out.print("Enter your Name: ");
                String name = in.next();

                System.out.print("enter your age ");
                int age = in.nextInt();

                pmt.setInt(1, id);
                pmt.setString(2, name);
                pmt.setInt(3, age);

                int count = pmt.executeUpdate();
                if (count > 0) {
                    System.out.println("Row Added Sucsesfully");
                } else {
                    System.out.println("invalid operation");
                }

                System.out.println("Do you wanted to stored more values?[yes]");

                String Check = in.next();
                if (Check.equalsIgnoreCase("no")) {
                    break;
                }

            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
