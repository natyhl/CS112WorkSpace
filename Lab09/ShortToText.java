

public class ShortToText {

	public static void main(String[] args) {
		short value = Short.parseShort(args[0]);
		String binaryString = "";
		for(int i=15; i>=0;i--) { //i was inspired for the idea of "reverse" for loop by chat GPT
			if((value&(int)Math.pow(2.0,i))==0) {
				binaryString+=0;
			}else {
				binaryString+=1;
			}
		}
		System.out.println(binaryString);
	}
}
