package employee;

import employee_stuff.BadNumber;
import employee_stuff.IPayable;

public class Employee {
	private int number;
	private float salary;
	private String firstName;
	private String lastName;
	public float bonus;
	private static final float DEFAULT_BONUS = 200f;
	private static final float MIN_SALARY = 7000f;

	public Employee() {
		this.bonus = DEFAULT_BONUS;
	}

	public Employee(String newFirstName, String newLastName) {
		this();
		this.firstName = newFirstName;
		this.lastName = newLastName;
	}

	public Employee(String newFirstName, String newLastName, float newSalary) {
		this(newFirstName, newLastName);
		this.setSalary(newSalary);
	}


	public float calcPay() {
		return getSalary() / 12;
	}

	public String toString() {
		return String.format("Employee %d: %s %s, £%.2f, £%.2f per month.",
				this.number, this.getFirstName(), this.getLastName(), this.getSalary(), this.calcPay());
	}

	public int getNumber() {
		return this.number;
	}

	public boolean setNumber(int newNumber) {
		if (newNumber > 0) {
			this.number = newNumber;
			return true;
		} else {
			return false;
		}
	}

	public boolean setNumber(String newNumber) throws BadNumber {
		try {
			int i = Integer.parseInt(newNumber);
			return setNumber(i);
		} catch(NumberFormatException e) {
			throw new BadNumber(e);
		}
	}

	public float getSalary() {
		return salary;
	}

	public boolean setSalary(float newSalary) {
		if (newSalary >= MIN_SALARY) {
			this.salary = newSalary;
			return true;
		} else {
			return false;
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}
	
	public float getBonus() {
		return bonus;
	}

	public void setBonus(float newBonus) {
		this.bonus = newBonus;
	}

}
