package eg.edu.alexu.csd.oop.draw.cs07;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;

public class MyDrawingEngine implements DrawingEngine {
	
	private int twentyCnt = 0, mx = -1;
	private Stack<Item> s1 = new Stack<Item>(); // container of the done
												// operations to undo
	private Stack<Item> s2 = new Stack<Item>(); // container of the undone
												// operations to
	private static MyDrawingEngine instance = null;
	private int pos = 0;
	
	Factory_Of_Shapes factory = new Factory_Of_Shapes();

	private Map<String, Integer> mapp = new HashMap<String, Integer>();

	private MyDrawingEngine() {
	}

	public static MyDrawingEngine getInstance() {
		if (instance == null) {
			instance = new MyDrawingEngine();
		}
		return instance;
	}

	Shape arr[] = new Shape[1000];


	public Map<String, Integer> getMapp() {
		return mapp;
	}

	public void setmap(Map<String, Integer> parallel) {
		mapp = parallel;
	}

	@Override
	public void refresh(Graphics canvas) {
	
		for (int i = 0; i <= mx; i++) {
			if (arr[i] != null)
				arr[i].draw(canvas);
		}

	}

	@Override
	public void addShape(Shape shape) {
		
		pos++;
		arr[++mx] = shape;
		s1.push(new Item(shape, 'a', mx, null));
		s2.clear();// c

	}

	@Override
	public void removeShape(Shape shape) {
		
		
		boolean flag = false;
		for (int i = 0; !flag && i <= mx; i++) {
			if (arr[i] == shape && shape != null) {
				arr[i] = null;
				s1.push(new Item(shape, 'r', i, null));
				flag = true;
			}
		}
		if (!flag)
			throw new RuntimeException();

	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		
		boolean flag = false;
		for (int i = 0; i <= mx; i++) {
			if (arr[i] == oldShape) {
				arr[i] = newShape;
				s1.push(new Item(newShape, 'u', i, oldShape));
				flag = true;
				// System.out.println(s1.peek().updated);
			}
		}
		if (!flag)
			throw new RuntimeException();
		s2.clear();

	}

	@Override
	public Shape[] getShapes() {
		
		int cnt = 0;
		for (int i = 0; i <= mx; i++) {
			if (arr[i] != null)
				cnt++;
		}
		Shape shape[] = new Shape[cnt];
		for (int i = 0, j = 0; i <= mx; i++) {
			if (arr[i] != null) {
				shape[j] = arr[i];
				j++;
			}
		}
		return shape;
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		
		java.util.List<Class<? extends Shape>> list = new LinkedList<Class<? extends Shape>>();
		/*list.add(Rectangle.class);
		list.add(Ellipse.class);
		list.add(Square.class);
		list.add(Line.class);
		list.add(Triangle.class);*/
		try {
			ClassFinder find = new ClassFinder(Shape.class);
			Set<Class<? extends Shape>> set = find.getClasses();

			java.util.Iterator<Class<? extends Shape>> itr = set.iterator();
			while (itr.hasNext()) {
				Class clas = itr.next();
				String name = clas.getName();
				if(!name.equals("Circle") && !name.equals("Ellipse") && !name.equals("Rectangle") && !name.equals("Square") && !name.equals("Line") && !name.equals("Triangle")  ){
					Shape plugin =  factory.create(name);
					
					Map < String , Double > mapshape = plugin.getProperties();
					
					for ( String key : mapshape.keySet() ) {
					    //System.out.println( key );
						 String input = JOptionPane.showInputDialog(key);  
					     mapshape.put(key, Double.valueOf(input));
					}
					plugin.setProperties(mapshape);
					
					String input = JOptionPane.showInputDialog("Position (x)");  
					String input2 = JOptionPane.showInputDialog("Position (y)");
					Point po = null;
					po.x = (int) Double.parseDouble(input);
					po.y = (int) Double.parseDouble(input);
					plugin.setPosition(po);
					
					
					input = JOptionPane.showInputDialog("Fill color");  
					input2 = JOptionPane.showInputDialog("Boarder color");
					Color co1   = (Color) Color.class.getField(input).get(null);
					Color co2   = (Color) Color.class.getField(input2).get(null);
					
					plugin.setFillColor(co1);
					plugin.setColor(co2);
					
				}
				
				//System.out.println(e.getName());
				list.add(itr.next());
			}

		} catch (Exception e) {
			
		}

		return list;
	}

	@Override
	public void undo() {
		if (twentyCnt == 20)
			throw new RuntimeException();
		char s = s1.peek().getState();
		Item poped = s1.pop();
		s2.push(poped);

		if (s == 'a') {
			arr[poped.getPos()] = null;
		} else if (s == 'r') {
			arr[poped.getPos()] = poped.getShape();
		} else if (s == 'u') {
			arr[poped.getPos()] = poped.getUpdated();
		}
		twentyCnt++;
	}

	@Override
	public void redo() {
		
		if (twentyCnt == 0)
			throw new RuntimeException();
		Item poped = s2.pop();
		s1.push(poped);
		char s = poped.getState();
		if (s == 'a') {
			arr[poped.getPos()] = poped.getShape();
		} else if (s == 'r') {
			arr[poped.getPos()] = null;
		} else if (s == 'u') {
			arr[poped.getPos()] = poped.getShape();

		}
		twentyCnt--;

	}

	@Override
	public void save(String path) {
		
		path = path.toLowerCase();

		if (path.endsWith("xml")) {
			System.out.println(path);
			WritingXML w = new WritingXML();
			w.setArr(this.getShapes());
			w.saveXML(path);
		} else {
			Json j = new Json();
			j.setArr(this.getShapes());
			j.writeJson(path);
		}

	}

	@Override
	public void load(String path) {
		
		path = path.toLowerCase();
		if (path.endsWith("xml")) {
			ReadingXML r = new ReadingXML();
			try {
				r.readXML(path);
				mapp = r.getMap();
				Shape arr2[] = r.getArr();
				s1.clear();
				for (int i = 0; i < 1000; i++) {
					if (i < arr2.length) {
						arr[i] = arr2[i];
					} else
						arr[i] = null;
				}

				System.out.println(r.getArr()[0]);
				mx = arr2.length - 1;

			} catch (ParserConfigurationException | SAXException | IOException e) {
				
				throw new RuntimeException();
			}
		} else {
			Json j = new Json();
			try {
				j.readJson(path);
				mapp = j.getMapp();
				Shape arr2[] = j.getRead();
				s1.clear();
				for (int i = 0; i < 1000; i++) {
					if (i < arr2.length) {
						arr[i] = arr2[i];
					} else
						arr[i] = null;
				}
				mx = arr2.length - 1;
			} catch (IOException e) {
				
				throw new RuntimeException();
			} catch (InstantiationException e) {
				
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block

			}

		}
		s2.clear();

	}

	public int getPos() {
		return pos;
	}

}
