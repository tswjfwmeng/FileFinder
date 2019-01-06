import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class FileFinder{
	
	public FileFinder(){
		
	}
	
	public String findFile() {
			System.out.println("(Type 'exit' to terminate the app)");
			System.out.println("Enter file path");
			
			Scanner scan = new Scanner(System.in);
			String nameOfFile = scan.next();
			
			switch(nameOfFile) {
			case "exit":
				System.out.println("You have exited");
				scan.close();
				return nameOfFile;
			}
			
			File file = new File(nameOfFile);
			
			if (file.exists()) {
				if (file.isDirectory()) {
					System.out.println("target '" + nameOfFile +"' is a directory");
					System.out.println(file.getAbsolutePath());
					System.out.println("Would you like to see files in directory?");

					String yesNo = scan.next();
					switch (yesNo) {
					case "y":
					case "yes":
						System.out.print(Arrays.toString(file.list()));
						break;
					case "n":
					case "no":
						break;
					case "exit":
						System.out.println("You have exited");
						scan.close();
						return nameOfFile;
					}
				} else {
					System.out.println("target is a file");
					System.out.println(file.getAbsolutePath());
				}
				file.getName();
			} else {
				System.out.println("file does not exist");
			}
			
			findFile();
			
			scan.close();
			return nameOfFile;
	}	
}
