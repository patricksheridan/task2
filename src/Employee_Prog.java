import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Employee_Prog {

	
		
		
		

	public static void main(String[] args)
	{
		promptPassword();
		
	}

	
	
	
	
	public static void MainScreen()
	{
		JButton buttonA, buttonB, buttonC;
		JScrollPane area;
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
		
		area = new JScrollPane();
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
		
		sales_employeeButton = new JRadioButton("Sales Employee Database");
		sales_employeeButton.setSize(d);
		sales_employeeButton.setVisible(true);
		
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
	




