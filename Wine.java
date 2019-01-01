public class Wine {
	private String wineName;
	private int wineQuantity;
	private int winePriceInPence;
	private int WineGetCustomerBalance;

	public Wine(String wineName, int wineQuantity, int winePriceInPence) {
		this.wineName = wineName;
		this.winePriceInPence = winePriceInPence;
		this.wineQuantity = wineQuantity;
	}

	public String getWineName() {
		return wineName;
	}

	public void setWinePrinceInPence(double winePrice) {
		this.winePriceInPence = (int) (winePrice * 100);
	}

	public void setWineQuantity(int wineQuantity) {
		this.wineQuantity = wineQuantity;
	}

	public int getWineQuantity() {
		return this.wineQuantity;
	}

	public int getWinePriceInPence() {
		return this.winePriceInPence;
	}

	public void WineGetCustomerBalance(int customerBalanceInPence) {// method to get the customer balance to use in
																	// toString method
		this.WineGetCustomerBalance = customerBalanceInPence;
	}

	public void quantityException(int quantityInput) throws Exception {
		if (quantityInput == 0) {
			throw new Exception();

		}
	}

	public void priceException(double priceInput) throws Exception {
		if (priceInput <= 0) {
			throw new Exception();
		}
	}

	public String toString() {
		return String.format("%s(£%.2f), %d units, total cost = £%.2f, new balance £%.2f", this.wineName,
				this.winePriceInPence * 0.01, this.wineQuantity, this.wineQuantity * this.winePriceInPence * 0.01,
				this.WineGetCustomerBalance * 0.01);
	}
}