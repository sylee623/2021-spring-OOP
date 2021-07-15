package assignment3;

import java.util.ArrayList;

public abstract class InventoryManager {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private ArrayList<Integer> quantities = new ArrayList<Integer>();
	private ArrayList<Product> products = new ArrayList<Product>();
	
	public void addObserver(Observer observer, int quantity, Product product) {
		observers.add(observer);
		quantities.add(quantity);
		products.add(product);
	};
	public void deleteObserver(Observer observer, Product product) {
		int index = -1;
		for(int i=0; i < observers.size(); i++) {
			if(observer.equals(observers.get(i))) {
				if(product.equals(products.get(i))) {
					index = i;
					break;
				}
			}
		}
		if(index >= 0) { // &&  product.equals(products.get(observers.indexOf(observer)))
			System.out.println("The product that " + ((Customer) observer).getName() + " have been waiting for has been processed");
			quantities.remove(index);
			products.remove(index);
			observers.remove(index);
		}
	}
	public void notifyObservers() {
		for(int i= 0; i < observers.size(); i++) {
			observers.get(i).update(this, quantities.get(i), ((Mart) this).getIndex(products.get(i)));
			}
	}
}
