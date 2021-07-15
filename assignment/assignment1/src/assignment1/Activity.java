package assignment1;

public class Activity {
	private String name; // Activity 이
	private String location; // Activity 장소
	private int price; // Activity 시간당 가격
	
	public Activity(Activity obj) {
		this.name = obj.name;
		this.location = obj.location;
		this.price = obj.price;
	}
	
	public Activity(String name, String location, int price) {
		this.name = name;
		this.location = location;
		this.price = price;
	}
	
	public boolean equals(Activity obj) {
		if(this.name == obj.name  && this.location == obj.location && this.price == obj.price) {
			return true;
		}
		else {return false;}
	}
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
	public String toString() { 
		return(this.name + "(" + this.location + ", " + this.price + " won)");
	}
}
