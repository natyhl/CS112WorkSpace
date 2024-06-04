
class WordConvert {
	public String convertWord(String word) {
		if (word.equals("tea")) {
			return "coffee";
		} else if(word.equals("Tea")) {
			return "Coffee";
		}else if(word.equals("tea.")) {
			return "coffee.";
		}else if(word.equals("Tea.")) {
			return "Coffee.";
		}else if(word.equals(".tea")) {
			return ".coffee";
		}else if(word.equals(".Tea")) {
			return ".Coffee";
		}else if(word.equals(".Tea.")) {
			return ".Coffee.";
		}else {
			return word;
		}
	}
}

public class Americanize {
	public static void main(String[] args) {
		String[] input = args[0].split(" ");
		WordConvert wordConverter = new WordConvert();
		String answer = " ";
		for (String word : input) {
			answer=answer.concat(wordConverter.convertWord(word)+" ");
		}
		System.out.println(answer);
	}
} 

