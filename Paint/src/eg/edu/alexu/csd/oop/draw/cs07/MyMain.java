package eg.edu.alexu.csd.oop.draw.cs07;

public class MyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*MyDrawingEngine d = new MyDrawingEngine();
		Ellipse e1 = new Ellipse(new Point(1, 1), 1, 1, 1, Color.BLUE,
				Color.BLUE);
		d.addShape(e1);

		Ellipse e2 = new Ellipse(new Point(2, 2), 2, 2, 2, Color.BLUE,
				Color.BLUE);
		d.addShape(e2);

		Ellipse e3 = new Ellipse(new Point(3, 3), 3, 3, 3, Color.BLUE,
				Color.BLUE);
		d.addShape(e3);
		
		d.undo();
		d.redo();

		System.out.println(d.arr[2] );*/
		
		
		
		
		Painter_gui frame = new Painter_gui();
		frame.setVisible(true);
		
		/*MyDrawingEngine my = MyDrawingEngine.getInstance();
		Circle c = new Circle();
		my.addShape(c);
		
		Map < String , Integer > parallel = new HashMap<String, Integer>();
		parallel.put("circ1", 0);
		my.setmap(parallel);
	
		Map < String , Integer > p = my.getmap(); 
		System.out.println(p.get("circ1"));
	
		
		Circle c2 = new Circle();
		my.addShape(c2);
		
		parallel.put("circ2", 1);
		
		my.setmap(parallel);
		
		my.save("omar.xml");
		my.undo();
		my.undo();
		my.load("omar.xml");
		
		p = my.getmap(); 
		System.out.println(  p.get("circ1") );
		
		Rectangle r1 = new Rectangle();
		my.addShape(r1);
		
		
		parallel.put("rec5", 2);
		my.setmap(parallel);
		
		p = my.getmap();
		
		System.out.println( p.get("rec5") );
		
		/*MyDrawingEngine my = MyDrawingEngine.getInstance();
		Rectangle r1 = new Rectangle();
		my.addShape(r1);
		Rectangle r2 = new Rectangle();
		my.save("what.xml");
		my.load("what.xml");
		Circle c1 = new Circle();
		my.addShape( c1 );*/
		
		/*MyDrawingEngine my = MyDrawingEngine.getInstance();
		Rectangle r1 = new Rectangle();
		my.addShape(r1);
		my.save("omar.xml");
		my.load("omar.xml");
		Rectangle r2 = new Rectangle();
		my.addShape(r2);
		Rectangle r3 = new Rectangle();
		my.addShape(r3);
		my.save("j.json");
		my.undo();
		my.undo();
		my.undo();
		*/
		
		//MyDrawingEngine my = MyDrawingEngine.getInstance();
	//	my.getSupportedShapes();
		
		/*MyDrawingEngine my = MyDrawingEngine.getInstance();
		Rectangle r1 = new Rectangle();
		r1.setProperties(null);
		r1.setColor(Color.WHITE);
		my.addShape(r1 );
		Rectangle r2 = new Rectangle();
		my.addShape(r2);
		Rectangle r3 = new Rectangle();
		my.addShape(r3);
		

		//my.updateShape(r1, r2);
		my.save("iii.json");
		//my.undo();
		//my.undo();
		my.load("iii.json");
		Shape [] sh = my.getShapes();
	System.out.println(sh[0]);*/
		
	//	MyDrawingEngine my = MyDrawingEngine.getInstance();
	/*	MyDrawingEngine my = MyDrawingEngine.getInstance();
		
		Rectangle r = new Rectangle();
		Rectangle r1 = new Rectangle();my.addShape(r1);
		Rectangle r2 = new Rectangle();my.addShape(r2);
		Rectangle r3 = new Rectangle();my.addShape(r3);
		Rectangle r4 = new Rectangle();my.addShape(r4);
		Rectangle r5 = new Rectangle();my.addShape(r5);
		Rectangle r6 = new Rectangle();my.addShape(r6);
	//	my.addShape(r);
		my.arr[0].setProperties(null);
		my.arr[1].setProperties(null);
		my.arr[2].setProperties(null);
		my.arr[3].setProperties(null);
		my.arr[4].setProperties(null);
		my.arr[5].setProperties(null);
	//	my.arr[0].setPosition(new Point(2,3));
		my.save("aa.xml");
		my.load("aa.xml");
		System.out.println(my.getShapes().length);*/
		
		/*Circle circ = new Circle();
		Map< String , Double> mapellips = circ.getProperties();
		
		int i = 0;
		
		 Iterator it = mapellips.entrySet().iterator();
		 
		    while (it.hasNext()) {
		    	
		        Map.Entry pair = (Map.Entry)it.next();
		        if (i == 0) pair.setValue(100.0);
		        i++;
		        
		    }
		
		circ.setProperties(mapellips);
		Point po = new Point();
		double x = 100;
		double y = 100;
		po.x = (int) x;
		po.y = (int) y;
		circ.setPosition(po);
		my.addShape(circ);
		Shape ch[] = my.getShapes();
		System.out.println(ch.length);
		Circle circ2 = new Circle();
		Map< String , Double> mapellips2 = circ.getProperties();
		
		int i2 = 0;
		
		 Iterator it2 = mapellips.entrySet().iterator();
		 
		    while (it2.hasNext()) {
		    	
		        Map.Entry pair = (Map.Entry)it2.next();
		        if (i == 0) pair.setValue(200.0);
		        i++;
		        
		    }
		
		circ2.setProperties(mapellips2);
		Point po2 = new Point();
		double x2 = 100;
		double y2 = 100;
		po2.x = (int) x2;
		po2.y = (int) y2;
		circ2.setPosition(po2);
		my.addShape(circ2);
		Shape qq [] = my.getShapes();
		my.save("omar.xml");
		my.undo();
		my.undo();
		Shape sh [] = my.getShapes();
		my.load("omar.xml");
		sh = my.getShapes();
		System.out.println(sh[0].getFillColor());
		sh[0].setColor(Color.WHITE);
	/*	System.out.println(sh[0].getFillColor());
		System.out.println(sh.length);
		System.out.println(sh[0].getPosition());*/
		
	/*	Map< String , Double> mapellips = circ.getProperties();
		
		int i = 0;
		
		 Iterator it = mapellips.entrySet().iterator();
		 
		    while (it.hasNext()) {
		    	
		        Map.Entry pair = (Map.Entry)it.next();
		        if (i == 0) pair.setValue(100.0);
		        i++;
		        
		    }
		
		circ.setProperties(mapellips);
		Point po = new Point();
		double x = 100;
		double y = 100;
		po.x = (int) x;
		po.y = (int) y;
		circ.setPosition(po);
		my.addShape(circ);
		Shape ch[] = my.getShapes();
		System.out.println(ch.length);
		Circle circ2 = new Circle();
		Map< String , Double> mapellips2 = circ.getProperties();
		
		int i2 = 0;
		
		 Iterator it2 = mapellips.entrySet().iterator();
		 
		    while (it2.hasNext()) {
		    	
		        Map.Entry pair = (Map.Entry)it2.next();
		        if (i == 0) pair.setValue(200.0);
		        i++;
		        
		    }
		
		circ2.setProperties(mapellips2);
		Point po2 = new Point();
		double x2 = 100;
		double y2 = 100;
		po2.x = (int) x2;
		po2.y = (int) y2;
		circ2.setPosition(po2);
		my.addShape(circ2);
		Shape qq [] = my.getShapes();
		my.save("omar.xml");
		my.undo();
		my.undo();
		Shape sh [] = my.getShapes();
		my.load("omar.xml");
		sh = my.getShapes();
		System.out.println(sh[0].getFillColor());
		sh[0].setColor(Color.WHITE);
		System.out.println(sh[0].getFillColor());
		System.out.println(sh.length);
		System.out.println(sh[0].getPosition());*/
	//	my.addShape(r);my.addShape(e);z
		//my.save("ahm.json");
	
		//System.out.println(r.borderColor.getRGB());
		
		
	}
}
