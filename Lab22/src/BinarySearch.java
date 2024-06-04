import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {
	public static boolean found(String searchName, ArrayList<String> myList){
		int j1 = 0, j2 = myList.size() - 1;
		int mid = (j1 + j2 + 1)/2;
		String myLetter = searchName;
		boolean found = false;
		while (j2 - j1 >1) {
			if (myList.get(mid).equals(searchName)) {
				found = true;
				break;
			} else if (myLetter.compareTo(myList.get(mid)) == - 1) {
				j2 = mid;
			} else {
				j1 = mid;
			}
			mid = (j1 + j2 + 1)/2;
		}
		return found;
	}

	public static void main(String[] args) {
		String searchedName = args[0];
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> myNames = new ArrayList<>();
		while(scanner.hasNextLine()) {
			myNames.add(scanner.nextLine());
		}
		
		
		if (found(searchedName, myNames)) {
			System.out.println("MATCH");
		} else {
			System.out.println("NOT FOUND");
		}
		scanner.close();
	}
}
