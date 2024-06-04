import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SortTest {
	public static void main(String[] args) {
		try {
		String fileName = args[0];
		File myFile = new File(fileName);
		//idea of reading file from https://www.w3schools.com/java/java_files_read.asp
		Scanner myReader = new Scanner(myFile);
		String[] myArray = myReader.nextLine().split(" ");
		boolean isNonDecreasing = true;
		
		for(int i=0;i<myArray.length-1;i++) {
			if(Integer.parseInt(""+myArray[i])>Integer.parseInt(""+myArray[i+1])) {
				isNonDecreasing=false;
			}
		}
		if(myArray.length!=10000) {
			System.out.println("FAIL incorrect element count");
		}else if(!isNonDecreasing) {
			System.out.println("FAIL incorrect sort");
		}else {
			System.out.println("PASS");
		}
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  }
		}
