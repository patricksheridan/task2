package employee_stuff;

public class Consultant implements IPayable {
	private String name;
	private float dailyRate;
	private int daysWorked;

	public Consultant(String newName, float newDailyRate, int newDaysWorked) {
		this.setName(newName);
		this.setDailyRate(newDailyRate);
		this.setDaysWorked(newDaysWorked);
	}

	@Override
	public float calcPay() {
		return this.getDailyRate() * this.getDaysWorked();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getDailyRate() {
		return dailyRate;
	}

	public void setDailyRate(float dailyRate) {
		this.dailyRate = dailyRate;
	}

	public int getDaysWorked() {
		return daysWorked;
	}

	public void setDaysWorked(int daysWorked) {
		this.daysWorked = daysWorked;
	}
}
