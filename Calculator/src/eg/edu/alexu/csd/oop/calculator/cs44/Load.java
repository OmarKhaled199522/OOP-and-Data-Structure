package eg.edu.alexu.csd.oop.calculator.cs44;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Load {
	
	public int counter = 0;
	
	private Load(){
		
	}
	
	public static Load loadInsance = new Load();
	
	public static Load getInctance(){
		return loadInsance;
	}
	
	public static void destoryInstance(){
        loadInsance = null;
   }
	
	
	void read(String arr []){
		
		
		counter = 0;
		File dic = new File("omar.txt");
		
		Scanner fileReader = null;
		
		try {
			fileReader = new Scanner(dic);
		} catch (FileNotFoundException e) {
			
		}
		
		while(fileReader.hasNext()){
			arr[counter] = fileReader.next();
			counter ++;
		}
		fileReader.close();		
	}
		
		
}
