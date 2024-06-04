
public class SmallSums {
	public static void main(String[] args) {
		float myFloat = (float) 0.000001;
		float sumFloat = (float) 0.0;
		for( int i=0;i<1000000;i++) {
			sumFloat+=myFloat;
		}
		double myDouble = (double) 0.000001;
		double sumDouble = (double) 0.0;
		for( int i=0;i<1000000;i++) {
			sumDouble+=myDouble;
		}
		System.out.println(sumFloat);
		System.out.println(sumDouble);
		
	}

}
