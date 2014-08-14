//package employee_stuff;
//
//public class CorporateSalesEmployee extends SalesEmployee {
//
//	private int keyAccounts;
//	private float keyAccountWorth;
//	private static final float DEFAULT_ACCOUNT_WORTH = 80f;
//
//	public CorporateSalesEmployee(int newNumber, float newSalary,
//			String newName, float newCommissionRate, int keyAccounts) {
//		super(newNumber, newSalary, newName, newCommissionRate);
//		this.setKeyAccounts(keyAccounts);
//		this.setKeyAccountWorth(DEFAULT_ACCOUNT_WORTH);
//	}
//	
//	@Override
//	public float calcPay() {
//		return super.calcPay() + calcKeyAccountIncome();
//	}
//	
//	private float calcKeyAccountIncome() {
//		return this.keyAccounts * this.keyAccountWorth;
//	}
//
//	public int getKeyAccounts() {
//		return keyAccounts;
//	}
//
//	public void setKeyAccounts(int keyAccounts) {
//		this.keyAccounts = keyAccounts;
//	}
//
//	public float getKeyAccountWorth() {
//		return keyAccountWorth;
//	}
//
//	public void setKeyAccountWorth(float keyAccountWorth) {
//		this.keyAccountWorth = keyAccountWorth;
//	}
//
//}
