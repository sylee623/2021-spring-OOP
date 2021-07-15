package assignment3;

import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer implements Observer{
	private String name;// 이름
	private ArrayList<Payable> wallet;// 소지한Payable목록
	private ArrayList<Product> shoppingCart;// 구매할Product 목록

	public Customer(String name) {
		this.name = name;
		this.wallet = new ArrayList<Payable>(1);
		this.shoppingCart = new ArrayList<Product>(1);
		
	}
	
	public boolean equals(Customer customer) {
		if(customer.getName() == this.name && wallet.equals(customer.wallet)) {
			return true;
		}
		else return false;
	}
	
	public void addWallet(Payable wallet) {
		this.wallet.add(wallet);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getWalletSize() {
		return this.wallet.size();
	}
	
	public ArrayList<Payable> getWallet() {
		ArrayList<Payable> tmp = new ArrayList<Payable>(1);
		for(int t = 0; t < this.wallet.size(); t ++) {
			tmp.add(this.wallet.get(t));
		}
		return tmp;
	}
	
	public void addShoppingCart(Product product) {
		shoppingCart.add(product);
	}
	
	
	
	public void printShoppingCart() {
		int total =0;
		System.out.printf("%-16s %16s %16s %16s\n","Product Name", "Unit Price", "Quantity", "Amount");
		System.out.println("-".repeat(70));
		for(Product product:shoppingCart) {
			total += product.getQuantity() * product.getPrice();
			System.out.printf("%-16s %16s %16s %16s\n",product.getName(), product.getPrice(), product.getQuantity(),product.getQuantity() * product.getPrice());
		}
		System.out.println("-".repeat(70));
		System.out.printf("%-16s %-16s %-16s %16s\n","Total Price", " ", " ", total);
		System.out.println("-".repeat(70));
		
	}
	
	public void paying(PrintWriter receipt, int pay, Scanner keyboard, Mart mart) {
		keyboard = new Scanner(System.in);
		while(true) {
			try {
				int total = 0;
				
				for(Product product:shoppingCart) {
					total += product.getQuantity() * product.getPrice();
				}
				
				this.wallet.get(pay-1).pay(total);
				receipt.println(MartSimulator.present.toString());
				receipt.printf("%-16s %16s %16s %16s\n","Product Name", "Unit Price", "Quantity", "Amount");
				receipt.println("-".repeat(70));
				
				for(Product product:shoppingCart) {
					receipt.printf("%-16s %16s %16s %16s\n",product.getName(), product.getPrice(), product.getQuantity(),product.getQuantity() * product.getPrice());
				}
				
				receipt.println("-".repeat(70));
				receipt.printf("%-16s %-16s %-16s %16s\n","Total Price", " ", " ", total);
				receipt.println("-".repeat(70));
					
				this.shoppingCart = new ArrayList<Product>(1);
					
				if(this.wallet.get(pay-1) instanceof Credit) {
					receipt.println("Credit, "+ ((Credit) wallet.get(pay-1)).getBank());
				}
				else {
					receipt.println("Cash, ");
				}
				return;
			}
			catch(NotEnoughBalanceException e) {
				System.out.println(e.getMessage());
				int reselect = -1;
				System.out.print("Please enter another pay method (if you don't have, just enter 0) : ");
				try {
					reselect = keyboard.nextInt();
					if(reselect == 0) {
						for(Product product : shoppingCart) {
							mart.setNumber(mart.getSalesIndex(product) + 1, product.getQuantity());
						}
						this.shoppingCart = new ArrayList<Product>(1);
						return;
					}
					else if(reselect < 0 || reselect > wallet.size() ) {
						throw new InvalidAccessException(reselect, 0, wallet.size());
					}
					else {
						this.paying(receipt, reselect, keyboard, mart);
					}
				}
				catch(InputMismatchException k) {
					keyboard = new Scanner(System.in);
					System.out.println("Please enter integer value");
					continue;
				}
				catch(Exception k) {
					System.out.println(k.getMessage());
					continue;
				}
			}
		}
		
		
		
		
	}
	
	@Override
	public void update(InventoryManager manager, int quantity, int product) {
		// TODO Auto-generated method stub
		try {
			((Mart) manager).buying(product+1, quantity, MartSimulator.present, this, 1);
		} catch (ExpiredException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
	}

}
