package eg.edu.alexu.csd.oop.draw.cs07;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import eg.edu.alexu.csd.oop.draw.Shape;

public class RunTime_Plugins extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunTime_Plugins frame = new RunTime_Plugins();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public RunTime_Plugins() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		MyDrawingEngine my = MyDrawingEngine.getInstance();
		Factory_Of_Shapes f = new Factory_Of_Shapes();
		
		
		Shape array [] = new Shape [100000 + 10];
		int idx = 0;
		
		LinkedList < Class < ? extends Shape> > arr = (LinkedList<Class<? extends Shape>>) my.getSupportedShapes();
		for(Class<? extends Shape> s : arr){
			String str = s.getClass().getName();
			if(!s.equals("Circle") || !s.equals("Ellipse") || !s.equals("Rectangle") || !s.equals("Square")|| !s.equals("Triangle") || !s.equals("Line")  ){
				Shape e = f.create(str);
				array[idx++] = e;
			}
		}
		
	}

}
