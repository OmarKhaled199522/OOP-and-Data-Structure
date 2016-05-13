package eg.edu.alexu.csd.oop.calculator.cs44;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Calculator_gui implements ActionListener {

	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel(new FlowLayout());
	
	String arr[] = new String [100000 + 10];
	
	double number1 , number2 , sum = 0, res;
	boolean adi = false , sub = false , multy = false , divi = false, eq = false ,  text_ava = false, continu = false; 
	boolean neww = true;
	boolean no_next = false;
	boolean sav = false;
	
	int upper = 0;
	
	String inpu = "";
	String last = "";
	int counter = 0;
	
	Read rew = Read.getInctance();
	
	Calculation cal = Calculation.getInctance();
	
	Programme pro = Programme.getInctance();
	
	Load l = Load.getInctance();
	Save ss = Save.getInctance();
	
	JTextArea text = new JTextArea(1, 20);
	JButton button0 = new JButton("0");
	JButton button1 = new JButton("1");
	JButton button2 = new JButton("2");
	JButton button3 = new JButton("3");
	JButton button4 = new JButton("4");
	JButton button5 = new JButton("5");
	JButton button6 = new JButton("6");
	JButton button7 = new JButton("7");
	JButton button8 = new JButton("8");
	JButton button9 = new JButton("9");
	
	JButton add = new JButton("+");
	JButton subtract = new JButton("-");
	JButton multiply = new JButton("*");
	JButton divide = new JButton("/");
	JButton equal = new JButton("=");
	JButton clear = new JButton("C");
	JButton prev = new JButton("Prev");
	JButton fol = new JButton("Next");
	JButton save = new JButton("Save");
	JButton load = new JButton("Load");
	JButton curr = new JButton("Current");
	
	public void Cacu_gui(){
		
		frame.setVisible(true);
		frame.setSize(250, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		panel.add(text);
		panel.add(button0);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(add);
		panel.add(subtract);
		panel.add(multiply);
		panel.add(divide);
		panel.add(equal);
		panel.add(clear);
		panel.add(prev);
		panel.add(fol);
		panel.add(save);
		panel.add(load);
		panel.add(curr);
		
		button0.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		add.addActionListener(this);
		subtract.addActionListener(this);
		multiply.addActionListener(this);
		divide.addActionListener(this);
		equal.addActionListener(this);
		clear.addActionListener(this);
		curr.addActionListener(this);
		prev.addActionListener(this);
		fol.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		String s = text.getText();
		
		if(!s.equals("") && neww == true){
			inpu = s;
		} 
			
			if(source == button0 && !continu) {text.append("0"); inpu += "0"; neww = false;}
			else if (source == button1 && !continu) {text.append("1"); inpu += "1"; neww = false;}
			else if (source == button2 && !continu) {text.append("2"); inpu += "2"; neww = false;}
			else if (source == button3 && !continu) {text.append("3"); inpu += "3"; neww = false;}
			else if (source == button4 && !continu) {text.append("4"); inpu += "4"; neww = false;}
			else if (source == button5 && !continu) {text.append("5"); inpu += "5"; neww = false;}
			else if (source == button6 && !continu) {text.append("6"); inpu += "6"; neww = false;}
			else if (source == button7 && !continu) {text.append("7"); inpu += "7"; neww = false;}
			else if (source == button8 && !continu) {text.append("8"); inpu += "8"; neww = false;}
			else if (source == button9 && !continu) {text.append("9"); inpu += "9"; neww = false;}
			
			if(source == add) 
				{inpu += "+"; text.append("+");}
			else if(source == subtract)
				{inpu += "-"; text.append("-");}
			else if (source == divide)
				{inpu += "/"; text.append("/");}
			else if(source == multiply)
				{inpu += '*'; text.append("*");}
			
			else if(source == equal){
				
				neww = true;
				try {
					rew.check_valid(inpu);
					last = inpu;
					arr[counter++] = inpu ;
					cal.get_result(inpu);
					res = cal.res;
					text.setText( Double.toString(res) );
					no_next = true;
					upper = counter - 1;
					
				} catch (Exception e1) {
					System.out.println("Exception");
				}
			} else if (source == clear){
				inpu = "";
				text.setText("");
				neww = true;
				
			} else if (source == curr){
				text.setText(arr[counter - 1]);
				
			} else if (source == prev){
				if(counter - 2 < 0) text.setText("Invalid Position");
				else {
					counter -= 2;
					text.setText(arr[counter]);
					inpu = arr[counter++];
					no_next = false;
				}
				
			} else if (source == fol){
				Object check = arr[counter];
				if(check == null || counter > upper) 
					text.setText("Invalid Position");
		
				else {
					
					text.setText(arr[counter]);
					inpu = arr[counter++];
					
				}
				
			} else if (source == load){
				
				if(sav == false){
					try {
						System.out.println("There is no saved file!");
						throw new Exception();
					} catch (Exception e1) {
					}
					
				} else {
				
					l.read(arr);
					counter = l.counter;
					upper = counter - 1;
				}
		
			} else if (source == save){
				ss.store(arr, counter);
				sav = true;
			}
	}
	
}
