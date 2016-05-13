package eg.edu.alexu.csd.oop.calculator.cs44;


public class Programme implements Calculator {

	public double number1;
	public double number2;
	public double res;
	public int counter = 0;
	
	boolean adi = false;
	boolean sub = false;
	boolean divi = false;
	boolean multy = false;
	boolean no_next = false;
	boolean sav = false;
	boolean lod = false;
	int upper = 0;
	
	public String in = "";
	public String ss = "";
	
	String arr [] = new String [100000 + 10];
	
	Read r = Read.getInctance();
	Calculation cal = Calculation.getInctance();
	
	Previous p = Previous.getInctance();
	Next n = Next.getInctance();
	Load l = Load.getInctance();
	Save s = Save.getInctance();
	
	private Programme(){
		
	}
	
	public static Programme programmeInsance = new Programme();
	
	public static Programme getInctance(){
		return programmeInsance;
	}
	
	public static void destoryInstance(){
        programmeInsance = null;
   }
	
	
	
	@Override
	public void input(String s) {
		in = s;
		
		try {
			res =  cal.get_result(in);
			arr[counter++] = in;
			no_next = true;
			upper = counter - 1;	
			
		} catch (Exception e) {
			//throw new RuntimeException();
		}
		
	}

	@Override
	public String getResult() {
		
		return Double.toString(res);
	}

	@Override
	public String current() {
		return arr[counter - 1];
	}

	@Override
	public String prev() {
		
		String w = p.pre(arr, counter);
		if(w != null) counter--;
		no_next = false;
		return w;
	}

	@Override
	public String next() {
		
		if(counter > upper) return null;
		String w = n.folo(arr, counter);
		if(w != null) counter++;
		return w;
	}

	@Override
	public void save() {
		s.store(arr, counter);
		sav = true;
	}

	@Override
	public void load() {
	
		if(!sav){
			
			try {
				throw new RuntimeException();
			} catch (Exception e) {
				
				System.out.println("There is no saved file");
				throw new RuntimeException();
			}
			
		} else {
		
		
			l.read(arr);
			counter = l.counter;
			upper = counter - 1;
		
		}
	}
	
	
}
