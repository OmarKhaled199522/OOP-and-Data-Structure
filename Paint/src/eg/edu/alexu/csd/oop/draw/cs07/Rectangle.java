package eg.edu.alexu.csd.oop.draw.cs07;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Rectangle extends MyShape {
	
	private Map< String , Double> mapRectangle = new HashMap<String, Double>();
	
	public Rectangle() {
	
		
		getMapRectangle().put("length", null);
		getMapRectangle().put("width", null);
		
		super.setProperties(getMapRectangle());
		map = getMapRectangle();
	}

	@Override
	public void draw(Graphics g) {

	     Map< String , Double> maprec = getProperties();
	     Iterator it = maprec.entrySet().iterator();
		 
	     int para [] = new int [4];
	    
	     int i = 0;
	     Color bo, fi;
	     bo = getFillColor();
	     fi = getColor();
	     
	     Point po = getPosition();
	     
		 while (it.hasNext()) {
		    	
	        Map.Entry pair = (Map.Entry)it.next();
	        double w = (double) pair.getValue();
	        para[i++] = (int) w;
	        
		}
		 g.setColor(bo);
		 g.fillRect(po.x , po.y , para[0] , para[1] ); 
		 g.setColor(fi);
		 g.drawRect(po.x , po.y , para[0] , para[1] );
	    
	}

	public Map< String , Double> getMapRectangle() {
		return mapRectangle;
	}

	public void setMapRectangle(Map< String , Double> mapRectangle) {
		this.mapRectangle = mapRectangle;
	}
	
}
