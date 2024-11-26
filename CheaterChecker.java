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
                break;

        }
	
	while (start) {
    	ArrayList<String> ignoredList = new ArrayList<>();
            System.out.println("Choose elements to check and type end when finished: ");
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
    		
            ComparisonResult file1 = new ComparisonResult(filePath1); // file you're checking for plagarism
            ComparisonResult file2 = new ComparisonResult(filePath2); // file you're basing claim on
            
            double score = file1.calculatePlagiarism(file2, ignoredList); // getting score
            
            // created file to input all results
            try {
                FileWriter results = new FileWriter("Results.txt");
                results.write("The plagiarism score is: " + score + "%\n");
                
                if (score > 70) {
                    results.write("This is plagiarised!!!"); // flagging files for plagiarism
                } else {
                     results.write("This work is not plagiarised");
                }
                
                results.write("\n");
                results.write(file1.sortElements().toString());
                results.write("\n");
                results.write(file2.sortElements().toString());
                
                results.close();
                System.out.println("Successfully calculated plagiarism score.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            
            start = false;
        }
	}
}
