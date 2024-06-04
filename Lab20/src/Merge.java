//used logic used in class on Monday, Apr 8

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Merge {
	public static void main(String[] args) {
		try {
		String fileName1 = args[0];
		String fileName2 = args[1];
		String fileName3 = args[2];
		File myFile1 = new File(fileName1);
		File myFile2 = new File(fileName2);
		File myFile3 = new File(fileName3);
		String[] myArray1=new String[0];
		String[] myArray2=new String[0];
		String[] myArray3=new String[0];
		
		Scanner myReader1 = new Scanner(myFile1);
		if(myReader1.hasNextLine()) {
		myArray1 = myReader1.nextLine().split(" ");
		}
		
		Scanner myReader2 = new Scanner(myFile2);
		if(myReader2.hasNextLine()) {
		myArray2 = myReader2.nextLine().split(" ");
		}
		
		Scanner myReader3 = new Scanner(myFile3);
		if(myReader3.hasNextLine()) {
		myArray3 = myReader3.nextLine().split(" ");
		}
		
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		// A new array to hold the output.
		int[] output = new int[myArray1.length + myArray2.length + myArray3.length];
			
		// For each slot in the output array...
		for(int o = 0; o < output.length; o++) {
			// If we still have data in both input arrays...
			if (i1 < myArray1.length && i2 < myArray2.length && i3 < myArray3.length) { 
				// Find which input has smaller UNUSED input,
				// and copy that one to the output.
				if ((Integer.parseInt(""+myArray1[i1]) <= Integer.parseInt(myArray2[i2]))&&(Integer.parseInt(myArray1[i1]) <= Integer.parseInt(myArray3[i3]))) {
					output[o] = Integer.parseInt(""+myArray1[i1++]);
				}else if((Integer.parseInt(""+myArray2[i2]) <= Integer.parseInt(myArray1[i1]))&&(Integer.parseInt(myArray2[i2]) <= Integer.parseInt(myArray3[i3]))) {
					output[o] = Integer.parseInt(""+myArray2[i2++]);
				}else if((Integer.parseInt(""+myArray3[i3]) <= Integer.parseInt(myArray1[i1]))&&(Integer.parseInt(myArray3[i3]) <= Integer.parseInt(myArray2[i2]))) {
					output[o] = Integer.parseInt(""+myArray3[i3++]);}
				
//corrected from Andrew					
//				//if equal:
//				}else if(Integer.parseInt(""+myArray1[i1])==Integer.parseInt(""+myArray2[i2])&&Integer.parseInt(""+myArray1[i1])<Integer.parseInt(""+myArray3[i3])) {
//					output[o] = Integer.parseInt(""+myArray1[i1++]);
//				}else if(Integer.parseInt(""+myArray1[i1])==Integer.parseInt(""+myArray3[i3])&&Integer.parseInt(""+myArray1[i1])<Integer.parseInt(""+myArray2[i2])) {
//					output[o] = Integer.parseInt(""+myArray1[i1++]);
//				}else if(Integer.parseInt(""+myArray2[i2])==Integer.parseInt(""+myArray3[i3])&&Integer.parseInt(""+myArray2[i2])<Integer.parseInt(""+myArray1[i1])) {
//					output[o] = Integer.parseInt(""+myArray2[i2++]);
//				}
			}else if(i1 < myArray1.length && i2<myArray2.length && i3==myArray3.length) { // just array3 done
				if ((Integer.parseInt(""+myArray1[i1]) <= Integer.parseInt(myArray2[i2]))) {
					output[o] = Integer.parseInt(""+myArray1[i1++]);
				}else if((Integer.parseInt(""+myArray2[i2]) < Integer.parseInt(myArray1[i1]))) {
					output[o] = Integer.parseInt(""+myArray2[i2++]);
				}
			}else if(i1 < myArray1.length && i3<myArray3.length && i2==myArray2.length) { // just array2 done
				if ((Integer.parseInt(""+myArray1[i1]) <= Integer.parseInt(myArray3[i3]))) {
					output[o] = Integer.parseInt(""+myArray1[i1++]);
				}else if((Integer.parseInt(""+myArray3[i3]) < Integer.parseInt(myArray1[i1]))) {
					output[o] = Integer.parseInt(""+myArray3[i3++]);
				}
			}else if(i3 < myArray3.length && i2<myArray2.length && i1==myArray1.length) { // just array1 done
				if ((Integer.parseInt(""+myArray3[i3]) <= Integer.parseInt(myArray2[i2]))) {
					output[o] = Integer.parseInt(""+myArray3[i3++]);
				}else if((Integer.parseInt(""+myArray2[i2]) < Integer.parseInt(myArray3[i3]))) {
					output[o] = Integer.parseInt(""+myArray2[i2++]);
				}	
			}else if (i1 < myArray1.length && i2==myArray2.length && i3==myArray3.length) { // array2 and 3 are done
				output[o] = Integer.parseInt(""+myArray1[i1++]);
			}else if (i2 < myArray2.length && i1==myArray1.length && i3==myArray3.length) { // array1 and 3 are done
				output[o] = Integer.parseInt(""+myArray2[i2++]);
			}else if (i3 < myArray3.length && i2==myArray2.length && i1==myArray1.length) { // array1 and 2 are done
				output[o] = Integer.parseInt(""+myArray3[i3++]);
			}
		}

		// Print final results!
		for(int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println();
		}catch(FileNotFoundException e) {
			System.err.println(e+", couldn't find the file");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println(e+", provide three files");
		}
	}
}



