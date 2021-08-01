package DBConnection;
import java.sql.*;
public class DBHandler{
	
	
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection dbconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/covid-19","Ankit","Ankit");
		System.out.println("Connection Created");
		return dbconn;
	}
}
