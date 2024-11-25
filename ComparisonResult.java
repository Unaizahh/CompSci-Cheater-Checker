import java.util.*;
import java.io.*;
import java.lang.Iterable;

public class ComparisonResult{
    
    private String name;
    
    public ComparisonResult(String name) {
        this.name = name;
    }

    public ArrayList<String> sortElements() {
        
            // Get each line of file in a list
    		ArrayList<String> lines = new ArrayList<>();
    		ArrayList<String> separatedLines = new ArrayList<>();
    		ArrayList<String> elements = new ArrayList<>();
    		
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
            
            // add spaces between characters in each string
            for (String str : lines) {
                StringBuilder separated = new StringBuilder();

                for (char c : str.toCharArray()) {
                    separated.append(c).append(" ");
                }
                
                separatedLines.add(separated.toString().trim());
            }
            
            // Creating list of individual characters
            for (String a : separatedLines) {
                for (char b : a.toCharArray()) {
                    elements.add(Character.toString(b));
			elements.remove(" ");
                }
            }
            
            System.out.println("The contents of the file are: " + lines + "\n\n");
            System.out.println("Characters: " + elements + "\n\n");
    	   
    	   return elements;

		}
		
    
   /* public  compare(ComparisonResult list, ArrayList<String> ignores) {

        System.out.println("Compare the two elemenet lists (call the first method on the parameter list object), as well, don't add to sum if characters are in ignore list");
    } */

}
