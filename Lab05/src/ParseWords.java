import java.util.ArrayList;

public class ParseWords {
	public static void main(String[] args) {
		String input = args[0];
		boolean isColon = false;  
		if(input.length()==0) {
			return;
		}

		if(input.length()==1) {
			if(Character.compare(input.charAt(0), ':')==0) {
				System.out.println("BLANK");
				System.out.println("BLANK");
			}else {
				System.out.println(input.charAt(0));
			}
		}else{
			for(int i=0;i<input.length();i++) {
				if((Character.compare(input.charAt(i), ':')==0)) {
					isColon = true;
					if(i==0 || Character.compare(input.charAt(i-1), ':')==0){
						System.out.println("BLANK");
					}else{
						System.out.println();

					}
					isColon = false;
				}else {
					while (!isColon) {
						System.out.print(input.charAt(i));
						break;
					}
				}
			}
			if(Character.compare(input.charAt(input.length()-1), ':')==0){
				System.out.println("BLANK");
			}
		}  	
	}
}//done

