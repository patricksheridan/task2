package employee_stuff;

public class SalesEmployee extends Employee{

	private float commissionRate;
	private float salesTotal;

	public SalesEmployee() {
		super();
	}

	public float getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(float commissionRate) {
		this.commissionRate = commissionRate;
	}

	public float getSalesTotal() {
		return salesTotal;
	}

	public void setSalesTotal(float salesTotal) {
		this.salesTotal = salesTotal;
	}

	@Override
	public float calcPay() {
		return super.calcPay() + calcCommission();
	}
	
	private float calcCommission() {
		return this.commissionRate * this.salesTotal;
	}

}
