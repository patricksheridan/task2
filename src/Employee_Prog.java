import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.*;

public class Employee_Prog {

	
		
		
		

	public static void main(String[] args)
	{
		promptPassword();
		
	}

	
	
	
	
	public static void MainScreen()
	{
		JButton buttonA, buttonB, buttonC;
		final DefaultListModel model = new DefaultListModel();
		final JList area;
		JRadioButton employeeButton, sales_employeeButton;
		
			
		JFrame Employee = new JFrame("Employee System");
		FlowLayout layout = new FlowLayout();
		
		JPanel panelTop = new JPanel();
		JPanel panelBottom = new JPanel();
		
		panelTop.setSize(800,400);
		panelBottom.setSize(800,400);
		
		
		panelBottom.setLayout(new GridLayout(2,3));
		
		
		Employee.setSize(800,800);
		Employee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Employee.setLayout(layout);
		
		Employee.add(panelTop);
		Employee.add(panelBottom);
		

		Employee.setVisible(true);
		
		Dimension d = new Dimension(100,40);
		
		Dimension c = new Dimension(800,400);
		
		area = new JList(model);
		area.setSize(500, 500);
		area.setVisible(true);
		area.setSize(c);
		area.setMinimumSize(c);
		area.setMaximumSize(c);
		area.setPreferredSize(c);
		
		buttonA = new JButton("Create");
		//buttonA.setSize(30,60);
		buttonA.setVisible(true);
		buttonA.setSize(d);
		buttonA.setMinimumSize(d);
		buttonA.setMaximumSize(d);
		buttonA.setPreferredSize(d);

		
		
		buttonB = new JButton("Update");
		//buttonB.setSize(30, 60);
		buttonB.setVisible(true);
		buttonB.setSize(d);
		buttonB.setMinimumSize(d);
		buttonB.setMaximumSize(d);
		buttonB.setPreferredSize(d);
		
		
		buttonC = new JButton("Delete");
		//buttonC.setSize(30, 60);
		buttonC.setVisible(true);
		buttonC.setSize(d);
		buttonC.setMinimumSize(d);
		buttonC.setMaximumSize(d);
		buttonC.setPreferredSize(d);
		
		
		employeeButton = new JRadioButton("Employee Database");
		employeeButton.setSize(d);
		employeeButton.setVisible(true);
		employeeButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
            	model.clear();
            	String headers = "ID\t\t\t Name\t Salary\t";
            	model.addElement(headers);
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
        			while(rs.next()) {
        				String out = String.format("%s\t %s %s %s\t", rs.getString("idEmployee"), rs.getString("FName"), 
        						rs.getString("SName"), rs.getString("Salary"));
        				model.addElement(out);
        			}
        		} catch(SQLException e2) {
        			System.out.println(e2.getMessage());
        		}
            } 
          } );
		
		
		sales_employeeButton = new JRadioButton("Sales Employee Database");
		sales_employeeButton.setSize(d);
		sales_employeeButton.setVisible(true);
		sales_employeeButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
            	model.clear();
            	String headers = "ID\t Name\t Salary\t CommissionRate\t SalesTotal\t";
            	model.addElement(headers);
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
        					"SELECT idSalesEmployee, FName, SName, Salary, CommissionRate, SalesTotal FROM SalesEmployee"
        					+ " JOIN Employee ON idEmployee = idSalesEmployee");
        			while(rs.next()) {
        				String out = String.format("%s\t %s %s\t %s\t %s\t %s\t", rs.getString("idSalesEmployee"), rs.getString("FName"), 
        						rs.getString("SName"), rs.getString("Salary"), rs.getString("CommissionRate"), 
        						rs.getString("SalesTotal"));
        				model.addElement(out);
        			}
        		} catch(SQLException e2) {
        			System.out.println(e2.getMessage());
        		}
            } 
          } );
		
		ButtonGroup group = new ButtonGroup();
		group.add(employeeButton);
		group.add(sales_employeeButton);
		
		panelTop.add(area);
		panelBottom.add(buttonA);
		panelBottom.add(buttonB);
		panelBottom.add(buttonC);
		panelBottom.add(employeeButton);
		panelBottom.add(sales_employeeButton);
	
		Employee.getContentPane().validate();
        Employee.getContentPane().repaint();
	}
	
	public static void promptPassword(){
		String username = "Kainos";
		String password = "Password";
		
		String user = JOptionPane.showInputDialog("What is your username");
		String pass = JOptionPane.showInputDialog("What is your password?");
		{
		if (user.equals(username) && pass.equals(password))
		{
			JOptionPane.showMessageDialog(null, "Login successful");
			MainScreen();
			
			
		}
		
		
		else {
			JOptionPane.showMessageDialog(null, "Login unsuccessful");
				promptPassword();
		}
		
		}
	}
}
	




