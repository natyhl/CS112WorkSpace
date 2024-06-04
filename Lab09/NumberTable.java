
public class NumberTable {
	public static void main(String[] args) {
		for(int i=100;i<256;i++) {
			short value = (short) i;
			String binaryString = "";
			for(int j=7; j>=0;j--) {
				if((value&(int)Math.pow(2.0,j))==0) {
					binaryString+=0;
				}else {
					binaryString+=1;
				}
			}
		System.out.printf("%d %x "+binaryString, i, i);
		System.out.println();
		}
		
	}

}
