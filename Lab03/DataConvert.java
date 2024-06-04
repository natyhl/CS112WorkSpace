public class DataConvert{
	public static void main(String[] args){
		float fl = 2.5f;
		int int_var = (int)fl;
		System.out.println("2.5 cast to int gives "+int_var);

		fl = -4.5f;
		int_var= (int)fl;
		System.out.println("-4.5 cast to int gives "+int_var);

		double d = 1.0/3.0;
		fl=(float) d;
		System.out.println("double 1/3 = "+d+" but float 1/3 = "+fl);

		int_var = 256;
		byte byte_var = (byte) int_var;
		System.out.println("byte value of 256 is "+byte_var);

		int_var = 257;
		byte_var = (byte) int_var;
		System.out.println("byte value of 257 is "+byte_var);

		int_var = 258;
		byte_var = (byte) int_var;
		System.out.println("byte value of 258 is "+byte_var);

		int_var = 511;
		byte_var = (byte) int_var;
		System.out.println("byte value of 511 is "+byte_var);
	}

}