import java.awt.*;

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
		
			
		JFrame Employee = new JFrame("Employee System");
		FlowLayout layout = new FlowLayout();
		
		JPanel panelLeft = new JPanel();
		JPanel panelRight = new JPanel();
		
		panelLeft.setSize(800,300);
		panelRight.setSize(800,300);
		
		panelRight.setLayout(new GridLayout(3,1));
		
		
		Employee.setSize(800,600);
		Employee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Employee.setLayout(layout);
		
		Employee.add(panelLeft);
		Employee.add(panelRight);
		

		Employee.setVisible(true);
		
		Dimension d = new Dimension(100,40);
		
		Dimension c = new Dimension(380,280);
		
		area = new JScrollPane();
		area.setSize(500, 500);
		area.setVisible(true);
		area.setSize(c);
		area.setMinimumSize(c);
		area.setMaximumSize(c);
		area.setPreferredSize(c);
		
		buttonA = new JButton("Create");
		buttonA.setSize(30,60);
		buttonA.setVisible(true);
		buttonA.setSize(d);
		buttonA.setMinimumSize(d);
		buttonA.setMaximumSize(d);
		buttonA.setPreferredSize(d);
		
		
		buttonB = new JButton("Update");
		buttonB.setSize(30, 60);
		buttonB.setVisible(true);
		buttonB.setSize(d);
		buttonB.setMinimumSize(d);
		buttonB.setMaximumSize(d);
		buttonB.setPreferredSize(d);
		
		
		buttonC = new JButton("Delete");
		buttonC.setSize(30, 60);
		buttonC.setVisible(true);
		buttonC.setSize(d);
		buttonC.setMinimumSize(d);
		buttonC.setMaximumSize(d);
		buttonC.setPreferredSize(d);
		
		
		panelLeft.add(area);
		panelRight.add(buttonA);
		panelRight.add(buttonB);
		panelRight.add(buttonC);
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
	




