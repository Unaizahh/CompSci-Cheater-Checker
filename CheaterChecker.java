import java.util.*;
import java.io.*;


public class CheaterChecker
{
	static Scanner options = new Scanner(System.in);
	static Scanner scanner = new Scanner(System.in);
	
    //Coloured Text
    static String RED = "\u001B[31m";
    static String YELLOW = "\u001B[33m";
    static String MAGENTA = "\u001B[35m";
    static String BLUE = "\u001B[34m";
    static String RESET = "\u001B[0m";
    static String BOLD = "\n\033[0;1m";
    static String UNBOLD = "\033[0;0m";
    
	
	public static void main(String[] args) {
		String filePath1 = "SumOfMultiples1.txt";
		String filePath2 = "SumOfMultiples2.txt";
		
		Boolean start = false;

		//make list dynamic 
		ArrayList<String> files = new ArrayList<>();

	//user starts cheater checker
	System.out.println(BOLD + "Press \"p\" to begin cheater checking...");
        String menu = options.nextLine();

        switch (menu) {
            case "p": //user chooses which files to compare
                System.out.println(BOLD + BLUE + "\nEnter File Name One: " + UNBOLD);
                boolean valid = false;
               while (!valid) {
                    try {
                        filePath1 = options.nextLine();
                        files.add(filePath1);
                        
                        if (files.contains(filePath1)) {
                            System.out.println(BOLD + BLUE + "\nEnter File Name Two: " + UNBOLD);
                            
                            filePath2 = options.nextLine();
                            files.add(filePath2);
                            
                            if (files.contains(filePath2)) {
                                valid = true;
                                start = true; //lets user pick elements after choosing the files
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
	
	while (start) { // lets user choose which elements to ignore
    	ArrayList<String> ignoredList = new ArrayList<>();
            System.out.println(BOLD + MAGENTA + "\nChoose elements to check and type \"end\" when finished: " + UNBOLD + RESET);
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
                    results.write("----------------\n\nThis is plagiarised!!!"); // flagging files for plagiarism
                } else {
                     results.write("--------------------------\n\nThis work is not plagiarised!");
                }
                
                results.write("\n");
                results.write(file1.sortElements().toString());
                results.write("\n");
                results.write(file2.sortElements().toString());
                
                results.close();
                System.out.println(BOLD + YELLOW + "\nSuccessfully calculated plagiarism score." + RESET + UNBOLD);
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            
            start = false;
        }
	}
}
