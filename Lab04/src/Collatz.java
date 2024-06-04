class Collatz {
	static int runSteps(int n) {
		int numberOfSteps = 0;
		while(n!=1) {
			if(n%2==0) {
				n/=2;
				numberOfSteps++;
			}else {
				n= 3*n + 1;
				numberOfSteps++;
			}
		}
		return numberOfSteps;
	}
	
	static public void main(String[] args) {
		int currentNumber = 1;
		while (currentNumber <= 200) {
			System.out.println(currentNumber + " " + runSteps(currentNumber));
			currentNumber++;
		}
	}
}
