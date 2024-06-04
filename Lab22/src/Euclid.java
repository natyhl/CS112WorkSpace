import java.io.IOException;

public class Euclid {
	
	public static int findGcf(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGcf(b, a % b);
        }
    }
	
	public static void main (String[] args){
		
		try {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			findGcf(a, b);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.print("ERROR:"+e);
		}catch(NumberFormatException e) {
			System.err.print("ERROR:"+e);
		}
		
		
	}

}
