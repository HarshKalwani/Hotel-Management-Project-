import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {

    Connection c;  //creating connection
    Statement s ;  //3. Creating statement

    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");   
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/dolihotels" , "root","ryuga21");
            s= c.createStatement(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
