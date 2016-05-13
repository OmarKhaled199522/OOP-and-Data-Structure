package eg.edu.alexu.csd.ds.stack.cs44;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		int num1 = 0, num2 = 0, found = 0;
		
		
		while(true){
			
			System.out.println("Enter any valid expression without spaces\n"
					+ "Don't enter unary operators\nEnter -1 to exit");
			String s = input.nextLine();
			if(s.equals("-1")) break;
			
		for(int i = 0; i < s.length(); i++){
			
			if(s.charAt(i) != '-' && s.charAt(i) != '+' && s.charAt(i) != '*' && s.charAt(i) != '/' 
					&& s.charAt(i) != '^' && s.charAt(i) != '%' && s.charAt(i) != ')' && s.charAt(i) != '('
					&& !Character.isDigit( s.charAt(i) )){
				
				found = 1;
				break;
				
			}
			
			
			if(s.charAt(0) == '-' || s.charAt(0) == '+' || s.charAt(0) == '*' || s.charAt(0) == '/' 
					|| s.charAt(0) == '^' || s.charAt(0) == '%' || s.charAt(0) == ')'){
				
				found = 1;
				break;
				
			} else  if(s.charAt(s.length() - 1) == '-' || s.charAt(s.length() - 1) == '+' || s.charAt(s.length() - 1) == '*' || s.charAt(s.length() - 1) == '/' 
					|| s.charAt(s.length() - 1) == '^' || s.charAt(s.length() - 1) == '%' || s.charAt(s.length() - 1) == '('){
				
				found = 1;
				break;
				
			} else if (i != 0 && i != s.length() - 1){
				if(!Character.isDigit( s.charAt(i)  )  && !Character.isDigit( s.charAt(i + 1)  ) && s.charAt(i) != ')' && s.charAt(i) != '(' && s.charAt(i + 1) != ')' && s.charAt(i + 1) != '('){
					found = 1;
					break;
				}
				
				if(s.charAt(i) == '/' && s.charAt(i + 1) == '0') {
					found = 1;
					break;
				}
			}
			
			if(i < s.length() - 2){
				if(s.charAt(i) == '0' && s.charAt(i + 1) == '^' && s.charAt(i + 2) == '0') {
					found = 1;
					break;
				}
			}
			
			
			if(s.charAt(i) == '(') num1++;
			else if (s.charAt(i) == ')') num2++;
			if(num2 > num1){
				found = 1;
				break;
			}
		}
		
		if(found == 1){
			System.out.println("Invalid input!!!!!!!!!!!");
			
		} else {
			App a = new App();
			String g = a.convert_to_postfix(s);
			System.out.println("PostFix = " + g);
			double out = a.ans(g);
			if(a.getInvalid() == 0){
				System.out.println("Result = " + out);
				
			} else a.setInvalid(0);
			
		}
		
	}
		
		input.close();
		
	}

}
