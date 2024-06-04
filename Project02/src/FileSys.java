
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

//I used code from Day22 and extended it
class NonBinaryNode {
	String name;
	boolean isFile;//idea from chatGPT
	ArrayList<NonBinaryNode> myChildren;
	ArrayList<Directory> myDirectories;
	ArrayList<File> myFiles;
	NonBinaryNode parent;
	
	//constructor for a NonBinaryNode. A NonBinaryNode can be a directory or a File
	public NonBinaryNode(String name, NonBinaryNode myParent, boolean myIsFile) {
		this.name= name;
		myChildren = new ArrayList<>(); //myFiles and myChildren combined together in anothe ArrayList
		myFiles = new ArrayList<>();
		myDirectories = new ArrayList<>();
		parent=myParent;
		isFile=myIsFile;
	}
	public NonBinaryNode getParentDir() {
		if(name.equals("/")) { //for the root
			return this;
		}else{
			return parent;
		}
	}
	
	//remove file
	public void removeF(String myFileName) {
		for(int i=0;i<myChildren.size();i++) {
			if(myChildren.get(i).name.equals(myFileName)) {
				myChildren.remove(i);
			}
		}
		for(int i=0;i<myFiles.size();i++) {
			if(myFiles.get(i).name.equals(myFileName)) {
				myFiles.remove(i);
			}
		}
	}
	
	//remove directory
	public void removeDir(String myDirName) {
		for(int i=0;i<myChildren.size();i++) {
			if(myChildren.get(i).name.equals(myDirName)) {
				myChildren.remove(i);
			}
		}
		for(int i=0;i<myDirectories.size();i++) {
			if(myDirectories.get(i).name.equals(myDirName)) {
				myDirectories.remove(i);
			}
		}
	}
	public String getFileContent(){
		return "";
	}
}
//File class
	class File extends NonBinaryNode{
		String fileContentString="";
		
		public File(String myName, NonBinaryNode myParent) {
			super(myName, myParent, true);
		}
		public String write(String s) {
			fileContentString+=s;
			return fileContentString;
		}
		@Override //shared with NonBinaryNode (line 60), because of du()
		public String getFileContent(){
			return fileContentString;
		}
	}
	
	//Directory class
	class Directory extends NonBinaryNode{
		
		public Directory(String dirName, NonBinaryNode myParent) {
			super(dirName, myParent, false);
		}
	}

class NonBinaryTree { //tree that stores directories and files
	public NonBinaryNode root = null;
	public NonBinaryNode currDirectory;
	
	public NonBinaryTree() {
		root = new Directory("/", root);
		root.parent = root;
		currDirectory = root;
	}
	// Add a new node to this tree.
	public void addFile(File myF) {
		currDirectory.myChildren.add(myF);
		currDirectory.myFiles.add(myF);
	}
	
	public void addDirectory(Directory myDir) {
		currDirectory.myChildren.add(myDir);
		currDirectory.myDirectories.add(myDir);
	}
	//called by "cd" command
	public void changeDir(String newDir) {
		Directory temp = (Directory) currDirectory;
		boolean notFound = true;
		if(newDir.equals("/")) {
			notFound=false;
			temp=(Directory) root;
			currDirectory = temp;
		}
		else if(newDir.equals("..")){
			notFound=false;
			temp=(Directory) temp.parent;
			currDirectory=temp;
		}else{
			for(int i=0;i<temp.myDirectories.size();i++) {
				if(temp.myDirectories.get(i).name.equals(newDir)) {
					notFound=false;
					temp=temp.myDirectories.get(i);
					currDirectory=temp;
				}
			}
		}
		if(notFound){
				System.out.println("ERROR: Directory not found");
		}
	}
	//called by "pwd" and "find" commands
	public ArrayList<String> getPathtoDir(NonBinaryNode dirName) {
		NonBinaryNode tempDirectory = dirName;
		ArrayList<String> dirPathList = new ArrayList<>();
		while(tempDirectory!=root) {
			dirPathList.add(tempDirectory.name);
			tempDirectory=tempDirectory.getParentDir();
		}
		ArrayList<String> myAnswer = new ArrayList<String>();
		for(int i=dirPathList.size()-1;i>=0;i--) {
			myAnswer.add(dirPathList.get(i));
		}
		return myAnswer;
	}
	//to check whether current directory contains directory or file with given name
	public boolean containsDir(String dirName) {
			for(int i=0; i<currDirectory.myDirectories.size(); i++) {
				if(currDirectory.myDirectories.get(i).name.equals(dirName)) {
					return true;
				}
			}
			return false;
	}
	
	public boolean containsF(String fileName) {
		for(int i=0; i<currDirectory.myFiles.size(); i++) {
			if(currDirectory.myFiles.get(i).name.equals(fileName)) {
				return true;
			}
		}
		return false;
	}
	//Called by "find" command. Uses recursion.
	public ArrayList<NonBinaryNode> find(NonBinaryNode currDirinput, String nameToFind){
		ArrayList<NonBinaryNode> foundList = new ArrayList<>();
		if (currDirinput.name.equals(nameToFind)) {
			foundList.add(currDirinput);//if the name of current directory is the name we are trying to find
		}
		for(int i=0; i< currDirinput.myChildren.size(); i++) {//loops through all children of the current directory
			if(currDirinput.myChildren.get(i).isFile) {//if the child is a file
				if(currDirinput.myChildren.get(i).name.equals(nameToFind)) {
					foundList.add(currDirinput.myChildren.get(i));
				}
			}else{
				foundList.addAll(find(currDirinput.myChildren.get(i), nameToFind));//recursive call
			}
		}
		return foundList;
	}
	//called by "du"
	public int du(NonBinaryNode n){
		int sum=0;
		for(int i=0; i< n.myChildren.size(); i++) {
			if(n.myChildren.get(i).isFile) {
				String myFileString = n.myChildren.get(i).getFileContent();
				sum+=myFileString.length();
			}else {
				sum+=du(n.myChildren.get(i));//recursive call
			}
		}
		return sum;
	}
}

public class FileSys {
	
	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		NonBinaryTree myDirTree = new NonBinaryTree();//building a new tree that is going to store files and directories
		
		while(true) {
			System.out.print("prompt> ");
			String[] input = scanner1.nextLine().split(" ");
			
			if(input[0] == ""){//if user hits enter
				continue;
			}
			//exit
			if(input[0].equals("exit")) {
				System.exit(0);
				scanner1.close();
			}
			
			//create
			if(input[0].equals("create")) {
				if(input.length==1) {
					System.out.println("ERROR: Need a File name.");
				}
				
				String fileName = input[1];
				
				if(myDirTree.containsF(fileName)){
					System.out.println("ERROR: File with the same name already exists in the current directory.");
				}else if(myDirTree.containsDir(fileName)) {
					System.out.println("ERROR: Directory with the same name already exists in the current directory.");
				}else{
					File myFile = new File(fileName, myDirTree.currDirectory);//create a new file and add it to the current directory
					myDirTree.addFile(myFile);
					while(scanner1.hasNextLine()) {
						String lineTowrite = scanner1.nextLine();
						if(lineTowrite.contains("~")) {//write to the file until ~
							for(int i=0;i<lineTowrite.length();i++) {
								if(lineTowrite.charAt(i)!='~') {
									myFile.write(Character.toString(lineTowrite.charAt(i)));
								}else{
									break;
								}
							}break;
							
						}else{
							for(int i=0;i<lineTowrite.length();i++) {
									myFile.write(Character.toString(lineTowrite.charAt(i)));
							}
						}
						myFile.write("\n");//for new line
					}
				}
				
			//cat
			}else if(input[0].equals("cat")) {
				if(input.length==1) {
					System.out.println("ERROR: Need a File name");
				}
				String fileName = input[1];
				if(!myDirTree.containsF(fileName)){
					System.out.println("ERROR: File with this name not found in the current directory.");
				}else if(myDirTree.containsDir(fileName)) {
					System.out.println("ERROR: Directory with the same name already exists in the current directory.");
				}else{
					for(int i=0;i<myDirTree.currDirectory.myFiles.size();i++) {
						if(myDirTree.currDirectory.myFiles.get(i).name.equals(fileName)) {
							System.out.println(myDirTree.currDirectory.myFiles.get(i).getFileContent());
							continue;
						}
					}
				}
				
			//rm	
			}else if(input[0].equals("rm")) {
				
				if(input.length==1) {
					System.out.println("ERROR: Need a File name");
				}
				String fileName=input[1];
				if(!myDirTree.containsF(fileName)){
					System.out.println("ERROR: File with this name not found in the current directory.");
				}else if(myDirTree.containsDir(fileName)) {
					System.out.println("ERROR: Directory with the same name already exists in the current directory.");
				}else{
					myDirTree.currDirectory.removeF(fileName);
				}
				
			//mkdir
			}else if(input[0].equals("mkdir")) {
				if(input.length==1) {
					System.out.println("ERROR: Need a File directory");
				}
				String dirName = input[1];
				if(myDirTree.containsF(dirName)){
					System.out.println("ERROR: File with the same name already exists in the current directory.");
				}else if(myDirTree.containsDir(dirName)) {
					System.out.println("ERROR: Directory with the same name already exists in the current directory.");
				}else{
					Directory myDirectory=new Directory(dirName, myDirTree.currDirectory);
					myDirTree.addDirectory(myDirectory);
				}
			
			//rmdir
			}else if(input[0].equals("rmdir")) {
				
				if(input.length==1) {
					System.out.println("ERROR: Need a File directory");
				}
				String dirName=input[1];
				if(myDirTree.containsF(dirName)){
					System.out.println("ERROR: File with this name already exists in the current directory.");
				}else if(!myDirTree.containsDir(dirName)) {
					System.out.println("ERROR: Directory with this name not found in the current directory.");
				}else{
					myDirTree.currDirectory.removeDir(dirName);
				}
				
			//cd
			}else if(input[0].equals("cd")) {
				if(input.length==1) {
					System.out.println("ERROR: Need a File directory");
				}
				if(input[1].charAt(0)=='/') {
					if(input[1].length()==1) {
						myDirTree.changeDir("/");//if "start at root"
					}else {
						myDirTree.changeDir("/");
						String[] dirPath = input[1].split("/");
						for(int i=1;i<dirPath.length;i++) {
							myDirTree.changeDir(dirPath[i]);
						}
					}
				}else {
				String[] dirPath = input[1].split("/");
				for(String s: dirPath) {
					myDirTree.changeDir(s);
				}
				}
			
			//ls
			}else if(input[0].equals("ls")) {
				ArrayList<String> myList = new ArrayList<>();
				for(int i=0;i<myDirTree.currDirectory.myDirectories.size();i++) {
					myList.add(myDirTree.currDirectory.myDirectories.get(i).name + "(*)");
				}
				for(int j=0;j<myDirTree.currDirectory.myFiles.size();j++) {
					myList.add(myDirTree.currDirectory.myFiles.get(j).name);
				}
				Collections.sort(myList);//list in alphabetical order
				for(String s: myList) {
					System.out.println(s);
				}
			
			//du
			}else if(input[0].equals("du")) {
			System.out.println(myDirTree.du(myDirTree.currDirectory));
			
			//pwd
			}else if(input[0].equals("pwd")) {
				if(myDirTree.currDirectory==myDirTree.root) {
					System.out.println("/");
				}else {
					ArrayList<String> myDirPath = myDirTree.getPathtoDir(myDirTree.currDirectory);
					System.out.print("/");
					for(int i=0;i<myDirPath.size()-1;i++) {
						System.out.print(myDirPath.get(i)+"/");
					}
					System.out.println(myDirPath.get(myDirPath.size()-1));//for the last item;
				}
				
			//find
			}else if(input[0].equals("find")) {
				if(input.length==1) {
					System.out.println("ERROR: Need a name");
				}
				String nameToFind = input[1];
				ArrayList<NonBinaryNode> listOfFoundNames = myDirTree.find(myDirTree.currDirectory, nameToFind);
				for(int i=0;i<listOfFoundNames.size();i++) {
					ArrayList<String> myDirPath = myDirTree.getPathtoDir(listOfFoundNames.get(i));
					System.out.print("/");
					for(int j=0;j<myDirPath.size()-1;j++) {
						System.out.print(myDirPath.get(j)+"/");
					}
					System.out.println(myDirPath.get(myDirPath.size()-1));//for the last item;
				}
				
				
			}else{
					System.out.println("ERROR: wrong input");
			}
			
			
		}
	}

}
