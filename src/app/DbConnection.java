package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

	public static Connection dbConnect() {
		try {
			Class driver = Class.forName("com.mysql.jdbc.Driver");
			
			Connection c = 
					DriverManager.getConnection("jdbc:mysql://localhost/task2", 
		            "root", "ch@ngeme1");
			
			return c;
		} catch(ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
			
			return null;
		} catch(SQLException e2) {
			System.out.println(e2.getMessage());
			
			return null;
		}
	}
}
