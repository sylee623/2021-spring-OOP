package lab2;

import java.util.Scanner;

public class lab2_2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(" ");
		
		float sum = 0;
		int tmp = 0;
		for(int i=0; i<input.length;++i) {
			tmp = scoring(input[i]);
			sum += tmp;
			System.out.println(makeOrdinalNumber(i+1)+" student's score is "+ tmp);
		}
		float average = sum/(input.length);
		String fixedNum= String.format("%.2f", average);
		System.out.println(average);
		System.out.println("The class's average = " +fixedNum);
	}
	private static int scoring(String grade) {
		int score = 0;
		grade = grade.toUpperCase();
		switch(grade) {
			case "A" : 
				score = 100;
				break;
			case "B" :
				score = 90;
				break;
			case "C" :
				score = 80;
				break;
			case "D" :
				score = 70;
				break;
			case "F" :
				score = 0;
				break;
		}
		return score;
	}
	public static String makeOrdinalNumber(int num) {
		switch(num % 10) {
		case 1:
			return num +"st";
		case 2:
			return num + "nd";
		case 3:
			return num + "rd";
		}
		return num + "th";
	}
}
