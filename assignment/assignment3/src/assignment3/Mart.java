package assignment3;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Mart extends InventoryManager{
	private ArrayList<Product> salesList;
	public static int transactionNum= 1000;

	
	private Mart() {
		salesList = new ArrayList<Product>();
	}
	private volatile static Mart uniqueInstance;
	
	public static Mart getInstance() {
		if(uniqueInstance == null) {
			synchronized(Mart.class) {
				if(uniqueInstance == null)
					uniqueInstance = new Mart();
			}
		}
		return uniqueInstance;
	}
	
	public void setSaleList(Product product) {
		salesList.add(product);
	}
	
	public void printSaleList() {
		for(Product product : salesList) {
			System.out.println(salesList.indexOf(product) + 1 + ". " + product.toString());
		}
	}
	
	public int printExpired(LocalDateTime present) {
		int count = 0;
		for(Product product : salesList) {
			if(product instanceof Food) {
				if(((Food) product).isExpired(present)) {
					count += 1;
					System.out.println(salesList.indexOf(product) + 1 + ". " + product.toString());
				}
			}
		}
		return count;
	}
	
	public void setExpiration(int elongated, LocalDateTime present) {
		for(Product product : salesList) {
			if(product instanceof Food) {
				if(((Food) product).isExpired(present))
					((Food) product).setExpiration(elongated);;
			}
		}
	}
	
	public void waitings(Customer customer, int quantity, Product product) {
		System.out.println("We are currently out of stock, so we'll put you on a waiting list.");
		addObserver(customer, quantity, product);
	}
	
	public int getIndex(Product product) {
		return salesList.indexOf(product);
	}
	
	public void buying(int product, int quantity, LocalDateTime present, Customer customer, int recheck ) throws ExpiredException {
		
		if(salesList.get(product -1) instanceof Food) {
			if(((Food) salesList.get(product-1)).isExpired(present)) {
				throw new ExpiredException();
			}
		}
		if(salesList.get(product-1).getQuantity() - quantity < 0 ) {
			if(recheck != 1) {
				waitings(customer, quantity, salesList.get(product -1));
			}
		}
		else {
			salesList.get(product -1).setQuantity(-1 * quantity);
			customer.addShoppingCart(new Product(salesList.get(product -1), quantity));
			super.deleteObserver(customer, salesList.get(product-1));
		}
	}
	
	public void setNumber(int product, int quantity) {
		salesList.get(product -1).setQuantity(quantity);
		if(quantity > 0 ) {
			notifyObservers();
		}
	}
	public int getSalesSize() {
		return salesList.size();
	}
	public int getSalesIndex(Product product) {
		for (Product prod : salesList) {
			if(prod.equals(product)) {
				return salesList.indexOf(prod);
			}
		}
		return -1;
	}
}
