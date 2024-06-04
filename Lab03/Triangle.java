public class Triangle{
	public static void main(String[] args){
		for(int i=1; i<16; i++){
			int currentNumber = i;
			for (int j=0;j<i;j++){
				System.out.print(currentNumber+" ");
				currentNumber+=i;
			}
			System.out.println();
		}
	}

	
}