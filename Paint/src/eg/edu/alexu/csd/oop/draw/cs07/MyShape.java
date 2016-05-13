package eg.edu.alexu.csd.oop.draw.cs07;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.*;


import eg.edu.alexu.csd.oop.draw.Shape;

public class MyShape implements Shape{
	 
	Map<String,Double> map ;
	 Point pos ;
	 Color borderColor ,fillColor;
	 
	 
	@Override
	public void setPosition(Point position) {
		
		pos = position;
		
	}

	@Override
	public Point getPosition() {
		
		return pos;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		
		map = properties;
		
	}

	@Override
	public Map<String, Double> getProperties() {
		return map;
	}

	@Override
	public void setColor(Color color) {
		
		borderColor = color;
	}

	@Override
	public Color getColor() {
		
		return borderColor;
	}

	@Override
	public void setFillColor(Color color) {
		
		fillColor = color;
		
	}

	@Override
	public Color getFillColor() {
		
		return fillColor;
	}

	@Override
	public void draw(Graphics canvas) {
		
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
	
		return this.clone();
	}
}
