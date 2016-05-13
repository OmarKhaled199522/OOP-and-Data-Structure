package eg.edu.alexu.csd.oop.calculator.cs44;

public class Next {
	
	
	private Next(){
		
	}
	
public static Next nextInsance = new Next();
	
	public static Next getInctance(){
		return nextInsance;
	}
	
	public static void destoryInstance(){
        nextInsance = null;
   }
	
	String folo ( String [] arr, int con ){
		
		Object check = arr[con];
		if(check == null) return null;
		else return arr[con];
		
	}
}