package assignment3;

import java.util.Scanner;

import java.time.LocalDateTime;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;


public class MartSimulator {
	public static LocalDateTime present = LocalDateTime.of(2021, 5, 27, 15, 00);
	
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Mart mart = Mart.getInstance();
		
		Scanner input = null;

		
		try {
			input = new Scanner(new FileInputStream("./src/assignment3/Mart.txt"));
		}
		catch (FileNotFoundException e){
			System.out.println("Product information is not found. Program will be terminated.");
			System.exit(0);
		}
		int n_product = input.nextInt();
		for(int i = 0; i < n_product; i++) {
			String[] productInfo = input.nextLine().split(",");
			if(productInfo[0].equals("Food")) {
				LocalDateTime tmpTime = LocalDateTime.of(Integer.parseInt(productInfo[3]), Integer.parseInt(productInfo[4]), Integer.parseInt(productInfo[5]), Integer.parseInt(productInfo[6]), Integer.parseInt(productInfo[7]));
				mart.setSaleList(new Food(productInfo[1], Integer.parseInt(productInfo[2]), Integer.parseInt(productInfo[8]), tmpTime));
			}
			else if (productInfo[0].equals("Manufactured")) {
				mart.setSaleList(new Manufactured(productInfo[1],Integer.parseInt(productInfo[2]), Integer.parseInt(productInfo[4]),productInfo[3]));
			}
		}
		
		try {
			input = new Scanner(new FileInputStream("./src/assignment3/CustomerWallets.txt"));
		}
		catch (FileNotFoundException e){
			System.out.println("Customer wallet information is not found. Program will be terminated.");
			System.exit(0);
		}
		
		int n_customer = input.nextInt();
		input.nextLine();
		for(int i = 0; i < n_customer; i++) {
			String[] customerInfo = input.nextLine().split(",");
			customerList.add(new Customer(customerInfo[0]));
			int n_wallets = Integer.parseInt(customerInfo[1]);
			for(int l = 0; l < n_wallets; l ++) {
				String [] payableInfo = input.nextLine().split(",");
				if(payableInfo[0].equals("Credit")) {
					customerList.get(i).addWallet(new Credit(payableInfo[1], Integer.parseInt(payableInfo[2]), Integer.parseInt(payableInfo[3]) ));
				}
				else if(payableInfo[0].equals("Cash")) {
					customerList.get(i).addWallet(new Cash(payableInfo[1],Integer.parseInt(payableInfo[2])));
				}
			}

		}
		
		
		
		/*###########
		 * 프로그램 시작 지점 
		 ############*/
		
		while(true) {
			int s1 = 0;
			
			//##### Market siumlation #######
			System.out.println();
			System.out.println("1)Manager Mode");
			System.out.println("2)Customer Mode");
			System.out.println("3)End Program");
			System.out.print("Select menu : ");
			try {
				s1 = keyboard.nextInt();
				if(s1 < 1 || s1 > 3) {
					throw new InvalidAccessException(s1, 1, 3);
				}
			}
			catch(InputMismatchException e) {
				keyboard = new Scanner(System.in);
				System.out.println("Please enter integer value");
				continue;
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				continue;
			}
			
			
			if(s1==1) {
				keyboard = new Scanner(System.in);
				ManagerMode(keyboard, mart);
			}
			
			else if(s1==2) {
				int selectedCustomer = -1;
				int checked = 0;
				for(int c_idx = 0; c_idx < customerList.size(); c_idx ++) {
					System.out.println((c_idx + 1 ) + ") " + customerList.get(c_idx).getName());
				}
				System.out.print("Select Customer : ");
				try {
					selectedCustomer = keyboard.nextInt();
					if(selectedCustomer == 0) continue;
					else if (selectedCustomer < 0 || selectedCustomer > 3) {
						throw new InvalidAccessException(selectedCustomer, 0,3);
					}
					
				}
				catch(InputMismatchException e) {
					keyboard = new Scanner(System.in);
					if(checked != 1) {
						System.out.println("Please enter integer value");
					}
					continue;
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
				if(selectedCustomer != -1) {
					try {
						customerMode(keyboard, customerList.get(selectedCustomer-1), mart);
					}
					catch(InputMismatchException e) {
						keyboard = new Scanner(System.in);
					}
					checked = 1;
				}
				else if (selectedCustomer == 0) {
					continue;
				}
			}
			
			else if(s1==3) {
				System.out.println("Have a nice day! Bye :)");
				System.exit(0);
			}
		}
	}
	
	
	public static void ManagerMode(Scanner keyboard, Mart mart) {
		int s2 = 0;
		while(true) {
			System.out.println();
			System.out.println("1)Add Inventory");
			System.out.println("2)Replace expired");
			System.out.print("Select menu : ");
			try {
				s2 = keyboard.nextInt();
				if(s2 < 0 || s2 > 3) {
					throw new InvalidAccessException(s2, 0, 3);
				}
			}
			catch(InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.println("Please enter integer value");
				continue;
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				continue;
			}
			if(s2 == 0) {
				return;
			}
			
			else if(s2 == 1) { // 1) Add inventory, 제품의 수량추가 
				addInventory(keyboard, mart);
			}
			
			else if(s2 == 2) { // 2) Replace expired, 유통기한이 지난 상품 교체 
				replaceExpired(keyboard, mart);
			}
		}
		
	}
	
	public static void addInventory(Scanner keyboard, Mart mart) {
		int product, quantity;
		mart.printSaleList();
		while(true) {
			try {
				System.out.print("Select Product (0 : go back to previous step) : ");
				product = keyboard.nextInt();
				if(product > 9 || product <0 ) {
					throw new InvalidAccessException(product, 0, 9);
				}
				if(product == 0 ) {
					return;
				}
				System.out.print("Enter quantity : ");
				quantity = keyboard.nextInt();
				if(quantity < 0 ) {
					throw new InvalidAccessException("Please enter positive value");
				}
				mart.setNumber(product, quantity);
				return;
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}	
	}
	
	public static void replaceExpired(Scanner keyboard, Mart mart) {
		int expandedDate= 0;
		int prodNum = mart.printExpired(present);
		if(prodNum == 0) {
			System.out.println("There are no products that over expiration date.");
		}
		else {
			while(true) {
				try {
					System.out.print("Enter Extend expiration date. (please enter in days) : ");
					expandedDate = keyboard.nextInt();
					mart.setExpiration(expandedDate, present);
					return;
				}catch(InputMismatchException e){

					keyboard = new Scanner(System.in);
					System.out.println("Please enter a integer value");
					continue;
				}
			}
		}
	}
	
	public static void customerMode(Scanner keyboard, Customer customer, Mart mart) {
		int s2 = 0;
		while(true) {
			System.out.println();
			System.out.println("1)Shopping");
			System.out.println("2)Print Shopping Cart");
			System.out.println("3)Paying");
			System.out.println("4)Print wallet");
			System.out.print("Select menu (0 : go back to the previous step) : ");
			try {
				s2 = keyboard.nextInt();
				
				if(s2 == 1) shopping(keyboard, mart, customer);
				else if(s2 == 2) printShoppingCart(customer);
				else if(s2 == 3) {
					System.out.println(present);
					paying(customer, keyboard, mart);
				}
				else if(s2 == 4) printWallet(customer);
				else if(s2 == 0) return;
				else {
					throw new InvalidAccessException(s2, 0,4);
				}
			}
			catch(InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.println("Please enter integer value");
				continue;
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
			
		}
	}
	
	public static void shopping(Scanner keyboard, Mart mart, Customer customer) {
		int product, quantity;
		keyboard = new Scanner(System.in);
		while(true) {
			product =0;
			quantity = 0;
			mart.printSaleList();
			try {
				System.out.print("Select Product (0 : go back to previous step) : ");
				product = keyboard.nextInt();
				if(product == 0) {
					return;
				}
				if(product <0 || product > mart.getSalesSize()) {
					throw new InvalidAccessException(product, 0,  mart.getSalesSize());
				}
				System.out.print("Enter quantity: ");
				quantity = keyboard.nextInt();
				if(quantity <0 ) {
					throw new InvalidAccessException("Please enter a positive value");
				}
				try {
					mart.buying(product, quantity, present, customer, 0);
				}
				catch(ExpiredException e) {
					System.out.println(e.getMessage());
				}
			}
			catch(InputMismatchException e) {
				keyboard = new Scanner(System.in);
				System.out.println("Please enter integer value");
			}
			catch(InvalidAccessException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void printShoppingCart(Customer customer) {
		customer.printShoppingCart();
	}
	
	public static void paying(Customer customer, Scanner keyboard, Mart mart) {
		int pay;
		keyboard = new Scanner(System.in);
		PrintWriter receipt = null;
		customer.printShoppingCart();
		printWallet(customer);
		while(true) {
			System.out.print("Select payment method : ");
			try {
				pay = keyboard.nextInt();
				if(pay == 0) {
					return;
				}
				
				if(pay < 1 || pay > customer.getWalletSize()) {
					throw new InvalidAccessException(pay, 1,customer.getWalletSize() );
					
				}
				
				try {
					receipt = new PrintWriter(new FileOutputStream("Receipt("+Mart.transactionNum+").txt" ));
				} 
				catch (FileNotFoundException e) {
					System.out.println("Problem to make file");
				}
				customer.paying(receipt, pay, keyboard, mart);
				
				receipt.close();
				
				Mart.transactionNum += 1;
				return;
			}
			catch(InputMismatchException e) {

				keyboard = new Scanner(System.in);
				System.out.println("Please enter integer value");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
	}
	public static void printWallet(Customer customer) {
		for(int pay_idx = 0; pay_idx < customer.getWallet().size(); pay_idx ++) {
			System.out.println(pay_idx + 1 + "." + customer.getWallet().get(pay_idx).toString());
		}
	}
}
