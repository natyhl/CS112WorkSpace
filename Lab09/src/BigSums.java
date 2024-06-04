
public class BigSums {
	public static void main(String[] args) {
		//for doubles
		double d1 = 1024;
		double d2 = d1;
		double d3 = d2+1.0;
		int count1 = 0;
		while((d3 - d2)==1.0) {
			d2 *= d1;
			d3 = d2+1.0;
			count1++;
		}
		System.out.println(count1);
		
		//for floats
		float f1 = 1024;
		float f2 = f1;
		float f3 = f2+1.0f;
		int count2 = 0;
		while((f3-f2)==1.0) {
			f2 *= f1;
			f3 = f2+1.0f;
			count2++;
		}
		System.out.println(count2);
	}
}
