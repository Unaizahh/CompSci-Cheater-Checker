import java.util.*;
import java.io.*;

public class ComparisonResult{
    
    private String name;
    
    public ComparisonResult(String name) {
        this.name = name;
    }

    public ArrayList<String> sortElements() {
        
            // Get each line of file in a list
    		ArrayList<String> lines = new ArrayList<>();
    		
    		try { //testing reading one file 
    		    File myFile = new File(this.name);
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
    	   
    	   return lines;

		}
		
        // Seperate all the characters in the file into a list
    
    
   /* public  compare(ComparisonResult list, ArrayList<String> ignores) {

        System.out.println("Compare the two elemenet lists (call the first method on the parameter list object), as well, don't add to sum if characters are in ignore list");
    } */

}
