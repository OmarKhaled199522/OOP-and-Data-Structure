package eg.edu.alexu.csd.oop.calculator.cs44;

import javax.management.RuntimeErrorException;

public class Read {

	public double number1;
	public double number2;
	public boolean adi = false;
	public boolean sub = false;
	public boolean divi = false;
	public boolean multy = false;
	
	
	private Read(){
		
	}
	
	public static Read readInstance = new Read();
	
	public static  Read getInctance(){
		return readInstance;
	}
	
	public static void destoryInstance(){
       readInstance = null;
   }
	
	void  check_valid(String s) throws Exception{
		
		
		String c = "";
		int con = -1;
		
		for(int i = 0; i < s.length() && !s.equals(""); i++){
			
			if(s.charAt(i) >= '0' && s.charAt(i) <= '9') c += s.charAt(i);
			else {
				if(c.equals("")) throw new RuntimeErrorException(null);
				number1 = Double.valueOf(c);
				con++;
				if(con == 0){
					if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/');
					else throw new Exception();
					
					if(s.charAt(i) == '+'){
						adi = true;
						sub = false;
						divi = false;
						multy = false;
						
						
					} else if (s.charAt(i) == '-'){
						
						adi = false;
						sub = true;
						divi = false;
						multy = false;
						
					} else if (s.charAt(i) == '/'){
						
						adi = false;
						sub = false;
						divi = true;
						multy = true;
					
					} else if (s.charAt(i) == '*'){
						
						adi = false;
						sub = false;
						divi = false;
						multy = true;
						
					}
			
				} else if (con == 1){
					throw new Exception();
				}
				c = "";
			}
		}
		if(c.equals("")) throw new Exception();
		number2 = Double.valueOf(c);
		if(divi == true && number2 == 0) throw new Exception();
		
	}
	
	
	public void take(String s){
		
		Programme c = Programme.getInctance();
		c.input(s);
	}
	
	
	
	
	
	
}
