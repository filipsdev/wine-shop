public class Customer {
	private String custmerName;
	private int customerBalanceInPence;

	public Customer(String custmerName, int customerBalanceInPence) {
		this.custmerName = custmerName;
		this.customerBalanceInPence = customerBalanceInPence;
	}

	public String getCustomerName() {
		return custmerName;
	}

	public int getCustomerBalance() {
		return this.customerBalanceInPence;
	}

	public void setCustomerBalance(int customerBalanceInPence) {
		this.customerBalanceInPence = customerBalanceInPence;
	}

	public void balanceUpdate(int winePriceInPence, int wineQuantity) {// one method no mater if buying or returning
		if (wineQuantity > 0) {
			int calc = this.customerBalanceInPence + winePriceInPence * wineQuantity;
			setCustomerBalance(calc);
		} else {
			int calc = (int) (this.customerBalanceInPence + winePriceInPence * wineQuantity * 0.8);
			setCustomerBalance(calc);
		}
	}

	public String toString() {
		return String.format("%s. Your Balance is £%.2f", this.getCustomerName(), this.getCustomerBalance() * 0.01);
	}
}