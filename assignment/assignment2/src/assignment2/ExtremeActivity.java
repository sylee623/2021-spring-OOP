package assignment2;

public class ExtremeActivity extends Activity{
	private int minHeight;
	private int minWeight;
	
	public ExtremeActivity(ExtremeActivity obj) {
		super(obj);
		this.minHeight = obj.minHeight;
		this.minWeight = obj.minWeight;
	}
	public ExtremeActivity(String name, String location, int price, int minHeight, int minWeight) {
		super(name, location, price);
		this.minHeight = minHeight;
		this.minWeight = minWeight;
	}
	
	public int getMinHeight() {
		return this.minHeight;
	}
	
	public int getMinWeight() {
		return this.minWeight;
	}
	
	public int getActualPrice(Person person) {
		if(person.getAge() > 59) {
			return (int) (super.getPrice() * 0.7);
		}
		else {
			return super.getPrice();
		}
	}
	
}
