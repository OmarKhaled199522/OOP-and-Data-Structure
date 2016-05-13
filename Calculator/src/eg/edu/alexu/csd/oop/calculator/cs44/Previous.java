package eg.edu.alexu.csd.oop.calculator.cs44;

public class Previous {
	
	private Previous(){
		
	}
	
	public static Previous prevInsance = new Previous();
	
	public static Previous getInctance(){
		return prevInsance;
	}
	
	public static void destoryInstance(){
        prevInsance = null;
   }
	
	
	String pre ( String [] arr, int con ){
		
		if(con - 2 < 0) return null;
		else {
			con -= 2;
			return arr[ con++ ];
		}
		
	}

}
