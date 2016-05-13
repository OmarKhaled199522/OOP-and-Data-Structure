package eg.edu.alexu.csd.oop.calculator.cs44;

public class Calculation {

	public double number1;
	public double number2;
	public double res;
	
	boolean adi = false;
	boolean sub = false;
	boolean divi = false;
	boolean multy = false;
	
	private Calculation() {
		
	}
	
	public static Calculation calculationInsance = new Calculation();
	
	public static Calculation getInctance(){
		return calculationInsance;
	}
	
	public static void destoryInstance(){
        calculationInsance = null;
   }
	
	Read e = Read.getInctance();
	
	double get_result(String s) throws Exception{
		
		e.check_valid(s);
		
		if(e.adi) res = e.number1 + e.number2;
		else if (e.sub) res = e.number1 - e.number2;
		else if (e.divi) {
			
			if(number2 == 0) throw new Exception(); 
			res = e.number1 / e.number2;
		}
		else if (e.multy) res =e. number1 * e.number2;
		
		return res;
		
	}
	
}
