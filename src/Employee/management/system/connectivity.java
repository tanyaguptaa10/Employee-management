
package Employee.management.system;
import java .sql.*; // connection interface is in sql method so we have to import

 public class connectivity {
    Connection c; // interface
    Statement s;
    public connectivity(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); // register the driver class
       c = DriverManager.getConnection("jdbc:mysql:///employeshow","root","123456");//Connection  string // in this static method " getconnection which string  you are using 
       s = c.createStatement();// create a statement
        }catch (Exception e ){
            e.printStackTrace();
        }
                 
    }
    
}
 