package assignment3;

public class Manufactured extends Product{
	public String brand; //제조사 
	
	public Manufactured(String name, int price, int quantity, String brand) {
		super(name, price, quantity);
		this.brand = brand;
	}
	
	public String toString() {
		return super.toString() + ", Brand : " + brand;
	}
}
