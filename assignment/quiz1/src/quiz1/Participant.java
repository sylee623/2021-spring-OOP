package quiz1;


public class Participant {
	private String name;
	private Card card;
	private int point;
	
	public Participant(String name) {
		this.name = name;
		
		int symbol = (int) (Math.random() * 3);
		int number = (int) (Math.random() * 12) + 1;
		this.card = new Card(symbol, number);
		this.point = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Card getCard() {
		return this.card;
	}
	
	public int getPoint() {
		return this.point;
	}

	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setCard(Card newCard) {
		this.card = new Card(newCard);
	}
	
	public void setPoint(int newPoint) {
		this.point = newPoint;
	}
	
	public void addPoint(int point) {
		this.point = this.point + point;
	}
	
	public void changeCard() {
		int symbol = (int) (Math.random() * 3);
		int number = (int) (Math.random() * 12) + 1;
		this.card.setSymbol(symbol);
		this.card.setNumber(number);
	}
	
	public String toString() {
		return this.name + " has " + this.card.toString() + "(point : " + this.point + ")"; 
	}
	
}
