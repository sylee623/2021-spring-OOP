package lab2;

import java.util.Scanner;

public class lab2_1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(",");
		String[] korean = input[0].split(" ");
		System.out.println("Name Length(Korean) : "+korean.length);
		System.out.println(korean[1].toUpperCase().substring(0,1)+"."+korean[2].toUpperCase().substring(0,1)+"."+korean[0].substring(0,1).toUpperCase()+korean[0].substring(1) +"."+ "submitted Homework.pdf");
	}
}
