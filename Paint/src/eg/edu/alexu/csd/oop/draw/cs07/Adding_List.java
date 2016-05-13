package eg.edu.alexu.csd.oop.draw.cs07;

import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.JTextField;

@SuppressWarnings("serial")

public class Adding_List extends JFrame {

	private Double xpos, ypos , len1 , len2;
	private MyDrawingEngine my = MyDrawingEngine.getInstance();
	private String color_fill, color_board;
	private Map< String , Integer > parallel = new HashMap<String, Integer>();

	
	private JPanel contentPane;
	private JTextField ell1;
	private JTextField ell2;
	private JTextField ell3;
	private JTextField ell4;
	private JTextField rec1;
	private JTextField rec2;
	private JTextField rec3;
	private JTextField textField_7;
	private JTextField rec4;
	private JTextField li1;
	private JTextField li2;
	private JTextField li3;
	private JTextField li4;
	private JTextField squ1;
	private JTextField squ2;
	private JTextField squ3;
	private JTextField ci1;
	private JTextField ci2;
	private JTextField ci3;
	private JTextField tri1;
	private JTextField tri2;
	private JTextField tri3;
	private JTextField tri4;
	private JTextField tri5;
	private JTextField color;
	private JTextField fill;
	private JTextField tri6;
	private JTextField name;

	
	public Adding_List(final boolean add_update) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChooseAShape = new JLabel("Choose a Shape :");
		lblChooseAShape.setForeground(Color.DARK_GRAY);
		lblChooseAShape.setFont(new Font("Ravie", Font.PLAIN, 20));
		lblChooseAShape.setBounds(38, 0, 247, 50);
		contentPane.add(lblChooseAShape);
		
		JButton ellipse = new JButton("Ellipse");
		
		
		ellipse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					parallel = my.getMapp();
					
					xpos = Double.valueOf(ell1.getText());
					ypos = Double.valueOf(ell2.getText());
					len1 = Double.valueOf(ell3.getText());
					len2 = Double.valueOf(ell4.getText());
					color_board = color.getText();
					color_fill = fill.getText();
					
					if(add_update == true){
						String c = name.getText();
						parallel.put(c, my.getPos());
						my.setmap(parallel);
					}
					
					
					Ellipse ellips = new Ellipse();
					
					
					Map< String , Double> mapellips = ellips.getProperties();
					//maprec[] = ;
					int i = 0;
					
					 Iterator it = mapellips.entrySet().iterator();
					 
					    while (it.hasNext()) {
					    	
					        Map.Entry pair = (Map.Entry)it.next();
					        
					        if (i == 0) pair.setValue(len1);
					        else if (i == 1) pair.setValue(len2);
					       
					        i++;
					        
					    }
					
					ellips.setProperties(mapellips);
					Point po = new Point();
					double x = xpos;
					double y = ypos;
					po.x = (int) x;
					po.y = (int) y;
					ellips.setPosition(po);
					
					
					Color co1 = null , co2 = null;
					try {
						 co1   = (Color) Color.class.getField(color_fill).get(null);
						 co2   = (Color) Color.class.getField(color_board).get(null);
					} catch (IllegalArgumentException e1) {
						
					} catch (IllegalAccessException e1) {
						
						
					} catch (NoSuchFieldException e1) {
						
					} catch (SecurityException e1) {
						
					}
					
					ellips.setFillColor( co1);
					ellips.setColor( co2);
					
					if(add_update == true) my.addShape( ellips );
					else {
						int pos = my.getMapp().get(name.getText());
						my.updateShape(my.arr[pos], ellips);
					}
					
					//Draw q = new Draw(object_name, object_type, xpos, ypos, len1, len2);
					Draw q = new Draw(my);
					q.setVisible(true);
				} catch (Exception ex){
					
				}
			}
		});
		
		ellipse.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		ellipse.setBounds(23, 138, 89, 55);
		contentPane.add(ellipse);
		
		JButton line = new JButton("Line");
		line.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		line.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					parallel = my.getMapp();
					
					xpos = Double.valueOf(li1.getText());
					ypos = Double.valueOf(li2.getText());
					len1 = Double.valueOf(li3.getText());
					len2 = Double.valueOf(li4.getText());
					color_board = color.getText();
					
					if(add_update == true){
						String c = name.getText();
						parallel.put(c, my.getPos());
						my.setmap(parallel);
					}
					
					Line lin = new Line();
					Map< String , Double> maplin = lin.getProperties();
					
					int i = 0;
					
					 Iterator it = maplin.entrySet().iterator();
					 
					    while (it.hasNext()) {
					    	
					        Map.Entry pair = (Map.Entry)it.next();
					        
					        if (i == 0) pair.setValue(len1);
					        else if (i == 1) pair.setValue(len2);
					       
					        i++;
					        
					        //it.remove(); // avoids a ConcurrentModificationException
					    }
					
					lin.setProperties(maplin);
					Point po = new Point();
					double x = xpos;
					double y = ypos;
					po.x = (int) x;
					po.y = (int) y;
					lin.setPosition(po);
					
					
					Color co2 = null;
					try {
						 //co1   = (Color) Color.class.getField(color_fill).get(null);
						 co2   = (Color) Color.class.getField(color_board).get(null);
					} catch (IllegalArgumentException e1) {
						
					} catch (IllegalAccessException e1) {
						
						
					} catch (NoSuchFieldException e1) {
						
					} catch (SecurityException e1) {
						
					}
					
					//lin.setFillColor( co1);
					lin.setColor( co2);
					
					if(add_update == true)  my.addShape( lin );
					else {
						int pos = my.getMapp().get(name.getText());
						my.updateShape(my.arr[pos], lin);
					}
					
					//Draw q = new Draw(object_name, object_type, xpos, ypos, len1, len2);
					Draw q = new Draw(my);
					q.setVisible(true);
				} catch (Exception ex) {
					
				}
			}
		});
		
		
		line.setBounds(23, 269, 89, 50);
		contentPane.add(line);
		
		JButton triangle = new JButton("Triangle");
		triangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					parallel = my.getMapp();
					
					xpos = Double.valueOf(tri1.getText());
					ypos = Double.valueOf(tri2.getText());
					len1 = Double.valueOf(tri3.getText());
					len2 = Double.valueOf(tri4.getText());
					double len3 = Double.valueOf(tri5.getText());
					double len4 = Double.valueOf(tri6.getText());
					
					if(add_update == true){
						String c = name.getText();
						parallel.put(c, my.getPos());
						my.setmap(parallel);
					}
					
					color_board = color.getText();
					color_fill = fill.getText();
					
					
					
					Triangle tri = new Triangle();
					Map< String , Double> maptri = tri.getProperties();
					
					int i = 0;
					
					 Iterator it = maptri.entrySet().iterator();
					 
					    while (it.hasNext()) {
					    	
					        Map.Entry pair = (Map.Entry)it.next();
					        
					        if (i == 0) pair.setValue(len1);
					        else if (i == 1) pair.setValue(len2);
					        else if (i == 2) pair.setValue(len3);
					        else if (i == 3) pair.setValue(len4);
					        
					        i++;
					        
					        //it.remove(); // avoids a ConcurrentModificationException
					    }
					
					tri.setProperties(maptri);
					Point po = new Point();
					double x = xpos;
					double y = ypos;
					po.x = (int) x;
					po.y = (int) y;
					tri.setPosition(po);
					
					
					Color co1 = null , co2 = null;
					try {
						 co1   = (Color) Color.class.getField(color_fill).get(null);
						 co2   = (Color) Color.class.getField(color_board).get(null);
					} catch (IllegalArgumentException e1) {
						
					} catch (IllegalAccessException e1) {
						
						
					} catch (NoSuchFieldException e1) {
						
					} catch (SecurityException e1) {
						
					}
					
					tri.setFillColor( co1);
					tri.setColor( co2);
					
					if(add_update == true) my.addShape( tri );
					else {
						int pos = my.getMapp().get(name.getText());
						my.updateShape(my.arr[pos], tri);
					}
					
					//Draw q = new Draw(object_name, object_type, xpos, ypos, len1, len2);
					Draw q = new Draw(my);
					q.setVisible(true);
				} catch (Exception ex){
					
				}
			}
		});
		triangle.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		triangle.setBounds(23, 471, 89, 50);
		contentPane.add(triangle);
		
		JButton rectangle = new JButton("Rectangle");
		rectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					parallel = my.getMapp();
					
					xpos = Double.valueOf(rec1.getText());
					ypos = Double.valueOf(rec2.getText());
					len1 = Double.valueOf(rec3.getText());
					len2 = Double.valueOf(rec4.getText());
					color_board = color.getText();
					color_fill = fill.getText();
					
					if(add_update == true){
						String c = name.getText();
						parallel.put(c, my.getPos());
						my.setmap(parallel);
					}
					
					Rectangle rec = new Rectangle();
					Map< String , Double> maprec = rec.getProperties();
					//maprec[] = ;
					int i = 0;
					
					 Iterator it = maprec.entrySet().iterator();
					 
					    while (it.hasNext()) {
					    	
					        Map.Entry pair = (Map.Entry)it.next();
					        
					        if (i == 0) pair.setValue(len1);
					        else if (i == 1) pair.setValue(len2);
					       
					        i++;
					        
					        //it.remove(); // avoids a ConcurrentModificationException
					    }
					
					rec.setProperties(maprec);
					Point po = new Point();
					double x = xpos;
					double y = ypos;
					po.x = (int) x;
					po.y = (int) y;
					rec.setPosition(po);
					
					
					Color co1 = null , co2 = null;
					try {
						 co1   = (Color) Color.class.getField(color_fill).get(null);
						 co2   = (Color) Color.class.getField(color_board).get(null);
					} catch (IllegalArgumentException e1) {
						
					} catch (IllegalAccessException e1) {
						
						
					} catch (NoSuchFieldException e1) {
						
					} catch (SecurityException e1) {
						
					}
					
					rec.setFillColor( co1);
					rec.setColor( co2 );
					
					if(add_update == true)   my.addShape( rec );
					else {
						int pos = my.getMapp().get(name.getText());
						my.updateShape(my.arr[pos], rec);
					}
					
					//Draw q = new Draw(object_name, object_type, xpos, ypos, len1, len2);
					Draw q = new Draw(my);
					q.setVisible(true);
					
				} catch (Exception ex){
					
				}
			}
		});
		
		rectangle.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		rectangle.setBounds(23, 204, 99, 50);
		contentPane.add(rectangle);
		
		JButton square = new JButton("Square");
		square.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					parallel = my.getMapp();
					
					xpos = Double.valueOf(squ1.getText());
					ypos = Double.valueOf(squ2.getText());
					len1 = Double.valueOf(squ3.getText());
					
					color_board = color.getText();
					color_fill = fill.getText();
					
					if(add_update == true){
						String c = name.getText();
						parallel.put(c, my.getPos());
						my.setmap(parallel);
					}
					
					Square rec = new Square();
					Map< String , Double> maprec = rec.getProperties();
					//maprec[] = ;
					int i = 0;
					
					 Iterator it = maprec.entrySet().iterator();
					 
					    while (it.hasNext()) {
					    	
					        Map.Entry pair = (Map.Entry)it.next();
					        if (i == 0) pair.setValue(len1);
					        i++;
					        
					        //it.remove(); // avoids a ConcurrentModificationException
					    }
					
					rec.setProperties(maprec);
					Point po = new Point();
					double x = xpos;
					double y = ypos;
					po.x = (int) x;
					po.y = (int) y;
					rec.setPosition(po);
					
					
					Color co1 = null , co2 = null;
					try {
						 co1   = (Color) Color.class.getField(color_fill).get(null);
						 co2   = (Color) Color.class.getField(color_board).get(null);
					} catch (IllegalArgumentException e1) {
						
					} catch (IllegalAccessException e1) {
						
						
					} catch (NoSuchFieldException e1) {
						
					} catch (SecurityException e1) {
						
					}
					
					rec.setFillColor( co1);
					rec.setColor( co2);
					
					if(add_update == true)   my.addShape( rec );
					else{
						int pos = my.getMapp().get(name.getText());
						my.updateShape(my.arr[pos], rec);
					}
					
					//Draw q = new Draw(object_name, object_type, xpos, ypos, len1, len2);
					Draw q = new Draw(my);
					q.setVisible(true);
				
				} catch (Exception ex) {
					
				}
			}
		});
		
		square.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		square.setBounds(23, 336, 106, 50);
		contentPane.add(square);
		
		JButton circle = new JButton("Circle");
		circle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
				
					parallel = my.getMapp();
					
					xpos = Double.valueOf(ci1.getText());
					ypos = Double.valueOf(ci2.getText());
					len1 = Double.valueOf(ci3.getText());
					//len2 = Double.valueOf(ci4.getText());
					color_board = color.getText();
					color_fill = fill.getText();
					
					if(add_update == true){
						String c = name.getText();
						parallel.put(c, my.getPos());
						my.setmap(parallel);
					}
					
					Circle circ = new Circle();
					Map< String , Double> mapellips = circ.getProperties();
					//maprec[] = ;
					int i = 0;
					
					 Iterator it = mapellips.entrySet().iterator();
					 
					    while (it.hasNext()) {
					    	
					        Map.Entry pair = (Map.Entry)it.next();
					        if (i == 0) pair.setValue(len1);
					        i++;
					        
					    }
					
					circ.setProperties(mapellips);
					Point po = new Point();
					double x = xpos;
					double y = ypos;
					po.x = (int) x;
					po.y = (int) y;
					circ.setPosition(po);
					
					Color co1 = null , co2 = null;
					try {
						 co1   = (Color) Color.class.getField(color_fill).get(null);
						 co2   = (Color) Color.class.getField(color_board).get(null);
					} catch (IllegalArgumentException e1) {
						
					} catch (IllegalAccessException e1) {
						
						
					} catch (NoSuchFieldException e1) {
						
					} catch (SecurityException e1) {
						
					}
					
					circ.setFillColor( co1);
					circ.setColor( co2);
					
					if (add_update == true)   my.addShape( circ );
					else {
						int pos = my.getMapp().get(name.getText());
						my.updateShape(my.arr[pos], circ);
					}
					
					//Draw q = new Draw(object_name, object_type, xpos, ypos, len1, len2);
					Draw q = new Draw(my);
					q.setVisible(true);
				} catch (Exception ex){
					
				}
			}
		});
		circle.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 16));
		circle.setBounds(23, 402, 89, 50);
		contentPane.add(circle);
		
		ell1 = new JTextField();
		ell1.setBounds(129, 156, 86, 20);
		contentPane.add(ell1);
		ell1.setColumns(10);
		
		ell2 = new JTextField();
		ell2.setBounds(247, 156, 86, 20);
		contentPane.add(ell2);
		ell2.setColumns(10);
		
		ell3 = new JTextField();
		ell3.setBounds(361, 156, 86, 20);
		contentPane.add(ell3);
		ell3.setColumns(10);
		
		ell4 = new JTextField();
		ell4.setBounds(473, 156, 86, 20);
		contentPane.add(ell4);
		ell4.setColumns(10);
		
		rec1 = new JTextField();
		rec1.setBounds(129, 220, 86, 20);
		contentPane.add(rec1);
		rec1.setColumns(10);
		
		rec2 = new JTextField();
		rec2.setBounds(247, 220, 86, 20);
		contentPane.add(rec2);
		rec2.setColumns(10);
		
		rec3 = new JTextField();
		rec3.setBounds(361, 220, 86, 20);
		contentPane.add(rec3);
		rec3.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(422, 258, 38, -15);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		rec4 = new JTextField();
		rec4.setBounds(473, 220, 86, 20);
		contentPane.add(rec4);
		rec4.setColumns(10);
		
		li1 = new JTextField();
		li1.setBounds(129, 285, 86, 20);
		contentPane.add(li1);
		li1.setColumns(10);
		
		li2 = new JTextField();
		li2.setBounds(247, 285, 86, 20);
		contentPane.add(li2);
		li2.setColumns(10);
		
		li3 = new JTextField();
		li3.setBounds(361, 285, 86, 20);
		contentPane.add(li3);
		li3.setColumns(10);
		
		li4 = new JTextField();
		li4.setBounds(473, 285, 86, 20);
		contentPane.add(li4);
		li4.setColumns(10);
		
		squ1 = new JTextField();
		squ1.setBounds(140, 352, 86, 20);
		contentPane.add(squ1);
		squ1.setColumns(10);
		
		squ2 = new JTextField();
		squ2.setBounds(247, 352, 86, 20);
		contentPane.add(squ2);
		squ2.setColumns(10);
		
		squ3 = new JTextField();
		squ3.setBounds(361, 352, 86, 20);
		contentPane.add(squ3);
		squ3.setColumns(10);
		
		ci1 = new JTextField();
		ci1.setBounds(129, 418, 86, 20);
		contentPane.add(ci1);
		ci1.setColumns(10);
		
		ci2 = new JTextField();
		ci2.setBounds(247, 418, 86, 20);
		contentPane.add(ci2);
		ci2.setColumns(10);
		
		ci3 = new JTextField();
		ci3.setBounds(361, 418, 86, 20);
		contentPane.add(ci3);
		ci3.setColumns(10);
		
		tri1 = new JTextField();
		tri1.setBounds(129, 487, 86, 20);
		contentPane.add(tri1);
		tri1.setColumns(10);
		
		tri2 = new JTextField();
		tri2.setBounds(247, 487, 86, 20);
		contentPane.add(tri2);
		tri2.setColumns(10);
		
		tri3 = new JTextField();
		tri3.setBounds(361, 487, 86, 20);
		contentPane.add(tri3);
		tri3.setColumns(10);
		
		tri4 = new JTextField();
		tri4.setBounds(473, 487, 86, 20);
		contentPane.add(tri4);
		tri4.setColumns(10);
		
		tri5 = new JTextField();
		tri5.setBounds(171, 530, 86, 20);
		contentPane.add(tri5);
		tri5.setColumns(10);
		
		JButton back = new JButton("<- Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Main_list mi = new Main_list();
				mi.setVisible(true);
			}
		});
		back.setBounds(470, 16, 89, 23);
		contentPane.add(back);
		
		color = new JTextField();
		color.setBounds(236, 95, 86, 20);
		contentPane.add(color);
		color.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Boarder Color");
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 14));
		lblNewLabel.setBounds(115, 96, 127, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fill Color");
		lblNewLabel_1.setFont(new Font("Snap ITC", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(349, 96, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		fill = new JTextField();
		fill.setBounds(445, 95, 86, 20);
		contentPane.add(fill);
		fill.setColumns(10);
		
		tri6 = new JTextField();
		tri6.setBounds(322, 530, 86, 20);
		contentPane.add(tri6);
		tri6.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Shape Name:");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(210, 55, 112, 14);
		contentPane.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setBounds(322, 53, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
	}
}
