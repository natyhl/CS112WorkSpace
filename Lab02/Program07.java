class Program07 {
	public static void main(String[] args) {
		byte secondsPerMinute = 60;
		short minutesPerHour = 60;
		int secondsPerHour = secondsPerMinute * minutesPerHour;
		short hoursPerDay = 24;
		int secondsPerDay = secondsPerHour * hoursPerDay;
		int daysPerYear = 365;
		long secondsPerYear = (long) secondsPerDay * daysPerYear;
		
		System.out.println("There are " + secondsPerYear + " seconds in a year.");
		float PI = 3.14159265f;
		float approx = PI * 1e7f;
		System.out.println("A good approximation is " + approx);
		
		float pct = 100 * (secondsPerYear - approx)/approx;
		System.out.println("The percentage error is "+pct);
	}
}