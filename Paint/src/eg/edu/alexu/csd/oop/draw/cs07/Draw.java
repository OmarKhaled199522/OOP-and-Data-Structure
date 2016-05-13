package eg.edu.alexu.csd.oop.draw.cs07;


import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Draw extends JFrame {

	private JPanel contentPane;
	private Object contin;
	
	
	public void paint ( Graphics g ){
		
		
		MyDrawingEngine my = (MyDrawingEngine) contin;
		my.refresh(g);
				
			
	}
	
	public Draw (Object e){
		
		contin = e;
		setBounds(300, 100, 600, 600);     
		setVisible(true);
		
		
		addWindowListener(new WindowAdapter()
	       {public void windowClosing(WindowEvent e)
	          {dispose(); setVisible(true);}
	       }
	     );
		
	}
	
	public Draw (String n , String t, double xp , double yp , double le1 , double le2){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*Adding_List ad = new Adding_List();
		
		addWindowListener(new WindowAdapter()
	       {public void windowClosing(WindowEvent e)
	          {dispose(); ad.setVisible(true);}
	       }
	     );*/
		
		/*object_name = n;
		xpos = (int) xp;
		ypos = (int) yp;
		len1 = (int) le1;
		len2 = (int) le2;*/
		
	}

}
