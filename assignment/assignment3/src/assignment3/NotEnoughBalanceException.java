package assignment3;

public class NotEnoughBalanceException extends Exception{
	public NotEnoughBalanceException() {
		super("not enough");
	}
	
	public NotEnoughBalanceException(int money) {
		super(money + "won is not enough");
	}
}
