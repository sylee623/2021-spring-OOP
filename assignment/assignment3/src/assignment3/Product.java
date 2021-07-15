package assignment3;

public class Product {
	private String name;// 제품명
	private int price;// 제품의가격
	private int quantity;// 제품의수량
	
	public Product(String name, int price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Product(Product obj, int quantity) {
		this.name = obj.getName();
		this.price = obj.getPrice();
		this.quantity = quantity;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	
	
	public String toString() {
		return "(Quantity: " + quantity + "), " + name + ", " + price + " won";
	}
	
	public boolean equals(Product product) {
		if(this.name == product.getName() && this.price == product.getPrice()) {
			return true;
		}
		else return false;
	}
	
	public void setQuantity(int quantity) {
		this.quantity += quantity;
	}
}
