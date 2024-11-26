import java.util.*;
import java.io.*;
import java.lang.Iterable;

public class ComparisonResult{
    
    private String name;
    ArrayList<String> elements;
    
    public ComparisonResult(String name) {
        this.name = name;
    }

    public ArrayList<String> sortElements() {
        
            // Get each line of file in a list
    		ArrayList<String> lines = new ArrayList<>();
    		ArrayList<String> separatedLines = new ArrayList<>();
    		this.elements = new ArrayList<>();
    		
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
            
            /*System.out.println("The contents of the file are: " + lines + "\n\n");
            System.out.println("Characters: " + elements + "\n\n");*/
    	   
    	   return elements;

		}
		
    
   public double calculatePlagarism(ComparisonResult obj, ArrayList<String> ignores) {

        ArrayList<String> list1 = this.sortElements(); // elements of one file
        ArrayList<String> list2 = obj.sortElements(); // elements of other files
        double oops = 0; // plagirism counter
        int total = list1.size() + list2.size(); // total number of elements for calculations
        
        int limit =  list1.size() > list2.size()? list1.size(): list2.size(); // setting limit for iterating based on larger file
        
        for (int i = 0; i < limit; i++) {
            if (!ignores.contains(list1.get(i)) & !ignores.contains(list2.get(i))) // ingores chosen elements in the list{ 
                if (list1.get(i).equals(list2.get(i))) {
                    if (list1.get(i).equals("i") || list1.get(i).equals("j") || list1.get(i).equals("n")) { // small weights on generally commonly used letters
                        oops++;
                    } else if (list1.get(i).equals(";") || list1.get(i).equals("{") || list1.get(i).equals("}")){ // built-in ignoring very common elements
                        oops+=0; 
                    } else if (list1.get(i).equals("x") ||list1.get(i).equals("k") || list1.get(i).equals("w") || list1.get(i).equals("i")) { // medium weights on lesser used letters
                        oops+=3;
                    } else if (list1.get(i).equals(0) || list1.get(i).equals(1) || list1.get(i).equals(2) ||  list1.get(i).equals(3) || list1.get(i).equals(4) || list1.get(i).equals(5) || list1.get(i).equals(6) || list1.get(i).equals(7) || list1.get(i).equals(8) || list1.get(i).equals(9)) {
                        oops+=8; // heavy weights on numbrs
                    } else if (list1.get(i).equals("<") || list1.get(i).equals(">") || list1.get(i).equals("&")) {
                        oops+= 4; // medium-low weights on compound statement symbols
                    } else {
                        oops += 2; // low-medium weights on other symbols and letters
                    }
                
            }
        }  
        
        double percent = oops/total * 100;
        
        return percent;

    }   

}
