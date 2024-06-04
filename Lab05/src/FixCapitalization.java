
public class FixCapitalization {
	public static void main(String[] args) {
		String inputLine = args[0].toLowerCase();
		char[] line = inputLine.toCharArray();
		boolean mustCapitalizeNextLetter = true;
		
		for(int i=0;i<inputLine.length(); i++) {
			while(mustCapitalizeNextLetter) {
				if(line[i]==' ') {
					break;
				}else {
					line[i]= Character.toUpperCase(line[i]);
					mustCapitalizeNextLetter = false;	
				}
			}
			if(line[i]=='.'|| line[i]=='!'||line[i]=='?') {
				mustCapitalizeNextLetter = true;
			}
		}System.out.print(line);
	}
}
//done