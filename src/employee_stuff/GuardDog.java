package employee_stuff;

public class GuardDog implements IPayable {
	private String name;
	private float monthlyPay;
	private int monthsWorked;
	private static final float DOG_MONTHLY_PAY = 100f;

	public GuardDog(String newName, int newMonthsWorked) {
		this.name = newName;
		this.monthsWorked = newMonthsWorked;
		this.monthlyPay = DOG_MONTHLY_PAY;
	}

	@Override
	public float calcPay() {
		return this.monthlyPay * this.monthsWorked;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public int getMonthsWorked() {
		return monthsWorked;
	}

	public void setMonthsWorked(int monthsWorked) {
		this.monthsWorked = monthsWorked;
	}

}
