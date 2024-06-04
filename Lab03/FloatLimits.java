public class FloatLimits{
	public static void main(String[] args){
				float var_float=1.0f;
				double var_double=1.0;

				while(var_float/2>0){
					var_float/=2.0;
				}
				while(var_double/2>0){
					var_double/=2.0;
				}

				System.out.println("Smallest positive float is "+var_float);
				System.out.println("Smallest positive double is "+var_double);
	}

}