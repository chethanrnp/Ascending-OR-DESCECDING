package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToReadDataFromTheDB {

	 public static void main(String[] args) throws Throwable {
		 
		 Driver driverReference=new Driver();
		 //register to DB
		 DriverManager.registerDriver(driverReference);
		 //connection to DB
		 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		 //create statement 
		 Statement statement = connection.createStatement();
		//execute query
		 String Query = "Select * from project";
		 ResultSet result = statement.executeQuery(Query);
		 while(result.next()) {
			 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+result.getString(4));
		 }
		 connection.close();
	 }
	 
}
