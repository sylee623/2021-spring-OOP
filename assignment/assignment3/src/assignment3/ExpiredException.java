package assignment3;

public class ExpiredException extends Exception{
	public ExpiredException(){
		super("Expiration date is over, pick other product");
	}
}
