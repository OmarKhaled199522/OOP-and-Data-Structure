package eg.edu.alexu.csd.ds.stack.cs44;

public class App {

	private MyStack l = new Single_LinkedList();
	private int invalid = 0;
	
	public double ans (String postfix){
		
		double res = 0;
		for(int i = 0; i < postfix.length(); i++){
			
			char seq = postfix.charAt(i);
			if(seq != ' '){
			if( Character.isDigit ( seq ) ){
				
				String e = "";
				e+= seq;
				if(i != postfix.length() - 1){
					while(Character.isDigit( postfix.charAt(i + 1) )){
						e += postfix.charAt(i + 1);
						i++;
						if(i == postfix.length() - 1) break;
					}
					double dig = Double.parseDouble(e);
					l.push(dig);
				}
				
			} else {
				double second = (double)l.pop();
				double first = (double) l.pop();
				
				
				if(seq == '+') 		 res = first + second;
				else if (seq == '-') res = first - second;
				else if (seq == '*') res = first * second;
				else if (seq == '/') {if(second != 0)res = first / second;
									else{System.out.println("Invalid input");invalid = 1; return 0; } 
				}else if (seq == '%') res = first % second;
				else if (seq == '^') {if (first == 0 && second == 0){
										System.out.println("Invalid input");
										invalid = 1;
										return 0;
									}else res = Math.pow(first, second);
				}
				l.push(res);
			}
		}
		}
		return (double)l.pop();
	}
	
	public int getInvalid() {
		return invalid;
	}

	public void setInvalid(int invalid) {
		this.invalid = invalid;
	}

	public String convert_to_postfix(String infix){
		
		String post_fix = "";
		
		for(int i = 0; i < infix.length(); i++){
			
			char seq = infix.charAt(i);
			
			if(seq == '('){
				l.push('(');
				
			} else if (seq == ')'){
				
				while(! l.isEmpty() &&  (char)l.peek() != '('){
					
					post_fix += l.pop() + " ";
				}
				l.pop();
				
			} else if (seq == '^'){
				l.push('^');
				
			} else if (seq == '*' || seq == '/' || seq == '%'){
				
				if( l.isEmpty()){
					
					l.push(seq);
					
				} else if ( (char)l.peek() == '('){ 
					l.push(seq);
				
				
				} else {
					
					while(! l.isEmpty()){
						
						if( (char)l.peek() == '(' ||  (char)l.peek() == '+' || (char)l.peek() == '-' ) break;
						post_fix += l.pop() + " ";
					}
					l.push(seq);
					
				}
				
			} else if (seq == '+' || seq == '-'){
				
				if(l.isEmpty()){
					l.push(seq);
				
				} else if ( (char)l.peek() == '('  ){ 
					l.push(seq);
					
			    } else {
					
					while(!l.isEmpty() ){
						if((char) l.peek() == '(' ) break;
						post_fix += l.pop() + " ";
					}
					l.push(seq);
				}
				
			} else {
				if(Character.isDigit(seq)){
					
					post_fix += infix.charAt(i);
				if(i < infix.length() - 1){	
					while(Character.isDigit(infix.charAt(i + 1))){
						
						post_fix += infix.charAt(i + 1);
						
						i++;
						if(i == infix.length() - 1) break;
					}
				}
					post_fix += " ";
					
				}
			}
			
	}
		while(! l.isEmpty()){
			post_fix += l.pop() + " ";
		}
		return post_fix;
		
	
}
}
