package eg.edu.alexu.csd.oop.draw.cs07;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Iterator;
import java.util.Map;

public class Circle extends Ellipse {

	public Circle() {

		getMapEllipse().put("ShortR", null);
		super.setProperties(getMapEllipse());
		map = getMapEllipse();
	}

	@Override
	public void draw(Graphics g) {

		Map<String, Double> maprec = getProperties();
		Iterator it = maprec.entrySet().iterator();

		int para[] = new int[4];

		int i = 0;
		Color bo, fi;
		bo = getFillColor();
		fi = getColor();

		Point po = getPosition();

		while (it.hasNext() && i < 1) {

			Map.Entry pair = (Map.Entry) it.next();
			// System.out.println(pair.getKey() + " = " + pair.getValue());
			double w = (double) pair.getValue();
			para[i++] = (int) w;

			// it.remove(); // avoids a ConcurrentModificationException
		}
		g.setColor(bo);
		g.fillOval(po.x, po.y, para[0], para[0]);
		g.setColor(fi);
		g.drawOval(po.x, po.y, para[0], para[0]);

	}

}
