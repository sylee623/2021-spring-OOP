package assignment2;

public class InvalidAccessException extends Exception {
	
	public InvalidAccessException() {
		super("default_message");
	}
	
	public InvalidAccessException(int num, int bound1, int bound2) {
		super(num + " is out of " + bound1 + " to "+ bound2);
	}
	
	public InvalidAccessException(int num, int time) {
		super("There is schedule in day : " + num + " time : "+ time);
	}
	public InvalidAccessException(String message) {
		super(message);
	}
}
