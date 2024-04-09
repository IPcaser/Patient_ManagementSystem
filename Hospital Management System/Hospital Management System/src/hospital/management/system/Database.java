

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital.management.system;
import java.sql.Connection;
import java.sql.DriverManager;


public class Database {
     public static Connection dbConnection() throws Exception
    {
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/suru", "root","surabhi");
        return(con); 
    }  
}


//        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","surabhi");
//        Class.forName("oracle.jdbc.driver.OracleDriver");
