package quiz1;


import java.util.Scanner;

public class CardGame {
	public static void main(String[] args) {
	    Scanner keyboard = new Scanner(System.in);
	    
	    System.out.printf("Player Name : ");
	    String playerName = keyboard.next();
	    
	    System.out.println("------------------------");
	    
	    Participant participant1 = new Participant(playerName);
	    Participant dealer = new Participant("Dealer");
	    
	    for (int round = 0; round<3; round ++) {
		    System.out.println(dealer.toString());
		    System.out.println(participant1.toString());
		    if(Card.compareCard(participant1.getCard(), dealer.getCard()) == -1) {
		    	participant1.addPoint(1);
		    }
		    participant1.setCard(dealer.getCard());
		    dealer.changeCard();
		    System.out.println("------------------------");
	    }
	    
	    System.out.println(participant1.getName() + ", "+ participant1.getPoint()+ " points");
}
}
