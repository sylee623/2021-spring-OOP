package assignment3;

public class InvalidAccessException extends Exception{
	public InvalidAccessException() {
		super("Wrong value");
	}
	
	public InvalidAccessException(int num, int bound1, int bound2) {
		super(num + " is out of " + bound1 + " to "+ bound2 + ". Please enter a number " + bound1 + " ~ " + bound2);
	}
	
	public InvalidAccessException(String message) {
		super(message);
	}
	
}
