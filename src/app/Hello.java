package app;

import employee_stuff.BadNumber;
import employee_stuff.Consultant;
import employee_stuff.CorporateSalesEmployee;
import employee_stuff.Employee;
import employee_stuff.GuardDog;
import employee_stuff.PayrollSystem;
import employee_stuff.SalesEmployee;

public class Hello {

	public static void main(String[] args) {
		try {
			Class eClass = Class.forName("employee_stuff.Employee");

			Employee emp1 = (Employee) eClass.newInstance();
			emp1.setNumber("10");
			emp1.setSalary(15000.00f);
			emp1.setName("Mr. Smith");

			SalesEmployee emp2 = new SalesEmployee(11, 18000f, "Dr. Jekyll",
					0.18f);

			CorporateSalesEmployee emp3 = new CorporateSalesEmployee(12,
					20000f, "Mr. Hyde", 0.20f, 3);
			emp3.setKeyAccountWorth(95f);

			System.out.println(emp1);
			System.out.println(emp2);
			System.out.println(emp3);

			PayrollSystem ps = new PayrollSystem();
			float emp1_pay = ps.netPay(emp1);
			float emp2_pay = ps.netPay(emp2);
			float emp3_pay = ps.netPay(emp3);

			Consultant emp4 = new Consultant("Mr Wonka", 100f, 20);
			float emp4_pay = ps.netPay(emp4);
			System.out
					.printf("%s's net pay: £%.2f\n", emp4.getName(), emp4_pay);

			GuardDog dog1 = new GuardDog("Cerberus", 6);
			float dog1_pay = ps.netPay(dog1);
			System.out.printf("%s the dog's net pay: £%.2f\n", dog1.getName(),
					dog1_pay);

		} catch (ClassNotFoundException e1) {
			System.err.println("Class not found: " + e1.getMessage());
		} catch (IllegalAccessException e2) {
			System.err.println("Illegal access to class: " + e2.getMessage());
		} catch (InstantiationException e3) {
			System.err.println("Could not instantiate: " + e3.getMessage());
		} catch (BadNumber e4) {
			System.err.println("Bad number: " + e4.getMessage());
		}
	}

}
