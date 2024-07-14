package atm.stimulator.system;

import java.sql.*;
        
public class Conn {
    
    public Connection con;
    public Statement s;
    public Conn(){
        
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);

            con = (Connection)DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "hh@123");
            s = ((java.sql.Connection) con).createStatement();
       
        }
        catch(SQLException e){
        e.printStackTrace();
    }
    }
}

            