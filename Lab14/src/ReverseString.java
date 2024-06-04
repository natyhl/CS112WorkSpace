// This program inputs a string from args[0], reverses it,
// and prints out the result.

class ReverseString {
	// Reverse the chars in 'input' and return the result.
	static String StringToCharsReverse(String input) {
		char output[] = new char[input.length()];
		int i = input.length();
		while (i > 0) {
			output[--i] = input.charAt(input.length()-i-1);
		}
		String answer = new String(output);
		return answer;
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("ERROR: need input arg");
			return;
		}
		String input = args[0];
		System.out.println(StringToCharsReverse(input));
	}
}
