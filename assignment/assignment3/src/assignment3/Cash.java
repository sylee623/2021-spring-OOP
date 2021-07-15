package assignment3;

public class Cash implements Payable{
	private String currency;
	private int amount;
	
	public Cash(String currency, int amount) {
		this.currency = currency;
		this.amount = amount;
	}
	
	public String toString() {
		return this.currency + ", " + this.amount + " won";
	}
	
	public void pay(int amount) throws NotEnoughBalanceException{
		if(this.amount < amount) {
			throw new NotEnoughBalanceException(amount - this.amount);
		}
		this.amount -= amount;
	}
}
