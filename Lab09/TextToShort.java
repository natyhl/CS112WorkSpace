
public class TextToShort {

	public static void main(String[] args) {
		String values = args[0];
		if(values.length()>16) {
			System.err.println("ERROR");
		}else {
			String valuesList = "";
			for(int i=0;i<values.length();i++) {
				if(values.charAt(i)=='1') {
					valuesList+= '1';
				}else if(values.charAt(i)=='0'){
					valuesList+= '0';
				}
			}
			short answer = (short) 0;
			for(int i=0; i<values.length();i++) {
				if(valuesList.charAt((values.length()-1-i))=='1') {
					answer+=Math.pow(2,i);
				}
			}
			System.out.println(answer);
		}
	}
}
