
package bank.management.system;
import java.sql.*;


public class Con {
    
    Connection c;
    Statement s;
    public Con(){
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagement","root","himakarkonanki");
            s =  c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    
}
}
