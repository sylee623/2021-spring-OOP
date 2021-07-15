package assignment3;

import java.time.LocalDateTime;

public class Food extends Product{
	private LocalDateTime expirationDateTime; //유통기한
	
	public Food(String name, int price, int quantity, LocalDateTime time) {
		super(name, price, quantity);
		this.expirationDateTime = time;
	}
	
	public boolean isExpired(LocalDateTime present) {
		if(expirationDateTime.isBefore(present)) {
			return true;
		}
		else
			return false;
	}
	
	public String toString() {
		return super.toString() + ", Best before : " + expirationDateTime.toString();
	}
	
	public void setExpiration(int elongated) {
		this.expirationDateTime = this.expirationDateTime.plusDays(elongated);
	}
}
