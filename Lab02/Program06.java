class Program06 {
	static double mySquareRoot(double d) {
		if (d < 0) {
			return -1.0 * Math.sqrt(-d);
		}else {
			return Math.sqrt(d);
		}
	}

	public static void main(String[] args) {
		System.out.println(mySquareRoot(-4.0));
		System.out.println(mySquareRoot(0.01));
	}
}