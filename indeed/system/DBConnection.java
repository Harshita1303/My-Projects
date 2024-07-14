package indeed.system;

import java.sql.*;

public class DBConnection {
    
    public Connection con;
    public Statement s;
    public DBConnection(){
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);
           con = DriverManager.getConnection("jdbc:mysql:///indeed", "root", "hh@123");
            s = con.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }
         
        
    }
    
}
