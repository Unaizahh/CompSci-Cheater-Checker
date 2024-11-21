import java.util.*;
import java.io.*;


public class CheaterChecker
{
	public static void main(String[] args) {
		String filePath1 = "SumOfMultiples1.txt";
		String filePath2 = "SumOfMultiples2.txt";
		

		//make list dynamic 
		ArrayList<String> files = new ArrayList<>();

		files.add(filePath1);
		files.add(filePath2);
        
        ComparisonResult test = new ComparisonResult("SumOfMultiples1.txt");
        test.sortElements();
		
	}
}
