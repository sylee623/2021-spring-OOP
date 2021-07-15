package quiz2;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class SortCard {
	public static void main(String[] args) {
		int cardNum = 0;
		int extraCardNum = 0;
		Random rand = new Random();
		Scanner keyboard = new Scanner(System.in);
		
		// 1
		System.out.print("Enter the length of array: ");
		try {
			cardNum = keyboard.nextInt();
			if(cardNum < 0) throw new BadNumberException(cardNum);
		}
		catch(BadNumberException e){
			System.out.println("Bad number, " + e.getBadNumber() + " cannot be used");
			System.out.print("Enter number again : ");
			cardNum = keyboard.nextInt();
		}
		
		System.out.println("---------------------------------");
		
		Card[] cardList = new Card[cardNum];
		
		for(int i=0; i<cardNum; i++) {
			cardList[i] =new Card(rand.nextInt(4),rand.nextInt(13) + 1);
		}
		
		for(int i=0; i<cardNum; i++) {
			System.out.println(cardList[i]);
		}
		System.out.println("---------------------------------");
		
		Arrays.sort(cardList);
		for(int i=0; i<cardNum; i++) {
			System.out.println(cardList[i]);
		}
		System.out.println("---------------------------------");
		
		// 2
		ArrayList<Card> cardArrayList = new ArrayList<Card>();
		for(int i=0; i<cardNum; i++) {
			cardArrayList.add(cardList[i]);
		}
	
		System.out.print("Enter the number to increase : ");
		try {
			extraCardNum = keyboard.nextInt();
			if(extraCardNum < 0) throw new BadNumberException(extraCardNum);
		}
		catch(BadNumberException e){
			System.out.println("Bad number, " + e.getBadNumber() + " cannot be used.");
			System.out.print("Enter number again : ");
			extraCardNum = keyboard.nextInt();
		}
		System.out.println("---------------------------------");
		
		for(int i=0; i<extraCardNum; i++) {
			int is_added = 0;
			Card tmp = new Card(rand.nextInt(4),rand.nextInt(13) + 1);
			for( int k =0; k <cardNum; k++) {
				if(cardArrayList.get(k).compareTo(tmp) == 1 || cardArrayList.get(k).compareTo(tmp) == 0) {
					cardArrayList.add(k, tmp);
					cardNum = cardNum +1;
					is_added =1;
					break;
				}
				else if(cardArrayList.get(k).compareTo(tmp) == -1) {
					continue;
				}
			}
			if(is_added == 0) {
				cardArrayList.add(tmp);
				cardNum = cardNum + 1;
			}
//			for(int k = 0; k<cardNum; k++) {
//				if(cardArrayList.get(k))
//			}
		}
		
		for(int i=0; i<cardNum; i++) {
			System.out.println(cardArrayList.get(i));
		}
		System.out.println("---------------------------------");
		
	}
}
