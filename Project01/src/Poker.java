import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Poker {
	static DataInputStream dis;
	static DataOutputStream dos;
	
	static void write(String s) throws IOException{
		dos.writeUTF(s);
		dos.flush();
	}

	static String read() throws IOException {
		return dis.readUTF();
	}
	
	//bet1
	public static String bet1(String[] s) {
		// named variables received from dealer
		int numberOfChips = Integer.parseInt(s[1]);
		int CurrentBetToMatch = Integer.parseInt(s[3]);
		int maxC;
		int minC;
		int yourHoleC;
		int yourUpC;
		String bet;
		
		//bluff on 10% of the games
		double p = 0.1;
		double random = Math.random();
		if(p==random) {
			bet = "fold";
			
		//or play
		}else{
			if(s[4].charAt(0)=='1') {
				yourHoleC = 10;
			}else if(s[4].charAt(0)=='J') {
				yourHoleC = 11;
			}else if(s[4].charAt(0)=='Q') {
				yourHoleC = 12;
			}else if(s[4].charAt(0)=='K') {
				yourHoleC = 13;
			}else if(s[4].charAt(0)=='A') {
				yourHoleC = 14;
			}else{
				yourHoleC = Integer.parseInt(""+s[4].charAt(0));
			}
			
			if(s[5].charAt(0)=='1') {
				yourUpC = 10;
			}else if(s[5].charAt(0)=='J') {
				yourUpC = 11;
			}else if(s[5].charAt(0)=='Q') {
				yourUpC = 12;
			}else if(s[5].charAt(0)=='K') {
				yourUpC = 13;
			}else if(s[5].charAt(0)=='A') {
				yourUpC = 14;
			}else{
				yourUpC = Integer.parseInt(""+s[5].charAt(0));
			}
			
			maxC = yourUpC;
			minC = yourUpC;
			
			// find visible card with highest value
			int theirUpC;
			for(int i=7;i<s.length;i++) {
				if(s[i].charAt(0)=='1') {
					theirUpC = 10;
				}else if(s[i].charAt(0)=='J') {
					theirUpC = 11;
				}else if(s[i].charAt(0)=='Q') {
					theirUpC = 12;
				}else if(s[i].charAt(0)=='K') {
					theirUpC = 13;
				}else if(s[i].charAt(0)=='A') {
					theirUpC = 14;
				}else {
					theirUpC = Integer.parseInt(""+s[i].charAt(0));
				}
				
				if(theirUpC > maxC) {
					maxC=theirUpC;
				}
			//find visible card with lowest value
				if(theirUpC < minC) {
					minC=theirUpC;
				}
			}
			
			//decide what you're going to bet
			
			//for a pair
			if(yourHoleC == yourUpC) {
				if((yourHoleC >= maxC) || (yourUpC==maxC)) {
					bet = Integer.toString(CurrentBetToMatch+3);
				}else if(yourHoleC>7) {
					bet = Integer.toString(CurrentBetToMatch+1);
				}else {
					bet = Integer.toString(CurrentBetToMatch);
				}
			}else {
				if(yourHoleC>=maxC || yourUpC==maxC) {
					bet = Integer.toString(CurrentBetToMatch+1);
				}else if(yourUpC==minC && !(yourHoleC>minC)) {
					bet = "fold";
				}else {
					bet = Integer.toString(CurrentBetToMatch);
				}
			}
		}
		if(!(bet.equals("fold")) && (Integer.parseInt(""+bet)+CurrentBetToMatch)>numberOfChips) {
			bet = "fold";
		}
		return bet;
	}
	
	public static String bet2(String[] s) {
		// named variables received from dealer
				int numberOfChips2 = Integer.parseInt(s[1]);
				int CurrentBetToMatch2 = Integer.parseInt(s[3]);
				int maxC2;
				int minC2;
				int yourHoleC2;
				int your1stUpC2;
				int your2ndUpC2;
				String bet2;
				boolean iHavePair=false;
				boolean iHaveThree=false;
				int their1stUpC2;
				int their2ndUpC2;
				
				//bluff on 10% of the games
				double p = 0.1;
				double random = Math.random();
				if(p==random) {
					bet2 = "fold";
					
				//or play
				}else{
					if(s[4].charAt(0)=='1') {
						yourHoleC2 = 10;
					}else if(s[4].charAt(0)=='J') {
						yourHoleC2 = 11;
					}else if(s[4].charAt(0)=='Q') {
						yourHoleC2 = 12;
					}else if(s[4].charAt(0)=='K') {
						yourHoleC2 = 13;
					}else if(s[4].charAt(0)=='A') {
						yourHoleC2 = 14;
					}else{
						yourHoleC2 = Integer.parseInt(""+s[4].charAt(0));
					}
					
					if(s[5].charAt(0)=='1') {
						your1stUpC2 = 10;
					}else if(s[5].charAt(0)=='J') {
						your1stUpC2 = 11;
					}else if(s[5].charAt(0)=='Q') {
						your1stUpC2 = 12;
					}else if(s[5].charAt(0)=='K') {
						your1stUpC2 = 13;
					}else if(s[5].charAt(0)=='A') {
						your1stUpC2 = 14;
					}else{
						your1stUpC2 = Integer.parseInt(""+s[5].charAt(0));
					}
					if(s[6].charAt(0)=='1') {
						your2ndUpC2 = 10;
					}else if(s[6].charAt(0)=='J') {
						your2ndUpC2 = 11;
					}else if(s[6].charAt(0)=='Q') {
						your2ndUpC2 = 12;
					}else if(s[6].charAt(0)=='K') {
						your2ndUpC2 = 13;
					}else if(s[6].charAt(0)=='A') {
						your2ndUpC2 = 14;
					}else{
						your2ndUpC2 = Integer.parseInt(""+s[6].charAt(0));
					}
					//Do you have a pair?
					if(your1stUpC2==your2ndUpC2 || your1stUpC2==yourHoleC2 || your2ndUpC2==yourHoleC2) {
						iHavePair=true;
					}else if(your1stUpC2==your2ndUpC2 && your2ndUpC2==yourHoleC2) {
						iHaveThree=true;
					}
					
					maxC2 = your1stUpC2;
					minC2 = your1stUpC2;
					
					// find visible card with highest value
					
					for(int i=8;i<s.length;i++) {
						if(i%2==0) {
							if(s[i].charAt(0)=='1') {
								their1stUpC2 = 10;
							}else if(s[i].charAt(0)=='J') {
								their1stUpC2 = 11;
							}else if(s[i].charAt(0)=='Q') {
								their1stUpC2 = 12;
							}else if(s[i].charAt(0)=='K') {
								their1stUpC2 = 13;
							}else if(s[i].charAt(0)=='A') {
								their1stUpC2 = 14;
							}else {
								their1stUpC2 = Integer.parseInt(""+s[i].charAt(0));
							}
		
							if(s[i+1].charAt(0)=='1') {
								their2ndUpC2 = 10;
							}else if(s[i+1].charAt(0)=='J') {
								their2ndUpC2 = 11;
							}else if(s[i+1].charAt(0)=='Q') {
								their2ndUpC2 = 12;
							}else if(s[i+1].charAt(0)=='K') {
								their2ndUpC2 = 13;
							}else if(s[i+1].charAt(0)=='A') {
								their2ndUpC2 = 14;
							}else {
								their2ndUpC2 = Integer.parseInt(""+s[i+1].charAt(0));
							}
					
							//find visible card with highest value
							if(their1stUpC2 > maxC2) {
								maxC2=their1stUpC2;
							}else if(their2ndUpC2 > maxC2) {
								maxC2 = their2ndUpC2;
							}
						
							//find visible card with lowest value
							if(their1stUpC2 < minC2) {
								minC2=their1stUpC2;
							}else if(their2ndUpC2 < minC2) {
								minC2 = their2ndUpC2;
							}
						}
					}
					
					//decide what you're going to bet
					
					if(iHavePair && (maxC2==your1stUpC2||maxC2==your2ndUpC2||maxC2<=yourHoleC2)) {
						bet2 = Integer.toString(CurrentBetToMatch2+3);
					}else if(iHaveThree && (maxC2==your1stUpC2||maxC2==your2ndUpC2||maxC2==yourHoleC2)) {
						bet2 = Integer.toString(CurrentBetToMatch2+5);
					}else if(minC2==your1stUpC2||minC2==your2ndUpC2||minC2>=yourHoleC2) {
						bet2 = "fold";
					}else {
						bet2 = Integer.toString(CurrentBetToMatch2);
					}
					
				}
				if(!(bet2.equals("fold")) && (Integer.parseInt(""+bet2)+CurrentBetToMatch2)>numberOfChips2) {
					bet2 = "fold";
				}
				return bet2;
			
	}
	
	//main
	public static void main(String[] args) {
		try {
			
			Socket socket = new Socket(args[0], Integer.parseInt(args[1])); 
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
			//keep going forever
			while(true) {
			String readString = read();
			String myBet="";
			String[] betInfo = readString.split(":");
			
			//login
			if(betInfo[0].equals("login")) {
				write("natyhl:naty");
			//done
			}else if(betInfo[0].equals("done")) {
				System.out.println(readString);
				socket.close();
				return;
			}else if(betInfo[0].equals("status")) {
				//is status, do nothing
				
			}else{
				if(betInfo[0]=="lost") {
					System.out.println("You lost");
				
				}else if(betInfo[0].equals("bet1")) {
					myBet = bet1(betInfo); //play bet1
				}else if(betInfo[0].equals("bet2")) {
					myBet = bet2(betInfo); //playbet2
				}
				
				if(myBet.equals("fold")){
					write("fold");
				}else if(Integer.parseInt(""+myBet)<=Integer.parseInt(""+betInfo[1])){
					write("bet:"+myBet);
				}else {
					write("fold");
				}
			}
			}
			
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}
