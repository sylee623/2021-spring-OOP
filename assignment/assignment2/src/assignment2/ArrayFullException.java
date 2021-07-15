package assignment2;

public class ArrayFullException extends Exception{
	
	public ArrayFullException() {
		super("default message");
	}
	public ArrayFullException(String msg) {
		super(msg);
	}
}
