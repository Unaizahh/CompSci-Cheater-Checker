import java.util.*;
import java.io.*;


public class CheaterChecker
{
	public static void main(String[] args) {
		String filePath1 = "SumOfMultiples1.txt";
		String filePath2 = "SumOfMultiples2.txt";
		String filePath3 = "SumOfMultiples3.txt";
		
		//make list dynamic 
		ArrayList<String> files = new ArrayList<>();
		
		files.add(filePath1);
		files.add(filePath2);
		files.add(filePath3);

		for (int filePath = 0; filePath < files.size(); filePath++) {
    		ArrayList<String> lines = new ArrayList<>();
    		
    		try { //testing reading one file 
    		    File myFile = new File(files.get(filePath));
    		    Scanner scanner = new Scanner(myFile);
    
            if (myFile.exists()) {
                    System.out.println("File name: " + myFile.getName());
                    //System.out.println("File size in bytes " + myFile.length());
                } 
                else {
                    System.out.println("The file does not exist.");
                }
                
            if(!scanner.hasNext()==true){
                    System.out.println("Error: File is empty");
                }
                
            while(scanner.hasNextLine()) {
                
                String line = scanner.nextLine();
                lines.add(line);
            }
            
            scanner.close();
    
    		}
    		catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Error parsing year: " + e.getMessage());
            }
            
            System.out.println("The contents of the file are: " + lines + "\n\n");
    		
    		for (String line : lines) {
    		    System.out.println(line);
    		}
		
		}
		
	}
}
