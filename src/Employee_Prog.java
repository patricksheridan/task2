import java.awt.*;

import javax.swing.*;

public class Employee_Prog {

	
		
		
		

	public static void main(String[] args)
	{

		String username = "Kainos";
		String password = "Password";
		
		String user = JOptionPane.showInputDialog("What is your username");
		String pass = JOptionPane.showInputDialog("What is your password?");
		{
		if (user.equals(username) && pass.equals(password))
		{
			JOptionPane.showMessageDialog(null, "Login successful");
			
		}
		
		
		else {
			JOptionPane.showMessageDialog(null, "Login unsuccessful");
			
			
		}
	}

	JButton buttonA, buttonB, buttonC;
	JTextArea area;
	
		
	JFrame Employee = new JFrame("Employee System");
	FlowLayout layout = new FlowLayout();
	Employee.setSize(800,600);
	Employee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Employee.setLayout(layout);
	Employee.setVisible(true);
	
	
	area = new JTextArea("Information");
	area.setSize(500, 500);
	area.setVisible(true);
	
	buttonA = new JButton("Create");
	buttonA.setSize(30,60);
	buttonA.setVisible(true);
	
	buttonB = new JButton("Update");
	buttonB.setSize(30, 60);
	buttonB.setVisible(true);
	
	buttonC = new JButton("Delete");
	buttonC.setSize(30, 60);
	buttonC.setVisible(true);
	
	Employee.add(area);
	Employee.add(buttonA);
	Employee.add(buttonB);
	Employee.add(buttonC);
	
	}
}



