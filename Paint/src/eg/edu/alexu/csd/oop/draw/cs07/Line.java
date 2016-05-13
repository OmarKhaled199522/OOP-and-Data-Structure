package eg.edu.alexu.csd.oop.draw.cs07;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Line extends MyShape {
/*	private double sx2 , sy2 , rotation  ;
	private Color borderColor , fillColor;
	private Point pos;*/
	private Map< String , Double> mapline = new HashMap<String, Double>();
	
	
	public Line() {
	
		
		mapline.put("sx2", null);
		mapline.put("sy2", null);
		
		super.setProperties(mapline);
		map = mapline;
	}

	@Override
	public void draw(Graphics g) {
		
	     
	     Map< String , Double> mapline = getProperties();
	     Iterator it = mapline.entrySet().iterator();
		 
	     int para [] = new int [4];
	    
	     int i = 0;
	     Color bo, fi;
	     //bo = getFillColor();
	     fi = getColor();
	     
	     Point po = getPosition();
	     
		 while (it.hasNext()) {
		    	
	        Map.Entry pair = (Map.Entry)it.next();
	        //System.out.println(pair.getKey() + " = " + pair.getValue());
	        double w = (double) pair.getValue();
	        para[i++] = (int) w;
	        
		      
		    //it.remove(); // avoids a ConcurrentModificationException
		}
		 
		 g.setColor(fi);
		// g.drawLine(po.x , po.y , para[0] , para[1] );
		 ((Graphics2D) g).draw(new Line2D.Double(po.x, po.y , para[0], para[1]));
	}
	
}
