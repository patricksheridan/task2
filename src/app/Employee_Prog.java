package app;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import employee.Employee;

public class Employee_Prog extends JFrame{

	public static void main(String[] args)
	{
		promptPassword();
	}

	private static JButton buttonCreate, buttonUpdate, buttonDelete;
	private final static DefaultTableModel model = new DefaultTableModel() {
		@Override
	    public boolean isCellEditable(int row, int column) {
	       return false;
	    }
	};
	private static JTable table;
	private static JScrollPane scrollPane;
	private static JRadioButton employeeButton, sales_employeeButton;
	
	public static void MainScreen()
	{
			
		JFrame Employee = new JFrame("Employee System");
		FlowLayout layout = new FlowLayout();
		
		JPanel panelTop = new JPanel();
		JPanel panelBottom = new JPanel();
		
		panelTop.setSize(800,400);
		panelBottom.setSize(800,400);
		
		
		panelBottom.setLayout(new GridLayout(2,3));
		
		
		Employee.setSize(850,650);
		Employee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Employee.setLayout(layout);
		
		Employee.add(panelTop);
		Employee.add(panelBottom);
		

		Employee.setVisible(true);
		
		Dimension buttonDimensions = new Dimension(100,40);
		
		Dimension tableDimensions = new Dimension(800,400);

		table = new JTable();
		table.setModel(model);
		table.setSize(500, 500);
		table.setVisible(true);
		table.setSize(tableDimensions);
		table.setMinimumSize(tableDimensions);
		table.setMaximumSize(tableDimensions);
		table.setPreferredSize(tableDimensions);
		
		buttonCreate = new JButton("Create");
		buttonCreate.setVisible(true);
		buttonCreate.setSize(buttonDimensions);
		buttonCreate.setMinimumSize(buttonDimensions);
		buttonCreate.setMaximumSize(buttonDimensions);
		buttonCreate.setPreferredSize(buttonDimensions);
		buttonCreate.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
            	Employee empToAdd = new Employee("Test", "Guy", 300.00f);
            	PreparedStatement ps = DbQuery.executeUpdate("INSERT INTO Employee("
            			+ "FName, SName, Salary, Bonus) VALUES('"
            			+ empToAdd.getFirstName() + "', '" + empToAdd.getLastName() + "', "
            			+ empToAdd.getSalary() + ", " + empToAdd.getBonus() + ");");
            	ResultSet rs = DbQuery.executeQuery("SELECT idEmployee, FName, SName, Salary, Bonus FROM Employee");
            	
            	if(null == ps || null == rs) {
            		model.addRow(new Object[]{"Problem occurred. Please contact system administrator"});
            	}
            	else {
            		displayEmployeeResults(rs);
            	}
            }
          } );
		
		buttonUpdate = new JButton("Update");
		buttonUpdate.setVisible(true);
		buttonUpdate.setSize(buttonDimensions);
		buttonUpdate.setMinimumSize(buttonDimensions);
		buttonUpdate.setMaximumSize(buttonDimensions);
		buttonUpdate.setPreferredSize(buttonDimensions);
		
		buttonDelete = new JButton("Delete");
		buttonDelete.setVisible(true);
		buttonDelete.setSize(buttonDimensions);
		buttonDelete.setMinimumSize(buttonDimensions);
		buttonDelete.setMaximumSize(buttonDimensions);
		buttonDelete.setPreferredSize(buttonDimensions);
		
		employeeButton = new JRadioButton("Employee Database");
		employeeButton.setSize(buttonDimensions);
		employeeButton.setVisible(true);
		employeeButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
            	ResultSet rs = DbQuery.executeQuery("SELECT idEmployee, FName, SName, Salary, Bonus FROM Employee");
            	model.setColumnIdentifiers(new String [] {
                        "ID", "First Name", "Last Name", "Salary", "Bonus"});
            	
            	if(null == rs) {
            		model.addRow(new Object[]{"Problem occurred. Please contact system administrator"});
            	}
            	else {
            		displayEmployeeResults(rs);
            	}
            }
          } );
		
		
		sales_employeeButton = new JRadioButton("Sales Employee Database");
		sales_employeeButton.setSize(buttonDimensions);
		sales_employeeButton.setVisible(true);
		sales_employeeButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) 
            { 
            	ResultSet rs = DbQuery.executeQuery("SELECT idSalesEmployee, FName, SName, Salary, Bonus, "
            			+ "CommissionRate, SalesTotal FROM SalesEmployee "
            			+ "JOIN Employee ON idEmployee = idSalesEmployee");
            	model.setColumnIdentifiers(new String [] {
                        "ID", "First Name", "Last Name", "Salary", "Bonus", "Commission Rate", "Sales Total"});
            	if(null == rs) {
            		model.addRow(new Object[]{"Problem occurred. Please contact system administrator"});
            	}
            	else {
            		displaySalesEmployeeResults(rs);
            	}
            }
          } );
		
		ButtonGroup group = new ButtonGroup();
		group.add(employeeButton);
		group.add(sales_employeeButton);
		
		panelTop.add(table);
		panelBottom.add(buttonCreate);
		panelBottom.add(buttonUpdate);
		panelBottom.add(buttonDelete);
		panelBottom.add(employeeButton);
		panelBottom.add(sales_employeeButton);
	
		Employee.getContentPane().validate();
        Employee.getContentPane().repaint();
	}
	
	private static void clearTable() {
		// remove rows starting from last to clear table
		for(int i = model.getRowCount() - 1; i >=0; i--) {
			model.removeRow(i); 
		}
	}
	
	public static void displayEmployeeResults(ResultSet rs) {
		clearTable();
		model.addRow(new Object[]{"ID", "Forename", "Surname", "Salary", "Bonus"});
		model.addRow(new Object[]{"", "", "", "", ""});
		
		try {
			while(rs.next()) {
				model.addRow(new Object[]{rs.getString("idEmployee"), rs.getString("FName"),
						rs.getString("SName"), rs.getString("Salary"), rs.getString("Bonus")});
			}
		} catch(SQLException e) {
			model.addRow(new Object[]{"Problem occurred. Please contact system administrator"});
		}
	}
	
	public static void displaySalesEmployeeResults(ResultSet rs) {
		clearTable();
		model.addRow(new Object[]{"ID", "Forename", "Surname", "Salary", "Bonus", "CommissionRate", "SalesTotal"});
		model.addRow(new Object[]{"", "", "", "", "", "", ""});
		
		try {
			while(rs.next()) {
				model.addRow(new Object[]{rs.getString("idSalesEmployee"), rs.getString("FName"),
						rs.getString("SName"), rs.getString("Salary"), rs.getString("Bonus"),
						rs.getString("CommissionRate"), rs.getString("SalesTotal")});
			}
		} catch(SQLException e) {
			model.addRow(new Object[]{"Problem occurred. Please contact system administrator"});
		}
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
	




