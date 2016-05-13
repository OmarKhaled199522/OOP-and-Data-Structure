package eg.edu.alexu.csd.oop.draw.cs07;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ellipse extends MyShape {

	private Map<String, Double> mapEllipse = new HashMap<String, Double>();

	public Ellipse() {
		getMapEllipse().put("ShortR", null);
		getMapEllipse().put("longR", null);
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

		while (it.hasNext()) {

			Map.Entry pair = (Map.Entry) it.next();
			// System.out.println(pair.getKey() + " = " + pair.getValue());
			double w = (double) pair.getValue();
			para[i++] = (int) w;

			// it.remove(); // avoids a ConcurrentModificationException
		}
		g.setColor(bo);
		g.fillOval(po.x, po.y, para[0], para[1]);
		g.setColor(fi);
		g.drawOval(po.x, po.y, para[0], para[1]);

	}

	public Map<String, Double> getMapEllipse() {
		return mapEllipse;
	}

	public void setMapEllipse(Map<String, Double> mapEllipse) {
		this.mapEllipse = mapEllipse;
	}

}
