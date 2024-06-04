public class Limits{
	public static void main(String[] args){
		byte var1_byte=0;
		byte var2_byte=var1_byte;
		short var1_short=0;
		short var2_short=var1_short;
		int var1_int=0;
		int var2_int=var1_int;

		// max values

		do{
			var2_byte = var1_byte;
			var1_byte++;
		}
		while(var1_byte > var2_byte);
		byte maxByte = var2_byte;

		do{
			var2_short = var1_short;
			var1_short++;
		}
		while(var1_short > var2_short);
		short maxShort = var2_short;

		do{
			var2_int = var1_int;
			var1_int++;
		}
		while(var1_int > var2_int);
		int maxInt = var2_int;

		// min values

		do{
			var2_byte = var1_byte;
			var1_byte--;
		}
		while(var1_byte < var2_byte);
		byte minByte = var2_byte;

		do{
			var2_short = var1_short;
			var1_short--;
		}
		while(var1_short < var2_short);
		short minShort = var2_short;

		do{
			var2_int = var1_int;
			var1_int--;
		}
		while(var1_int < var2_int);
		int minInt = var2_int;







		System.out.println("Maximum byte value is "+maxByte);
		System.out.println("Minimum byte value is "+minByte);
		System.out.println("Maximum short value is "+maxShort);
		System.out.println("Minimum short value is "+minShort);
		System.out.println("Maximum int value is "+maxInt);
		System.out.println("Minimum int value is "+minInt);
		
	}
}