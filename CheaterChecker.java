import java.util.*;
import java.io.*;


public class CheaterChecker
{
	static Scanner options = new Scanner(System.in);
	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		String filePath1 = "SumOfMultiples1.txt";
		String filePath2 = "SumOfMultiples2.txt";
		
		Boolean start = false;

		//make list dynamic 
		ArrayList<String> files = new ArrayList<>();

	System.out.println("press p to begin cheater checking...");
        String menu = options.nextLine();


        switch (menu) {
            case "p":
                System.out.println("Enter File Name One: ");
                boolean valid = false;
               while (!valid) {
                    try {
                        filePath1 = options.nextLine();
                        files.add(filePath1);
                        
                        if (files.contains(filePath1)) {
                            System.out.println("Enter File Name Two: ");
                            
                            filePath2 = options.nextLine();
                            files.add(filePath2);
                            
                            if (files.contains(filePath2)) {
                                valid = true;
                                start = true;
                            }
                        } else {
                            System.out.println("Try Again");
                        }
                        
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid answer.");
                        options.next();
                    }
                }
                
                break;
                
            default:
                System.out.println("Invalid choice. Please try again.");
                //menu();
                break;

        }
	
	while (start) {
    	ArrayList<String> ignoredList = new ArrayList<>();
            System.out.println("Choose elements to check: ");
            boolean ignored = false;
            String ignore = "";
                     while (!ignored){
                         try{
                             ignore = scanner.nextLine();
                             ignoredList.add(ignore);
                                if (ignore.equals("end")){
                                    ignored = true;
                                }
                         }
                          catch (InputMismatchException e) {
                            System.out.println("Please enter a valid answer.");
                            scanner.next();
                        }
                 
                     }
    		
            ComparisonResult file1 = new ComparisonResult(filePath1); // file your checking for plagarism
            ComparisonResult file2 = new ComparisonResult(filePath2); // file your basing claim on
            
            System.out.println(file1.calculatePlagarism(file2, ignoredList));
            
            start = false;
        }
	}
}
