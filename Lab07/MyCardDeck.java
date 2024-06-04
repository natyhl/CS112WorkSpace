
import java.util.Random;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class MyCardDeck {
	
class Card{
	private int value;
	private String suit;
	
	public Card(int myValue, String mySuit) {
		
		//check and set value
		if(!(2<=myValue && myValue<=14)) {
			System.out.println("ERROR. The card number needs to be between 2 to 14.");
		}else {
			this.value=myValue;
		}
		//check and set suit
		char whichSuit = mySuit.charAt(0);
		if((whichSuit=='s') || (whichSuit=='S') ) {
			this.suit = "Spades";
		}else if((whichSuit=='h') || (whichSuit=='H') ) {
			this.suit = "Hearts";
		}else if((whichSuit=='c') || (whichSuit=='C') ) {
			this.suit = "Clubs";
		}else if((whichSuit=='d') || (whichSuit=='D') ) {
			this.suit = "Diamonds";
		}else {
			System.out.println("ERROR. The suit can only be Spades, Hearts, Clubs or Diamonds");
		}
	}
	
	public Card(String input) {
		
        //check and set value
		char inputValue = input.charAt(0);
		if (('2' <= inputValue) && (inputValue <= '9')) {
			this.value = Integer.parseInt(""+inputValue);
		}else if(inputValue=='j'||inputValue=='J') {
			this.value=11;	
		}else if(inputValue=='q'||inputValue=='Q') {
			this.value=12;
		}else if(inputValue=='k'||inputValue=='K') {
				this.value=13;
		}else if(inputValue=='a'||inputValue=='a') {
			this.value=14;
		}else if(inputValue=='1') {
			if(input.charAt(1)=='0') {
				this.value=10;
			}else {
				this.value = 0;
				this.suit = "ERROR";
			}
		}else {
			this.value = 0;
			this.suit = "ERROR";
		}
		
		//check and set suit
		if(input.charAt(0)=='1') {
			char whichSuit = input.charAt(2);
			if((whichSuit=='s') || (whichSuit=='S') ) {
				this.suit = "Spades";
			}else if((whichSuit=='h') || (whichSuit=='H') ) {
				this.suit = "Hearts";
			}else if((whichSuit=='c') || (whichSuit=='C') ) {
				this.suit = "Clubs";
			}else if((whichSuit=='d') || (whichSuit=='D') ) {
				this.suit = "Diamonds";
			}else {
				this.value = 0;
				this.suit = "ERROR";
				System.out.println("ERROR. The suit can only be Spades, Hearts, Clubs or Diamonds");
			}	
		}else{
			char whichSuit = input.charAt(1);
			if((whichSuit=='s') || (whichSuit=='S') ) {
				this.suit = "Spades";
			}else if((whichSuit=='h') || (whichSuit=='H') ) {
				this.suit = "Hearts";
			}else if((whichSuit=='c') || (whichSuit=='C') ) {
				this.suit = "Clubs";
			}else if((whichSuit=='d') || (whichSuit=='D') ) {
				this.suit = "Diamonds";
			}else {
				this.value = 0;
				this.suit = "ERROR";
				System.out.println("ERROR. The suit can only be Spades, Hearts, Clubs or Diamonds");
			}	
	}
}
	public int Value() {
		if(value==11) {
			return 'J';
		}else if(value==12) {
			return 'Q';
		}else if(value==13) {
			return 'K';
		}else if(value==14) {
			return 'A';
		}else{
			return value;
		}
	}
	public String Suit() {
		return ""+suit.charAt(0);
	}
	
	public String toString() {
		if(value==11) {
			return "J"+ Suit();
		}else if(value==12) {
			return "Q"+ Suit();
		}else if(value==13) {
			return "K"+ Suit();
		}else if(value==14) {
			return "A"+ Suit();
		}else{
			return value+Suit();
		}
	}
}

public class Deck{
	Card allMyCards[] = new Card[52];
	
	public Deck(){
		int position = 0;
	
	for(int i=2;i<15;i++) {
		allMyCards[position]=new Card(i, "spades");
		position++;
	}
	for(int j=2;j<15;j++) {
		allMyCards[position]=new Card(j, "hearts");
		position++;
	}
	for(int h=2;h<15;h++) {
		allMyCards[position]=new Card(h, "clubs");
		position++;
	}
	for(int d=2;d<15;d++) {
		allMyCards[position]=new Card(d, "diamonds");
		position++;
	}
	}
	public String toString() {
		String answerString = "";
		for(Card c: allMyCards) {
			answerString += c.toString()+" ";
		}return answerString;
	}
	
	public void shuffle() {
		Random random = new Random();
		for(int i=0;i<1000;i++) {
			int randomNumber1 = random.nextInt(0,51);
			int randomNumber2 = random.nextInt(0,51);
			Card temparateCard = allMyCards[randomNumber1];
			allMyCards[randomNumber1] = allMyCards[randomNumber2];
			allMyCards[randomNumber2] = temparateCard;
		}
	}
}


	public static void main(String[] args) {
		MyCardDeck myCards = new MyCardDeck();
		if(args.length==0) { 
			Deck myDeck = myCards.new Deck();
			myDeck.shuffle();
			System.out.print(myDeck);
		}else {
			String input = args[0];
			Card yourCard = myCards. new Card(input);
			System.out.println(yourCard);
		}
	}
}

