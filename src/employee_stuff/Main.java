package employee_stuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		outputMenu();
	}

	private static void outputMenu() {
		System.out.println("Choose a menu option: ");
		System.out.println("1. List all employees");
		Scanner myScanner = new Scanner(System.in);
		int menuOption = myScanner.nextInt();
		if (menuOption == 1) {
			listAllEmployees();
		} else if(menuOption == 2) {
		}
	}

	private static void listAllEmployees() {
		try {
			Class driver = Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		try {
			Connection c = 
					DriverManager.getConnection("jdbc:mysql://localhost/task2", 
		            "root", "ch@ngeme1");
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT idEmployee, FName, SName, Salary FROM Employee");
			while(rs.next()){
				String out = String.format("Employee %s: %s %s has a salary of %s.", 
						rs.getString("idEmployee"), rs.getString("FName"), rs.getString("SName"),
						rs.getString("Salary"));
				System.out.println(out);
				
			}
		} catch(SQLException e2) {
			System.out.println(e2.getMessage());
		}
	}
	
	private static void createEmployee(String name, float Salary, float Bonus) {
		Employee emp = new Employee();
		try {
			Class driver = Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e1) {
			System.out.println(e1.getMessage());
		}
		try {
			Connection c = 
					DriverManager.getConnection("jdbc:mysql://localhost/task2", 
		            "root", "ch@ngeme1");
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(
					"SELECT idEmployee, FName, SName, Salary FROM Employee");
		} catch(SQLException e2) {
			System.out.println(e2.getMessage());
		}
	}
}
