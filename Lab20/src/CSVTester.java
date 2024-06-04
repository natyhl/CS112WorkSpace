import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

//first exception
class NumberException extends Exception{
	NumberException(String eMessage) {
		super(eMessage);
	}
}
//second exception
class EmptyLineException extends NumberException{
	EmptyLineException() {
		super("");
	}
}

class CSVWriter extends FileWriter{
	public CSVWriter(File file) throws IOException{
		super(file);
	}

	public CSVWriter(String fileName) throws IOException{
		super(fileName);
	}

	void writeln(String[] stringsForALine) throws IOException {
		int myArrayLength = stringsForALine.length;

		for(int i=0;i<stringsForALine.length-1;i++) {
			super.write(stringsForALine[i]+",");
		}
		super.write(stringsForALine[stringsForALine.length-1]+"\n");
	}
}

public class CSVTester{
	public static void main (String[] args) throws IOException, NumberException{
		int myCount=0;
		File theFile = new File("CSVTester.csv");
		CSVWriter myCsvWriter = new CSVWriter(theFile);
		try {
			Scanner scan = new Scanner(System.in);

			while(scan.hasNextLine()) {
				String[] myLine = scan.nextLine().split(" ");
				int myArrayLength=myLine.length;

				if("".equals(myLine[0]) && myLine.length==1) {
					throw new EmptyLineException();
				}else if(myCount==0) {
					myCount=myArrayLength;
					myCsvWriter.writeln(myLine);
				}else if(myArrayLength!=myCount) {
					throw new NumberException("Please provide "+myCount+" instead of "+myArrayLength);
				}else {

					myCsvWriter.writeln(myLine);
				}
			}
			System.out.println("*");
			myCsvWriter.close();

		}catch(EmptyLineException e) {
			myCsvWriter.close();
			System.exit(0);//from Andrew
		}
	}
}

