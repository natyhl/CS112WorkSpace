
import java.util.Scanner;

public class EightLines {
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		int counter = 0;
		while (scanner1.hasNextLine()) {
			Scanner scanner2 = new Scanner(scanner1.nextLine());
			while (scanner2.hasNext()) {
				System.out.println(scanner2.next());
			}
			counter++;
			if(counter==8) {
				break;
			}
		}
	if(counter<8) {
		System.out.println("ERROR. Your input needs to be least 8 lines");
	}
	}

}
