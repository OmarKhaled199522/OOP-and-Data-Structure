package eg.edu.alexu.csd.oop.draw.cs07;

import eg.edu.alexu.csd.oop.draw.Shape;

public class Item {
	private Shape shape;
	private int pos;
	private Shape updated;
	private char state;

	public Item(Shape shape, char state, int pos, Shape updated) {
		this.pos = pos;
		this.shape = shape;
		this.updated = updated;
		this.state = state;
	}

	public Shape getShape() {
		return shape;
	}

	public int getPos() {
		return pos;
	}

	public Shape getUpdated() {
		return updated;
	}

	public char getState() {
		return state;
	}

}
