package eg.edu.alexu.csd.oop.draw.cs07;

import eg.edu.alexu.csd.oop.draw.Shape;

public class Factory_Of_Shapes {

	public  Shape create(String s) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {

		Class plugin = Class.forName("eg.edu.alexu.csd.oop.draw" + s);
		Shape newShape = (Shape) plugin.newInstance();
		return newShape;
	}

	public Shape bringShape(String className) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {

		Class c = Class.forName(className);
		Shape shape = (Shape) c.newInstance();
		return shape;

	}
}
