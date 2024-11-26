import java.util.*;
import java.io.*;


public class CheaterChecker
{
	static Scanner options = new Scanner(System.in);
	
	public static void main(String[] args) {
		String filePath1 = "SumOfMultiples1.txt";
		String filePath2 = "SumOfMultiples2.txt";
		

		//make list dynamic 
		ArrayList<String> files = new ArrayList<>();

	System.out.println("press P to begin cheater checking...");
        String menu = options.nextLine();


        switch (menu) {
            case "P":
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
                                System.out.println("Press C to continue... ");
                                valid = true;
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
                
             case "C": 
                 System.out.println("Choose an element to check: ");
		break;
			
            default:
                System.out.println("Invalid choice. Please try again.");
                //menu();
                break;

        }
 
        ComparisonResult test = new ComparisonResult("SumOfMultiples1.txt");
        test.sortElements();
		
	}
}
