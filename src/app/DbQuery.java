package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbQuery {

	public static ResultSet executeQuery(String query) {
		Connection c = DbConnection.dbConnect();
		if(null == c) {
			return null;
		}
		try {
		Statement st = c.createStatement();
		ResultSet rs = st.executeQuery(query);

		return rs;
		} catch(SQLException e) {
			System.out.println(e.getMessage());

			return null;
		}
	}
	
	public static PreparedStatement executeUpdate(String query) {
		Connection c = DbConnection.dbConnect();
		if(null == c) {
			return null;
		}
		try {
		PreparedStatement ps = c.prepareStatement(query);
		ps.executeUpdate();

		return ps;
		} catch(SQLException e) {
			System.out.println(e.getMessage());

			return null;
		}
	}
}
