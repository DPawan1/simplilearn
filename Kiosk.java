import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
 class FileExecutor {
	//private static ArrayList<String> lst=new ArrayList<>();
	private String dirPath="C:\\Users\\pawan\\eclipse-workspace\\Simplilearn1\\src\\demoDir";
	public void addFile()   {
		System.out.println("Enter file Name to add the file");
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		File fileWithAbsolutePath = new File(dirPath + "/"+s+".txt");

		if(fileWithAbsolutePath.exists()) {
			System.out.println("file with the given name already exists");
			//sc.close();
			keyRepository();
			
		}
		else {
		//File.touch(fileWithAbsolutePath);
			try {
			fileWithAbsolutePath.createNewFile();
			//sc.close();
			}
			catch(Exception e) {
				System.out.println("file with the given name already exists");
			}
		//assertTrue(fileWithAbsolutePath.exists());
		System.out.println("File Added Successfully");
		keyRepository();
		}
	}
	public void deleteFile() {
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
	public void searchFile() {
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
				//sc.close();
				keyRepository();
				
			}
		}
		System.out.println("FileNot found");
		//sc.close();
		keyRepository();

	}
	
	public void keyRepository() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Choose a Operation");
		System.out.println("1. Add a File");
		System.out.println("2. Delete a File");
		System.out.println("3. Search a File");
		int input= sc.nextInt();
		//sc.close();
		if(input==1) {
			this.addFile();
		}
		else if(input==2){
			deleteFile();
		}
		else {
			searchFile();
		}
		
	}
	
	public void showFiles() {
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

	

}
public class Kiosk{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Company Lockers Pvt Ltd");
		FileExecutor bob = new FileExecutor();
		bob.showFiles();
		bob.keyRepository();
		
	}
}
