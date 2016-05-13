package eg.edu.alexu.csd.oop.draw.cs07;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import java.util.Map;

public class Square extends Rectangle {
	
/*	public Square(Point pos,double len , double rot,Color borderColor , Color fillColor){
		super(pos,len , len , rot , borderColor,fillColor);
	}
	*/
	public Square() {
		
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
	     
		 while (it.hasNext() && i < 1) {
		    	
	        Map.Entry pair = (Map.Entry)it.next();
	        //System.out.println(pair.getKey() + " = " + pair.getValue());
	        double w = (double) pair.getValue();
	        para[i++] = (int) w;
	        
		      
		   
		}
		 g.setColor(bo);
		 g.fillRect(po.x , po.y , para[0] , para[0] ); 
		 g.setColor(fi);
		 g.drawRect(po.x , po.y , para[0] , para[0] );
	    
		
	}
	
}
