import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
public class Kiosk {
	//private static ArrayList<String> lst=new ArrayList<>();
	private static String dirPath="C:\\Users\\pawan\\eclipse-workspace\\Simplilearn1\\src\\demoDir";
	public static void addFile()   {
		System.out.println("Enter file Name to add the file");
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		File fileWithAbsolutePath = new File(dirPath + "/"+s+".txt");

		if(fileWithAbsolutePath.exists()) {
			System.out.println("file with the given name already exists");
			keyRepository();
			
		}
		else {
		//File.touch(fileWithAbsolutePath);
			try {
			fileWithAbsolutePath.createNewFile();
			}
			catch(Exception e) {}
		//assertTrue(fileWithAbsolutePath.exists());
		System.out.println("File Added Successfully");
		keyRepository();
		}
	}
	public static void deleteFile() {
		System.out.println("Enter file Name to Delete");
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		File file
        = new File(dirPath+"/"+s+".txt");

    if (file.delete()) {
        System.out.println("File deleted successfully");
    }
    else {
        System.out.println("Failed to delete the file");
        System.out.println("FileNot found");
		keyRepository();
    }
		

	}
	public static void searchFile() {
		System.out.println("Enter file Name to Search");
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		File directory=new File(dirPath);
		int fileCount=directory.list().length;
	    System.out.println("File Count:"+fileCount);
	  //List of all files and directories
	    String contents[] = directory.list();
		for(String str: contents) {
			if(str.equals(s)) {
				System.out.println("File "+ s +" found");
				keyRepository();
			}
		}
		System.out.println("FileNot found");
		keyRepository();

	}
	
	public static void keyRepository() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Choose a Operation");
		System.out.println("1. Add a File");
		System.out.println("2. Delete a File");
		System.out.println("3. Search a File");
		int input= sc.nextInt();
		if(input==1) {
			addFile();
		}
		else if(input==2){
			deleteFile();
		}
		else {
			searchFile();
		}
	}
	
	public static void showFiles() {
		File directory=new File(dirPath);
		int fileCount=directory.list().length;
	    System.out.println("File Count:"+fileCount);
	  //List of all files and directories
	      String contents[] = directory.list();
	      Arrays.sort(contents);
	      System.out.println("List of files and directories in the specified directory:");
	      for(int i=0; i<contents.length; i++) {
	         System.out.println(contents[i]);
	      }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Company Lockers Pvt Ltd");
		showFiles();
		keyRepository();
		

	}

}
