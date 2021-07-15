package assignment3;

public class Credit implements Payable{
	private String bank;// 은행
	private int limit;// 사용한도
	private int amountUsed;// 현재누적사용금액
	
	public Credit(String bank, int limit, int amountUsed) {
		this.bank = bank;
		this.limit = limit;
		this.amountUsed = amountUsed;
	}
	
	public String toString() {
		return this.bank + ", Amount used : " + this.amountUsed + "won" + "(Limit : " + this.limit + ")";
	}
	
	public String getBank() {
		return this.bank;
	}
	
	public boolean payCheck(int amount) {
		return amount < (this.limit - this.amountUsed);
	}
	
	public void pay(int price) throws NotEnoughBalanceException{
		if(this.limit - this.amountUsed < price) {
			throw new NotEnoughBalanceException(price - (this.limit- this.amountUsed));
		}
		this.amountUsed += price;
	}
}
