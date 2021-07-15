package assignment2;

public class ShowActivity extends Activity{
	private int minAge;
	
	public ShowActivity(ShowActivity obj) {
		super(obj);
		this.minAge = obj.minAge;
	}
	
	public ShowActivity(String name, String location, int price, int minAge) {
		super(name, location, price);
		this.minAge = minAge;
	}
	
	public int getMinAge() {
		return this.minAge;
	}
	public int getActualPrice(Person person) {
		if(person.getAge() < 20) {
			return (int) (super.getPrice() * 0.8);
		}
		else {
			return super.getPrice();
		}
	}
}
