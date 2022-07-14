package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ToAddDataFromTheDB {

	 public static void main(String[] args) throws Throwable {
	   Driver driverRefrence = new Driver();
	   DriverManager.registerDriver(driverRefrence);
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	    Statement stat = con.createStatement();
	   String query = "select * from project";
	   ResultSet result = stat.executeQuery(query);
	   while(result.next()) {
		   System.out.println(result.getString(1)+","+result.getString(2)+"="+result.getString(3));
	   }
	   
	}
}
