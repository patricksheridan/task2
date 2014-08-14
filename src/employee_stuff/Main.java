package employee_stuff;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class driver = Class.forName("com.mysql.jdbc.Driver");
		Connection c = 
		      DriverManager.getConnection("jdbc:mysql://localhost/task2", 
		            "root", "ch@ngeme1");
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery(
		      "SELECT idEmployee, FName FROM Employee");
		while(rs.next()){
		   String out = String.format("%s is in %s.", 
		   rs.getString("idEmployee"), rs.getString("FName"));
		   System.out.println(out);
		}

	}

}
