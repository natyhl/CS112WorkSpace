class Program05 {
	public static void main(String[] args) {
		float radius = 5; // 5 centimeters
		double height = 10;
		float baseArea = (float) Math.PI*radius * radius;
		double coneVolume = ((double) 1)/3 * baseArea * height;
		System.out.println("The volume of our cone is " + coneVolume);
	}
}