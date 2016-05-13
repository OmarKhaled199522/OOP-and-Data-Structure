package eg.edu.alexu.csd.oop.calculator.cs44;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Save {

	
	private Save(){
		
	}
	
	public static Save saveInsance = new Save();
	
	public static Save getInctance(){
		return saveInsance;
	}
	
	public static void destoryInstance(){
        saveInsance = null;
   }
	
	
	void store(String arr[] , int counter){
	
		Writer writer = null;
	
		try {
			new FileOutputStream("omar.txt").close();
		} catch (IOException e) {
		}
		
		try {
		    //writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("omar.txt"), "utf-8" ));
		    
			writer = new BufferedWriter(new FileWriter("omar.txt", false ));
			
		    for(int i = Math.max(0 , counter - 5) ; i < counter; i++){
		    	writer.write(arr[i]);
		    	writer.write("\r\n");
		    }
		    
		} catch (IOException ex) {
		  
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
	
	}
}
