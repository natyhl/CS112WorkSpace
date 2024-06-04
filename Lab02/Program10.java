class Program10 {
	char charFromInt(int n) {
		if (n > 0) {
			return (char) n;
		}
		return 0;
	}

	public static void main(String[] args) {
		Program10 prog10 = new Program10();
		
		System.out.print(prog10.charFromInt(103));
		System.out.print(prog10.charFromInt(121));
		System.out.print(prog10.charFromInt(121));
		System.out.print(prog10.charFromInt(100));
	}
}