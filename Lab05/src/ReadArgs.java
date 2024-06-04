
public class ReadArgs {
	static public void main(String[] args) {
		int numOfArgs = args.length;
		System.out.println("Program called with "+ numOfArgs+ " arguments:");
		for(int i=0;i<numOfArgs;i++) {
			System.out.println(args[i]);
		}
	}

}//done
