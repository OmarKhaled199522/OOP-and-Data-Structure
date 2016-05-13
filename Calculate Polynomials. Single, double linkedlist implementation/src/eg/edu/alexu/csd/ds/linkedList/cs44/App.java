package eg.edu.alexu.csd.ds.linkedList.cs44;

import java.util.Scanner;

public class App {

	 int choose;
	String s;
	Single_Linkedlist A = new Single_Linkedlist();
	Single_Linkedlist B = new Single_Linkedlist();
	Single_Linkedlist C = new Single_Linkedlist();
	Single_Linkedlist R = new Single_Linkedlist();
	int is_a_set = 0, is_b_set = 0 , is_c_set = 0,  is_r_set = 0;
	
	
	public void input(Single_Linkedlist Q){
		
		Scanner input = new Scanner(System.in);
		Q.clear();
		System.out.println("Insert the polynomial terms in the form:\n(coeff1,exponent1), (coeff2,exponent2)...");
		String s = input.nextLine();
		String [] parts = s.split(", ");
		for(int i = 0; i < parts.length; i++){
			Magnitude m = new Magnitude();
			int j = 1;
			
			String e = "";
			for(j = 1; parts[i].charAt(j) != ','; j++)
			e += parts[i].charAt(j);
			
			m.coeff  = (float) Double.parseDouble(e);
			e = "";
			for(int h = j + 1; h < parts[i].length() - 1; h++)
				e += parts[i].charAt(h);
			
			m.expon = (float) Double.parseDouble(e);
			/*if(parts[i].charAt(1) == '-') sign = -1;
			for(j = 1; parts[i].charAt(j) != ','; j++);
			for(int g = j - 1, con = 1; parts[i].charAt(g) != '-' && parts[i].charAt(g) != '('; g--, con *= 10){
				m.coeff += (parts[i].charAt(g) - '0') * con;
			}
			m.coeff *= sign;
			sign = 1;
			if(parts[i].charAt(++j) == '-') sign = -1;
			for(int g = parts[i].length() - 2, con = 1; parts[i].charAt(g) != '-' && parts[i].charAt(g) != ','; g--, con *= 10){
				m.expon += (parts[i].charAt(g) - '0') * con;
			}
			m.expon *= sign;*/
			Q.add(m);
		}
		//Q.print();
		//System.out.println();
	}
		
	public void set(){
		
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("Insert the variable name: A, B or C\nEnter any other key to exit");
			s = input.nextLine();
			if(s.equals("A")){
				input(A);
				A.sort_short();
				is_a_set = 1;
			} else if (s.equals("B")){
				input(B);
				B.sort_short();
				is_b_set = 1;
			} else if (s.equals("C")){
				input(C);
				C.sort_short();
				is_c_set = 1;
			
			} else {
				
				input.close();
				return;
			}
		}
	}

	
	public void print_polynomial(){
		
		Scanner input = new Scanner(System.in);
		while(true){
			System.out.println("Which Variable you want to print: A , B , C, R\nEnter any other key to exit");
			String s = input.nextLine();
			if(s.equals("A")){
				if(is_a_set == 1) A.print_variable();
				else System.out.println("The variable hasn't been set yet!!!");
			} else if (s.equals("B")){
				if(is_b_set == 1) B.print_variable();
				else System.out.println("The variable hasn't been set yet!!!");
			} else if (s.equals("C")){
				if(is_c_set == 1) C.print_variable();
				else System.out.println("The variable hasn't been set yet!!!");
				
			} else if (s.equals("R")){
				if(is_r_set == 1) R.print_variable();
				else System.out.println("The variable hasn't been set yet!!!");
			} else {
				
				input.close();
				return;
			}
		}
	}
	
	public void add_sub_sum(Single_Linkedlist l1, Single_Linkedlist l2, int determine){
		
		R.clear();
		boolean arr [] = new boolean [50];
		Node i = l1.getHead();
		Node j = l2.getHead();
		
		while(i != null){
			
			Magnitude n = (Magnitude) i.value;
			Magnitude temp = new Magnitude();
			temp.expon = n.expon;
			temp.coeff = n.coeff;
			j = l2.getHead();
			for(int h = 0; j != null; h++, j = j.next){
				
				Magnitude m = (Magnitude) j.value;
				if(n.expon == m.expon && arr[h] == false){
					
					if(determine == 1) temp.coeff += m.coeff;
					else 			   temp.coeff -= m.coeff;
					
					arr[h] = true;
				}
			}
			R.add(temp);
			i = i.next;
		}
		
		is_r_set = 1;
		Node e = l2.getHead();
		for(int g = 0; e!= null; g++, e= e.next){
			if(arr[g] == false){
				Magnitude w = (Magnitude) e.value;
				if(determine == -1) w.coeff *= -1;
				R.add(w);
			}
		}
		R.sort_short();
		R.print_variable();
		
	}
	

	public void multiply_sum(Single_Linkedlist l1, Single_Linkedlist l2){
		
		R.clear();
		Node i = l1.getHead();
		Node j = l2.getHead();
		
		while(i != null){
			
			Magnitude n = (Magnitude) i.value;
			j = l2.getHead();
			for(; j != null;j = j.next){
				
				Magnitude temp = new Magnitude();
				Magnitude m = (Magnitude) j.value;
					
				temp.coeff = n.coeff * m.coeff;
				temp.expon = n.expon + m.expon;
				R.add(temp);
			}
			i = i.next;
		}
		
		is_r_set = 1;
		R.sort_short();
		R.print_variable();		
	}
	
	
	public Single_Linkedlist [] check(){
		
		Scanner input = new Scanner(System.in);
		//Single_Linkedlist l1 = null , l2 = null; 
		Single_Linkedlist [] arr = new Single_Linkedlist [2];
		arr[0] = new Single_Linkedlist();
		arr[1] = new Single_Linkedlist();
		
		while(true){
			
			for(int i = 0; i < 2; i++){
				String q = (i == 0 ? "first" : "second");
				System.out.printf("Insert %s operand variable name: A, B or C\nEnter any other key to exit\n", q);
				String s = input.nextLine();
			
				if(s.equals("A") && is_a_set == 0) {System.out.println("Vaiable not set"); break;}
				
				else if (s.equals("A")) {if (i == 0)  arr[0] = A; else arr[1] = A;}
					
				else if (s.equals("B") && is_b_set == 0) {System.out.println("Vaiable not set");break;}
				
				else if (s.equals("B")) {if (i == 0) arr[0] = B; else arr[1] = B;}
				
				else if (s.equals("C") && is_c_set == 0) {System.out.println("Vaiable not set");break;}
				
				else if (s.equals("C")) {if (i == 0) arr[0] = C; else arr[0] = C;}
				
				else return null;
			
			}
			
			input.close();
			if(arr[0].getHead() != null && arr[1].getHead() != null) return arr;
		}	
	}
	
	
	public void evaluate(){
		
		Single_Linkedlist l = new Single_Linkedlist();
		Scanner input = new Scanner(System.in);
		System.out.printf("Insert variable name: A, B or C\nEnter any other key to exit\n");
		String s = input.nextLine();
		
		if(s.equals("A") && is_a_set == 0) System.out.println("Vaiable not set");
		else if(s.equals("A")) l = A;
		else if(s.equals("B") && is_a_set == 0) System.out.println("Vaiable not set");
		else if(s.equals("B")) l = B;
		else if(s.equals("C") && is_a_set == 0) System.out.println("Vaiable not set");
		else if(s.equals("C")) l = C;
		else {
			
			input.close();
			return;
		}
		
		double sum = 0;
		Node i = l.getHead();
		System.out.println("Enter the number value");
		int x = input.nextInt();
		
		while(i!= null){
			
			Magnitude n = (Magnitude) i.value;
			sum += n.coeff * Math.pow(x , n.expon);
			i = i.next;
		}
		Magnitude e = new Magnitude();
		e.coeff = sum;
		is_r_set = 1;
		R.clear();
		R.add(e);
		System.out.println("Evaluation = "+ sum);
		input.close();
	}
	
	public void clear(){
		
		while(true){
			Scanner input = new Scanner(System.in);
			System.out.printf("Insert variable name: A, B or C\nEnter any other key to exit\n");
			String s = input.nextLine();
		
			if(s.equals("A") && is_a_set == 0) System.out.println("Vaiable not set");
			else if(s.equals("A")) {A.setHead(null);; is_a_set = 0;}
			else if(s.equals("B") && is_a_set == 0) System.out.println("Vaiable not set");
			else if(s.equals("B")) {B.setHead(null); is_b_set = 0;}
			else if(s.equals("C") && is_a_set == 0) System.out.println("Vaiable not set");
			else if(s.equals("C")) {C.setHead(null); is_c_set = 0;}
			else { 
				
				input.close();
				return;
			}
		}
	}
	
	
	
	
	public void Main(){
		
		Scanner input = new Scanner(System.in);
		while(true){
			
			System.out.printf("Please choose an action\n"+
			"-----------------------\n" +
			"1- Set a polynomial variable\n" +
			"2- Print the value of a polynomial variable\n" +
			"3- Add two polynomials\n" +
			"4- Subtract two polynomials\n" +
			"5- Multiply two polynomials\n" +
			"6- Evaluate a polynomial at some point\n" +
			"7- Clear a polynomial variable\n" + "Enter any other key to exit\n" +"-----------------------\n");
			
			choose = input.nextInt();
			
			if(choose == -1) break;
			else if (choose == 1){
				set();
				
			} else if (choose == 2){
				print_polynomial();
				
			} else if (choose == 3){
				Single_Linkedlist [] arr1 = check();
				if(arr1[0] != null && arr1[1] != null) add_sub_sum(arr1[0], arr1[1], 1);
				
			} else if (choose == 4){
				Single_Linkedlist [] arr1 = check();
				if(arr1[0] != null && arr1[1] != null) add_sub_sum(arr1[0], arr1[1] , -1);
				
			} else if (choose == 5){
				Single_Linkedlist [] arr1 = check();
				if(arr1 != null) if(arr1[0].getHead() != null && arr1[1].getHead() != null) multiply_sum(arr1[0], arr1[1]);
				
			} else if (choose == 6){
				evaluate();
				
			} else if (choose == 7){
				clear();
				
			} else return;
			
			
		}
		
		input.close();
	}
	
}
