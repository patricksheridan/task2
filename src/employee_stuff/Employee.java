package employee_stuff;

public class Employee implements IPayable {
	private int number;
	private float salary;
	private String name;
	public float bonus;
	private static final float DEFAULT_BONUS = 200f;
	private static final float MIN_SALARY = 7000f;

	public Employee() {
		this.bonus = DEFAULT_BONUS;
	}

	public Employee(String newName) {
		this();
		this.name = newName;
	}

	public Employee(String newName, float newSalary) {
		this(newName);
		this.setSalary(newSalary);
	}


	public float calcPay() {
		return getSalary() / 12;
	}

	public String toString() {
		return String.format("Employee %d: %s, £%.2f, £%.2f per month.",
				this.number, this.getName(), this.getSalary(), this.calcPay());
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

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

}
