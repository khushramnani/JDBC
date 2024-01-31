# JDBC Operations Demo

Welcome to the JDBC Operations Demo repository! This repository provides concise Java code snippets demonstrating JDBC (Java Database Connectivity) for connecting to databases and performing basic CRUD (Create, Read, Update, Delete) operations.

# Connecting to a Database using JDBC

To connect to a database using JDBC (Java Database Connectivity), follow these seven steps:

1. **Load the JDBC Driver:**
   Load the appropriate JDBC driver class for your database using `Class.forName()`.

2. **Define Database URL:**
   Construct the JDBC URL to specify the database, its location, and any other required parameters.

3. **Provide Database Credentials:**
   Specify the username and password to authenticate with the database.

4. **Establish Connection:**
   Use `DriverManager.getConnection()` to establish a connection to the database.

5. **Create a Statement:**
   Create a `Statement` object to execute SQL queries.

6. **Execute SQL Queries:**
   Use the `executeQuery()` or `executeUpdate()` methods of the `Statement` object to execute SQL queries.

7. **Process Results and Close Resources:**
   Process the results if needed and close the resources (ResultSet, Statement, and Connection) to release database resources.

Ensure proper exception handling and resource closure, adapting the code based on the specific database you are working with, as JDBC URL and driver class may vary for different databases.


## Contents

- **CreateTable:** Sample Java classes illustrating JDBC connection setup and table creation.
```java
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

```
- **insertTable:** Code snippets for inserting new records into a database using JDBC.
```java
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
```
  
- **updateTable:** Example code for updating records in a database using JDBC.
```java

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

```
- **deleteTable:** Code demonstrating how to delete records from a database using JDBC.
```java
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

```
- **showTable:** Code showcasing how to retrieve and display data from a database using JDBC.
```java
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

```
  
## Getting Started

1. Ensure you have Java installed.
2. Include the Oracle JDBC driver in your project.
3. Explore the code snippets to understand JDBC connections and CRUD operations.

