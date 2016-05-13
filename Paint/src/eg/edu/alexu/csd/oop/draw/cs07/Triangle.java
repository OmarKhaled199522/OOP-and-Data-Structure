package eg.edu.alexu.csd.oop.draw.cs07;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Triangle extends MyShape {
	private Map<String, Double> maptri = new HashMap<String, Double>();

	public Triangle() {

		maptri.put("px2", null);
		maptri.put("py2", null);
		maptri.put("px3", null);
		maptri.put("py3", null);

		super.setProperties(maptri);
		map = maptri;
	}

	@Override
	public void draw(Graphics g) {

		Map<String, Double> maptri = getProperties();
		Iterator it = maptri.entrySet().iterator();

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
		g.fillPolygon(new int[] { po.x, para[0], para[2] }, new int[] { po.y,
				para[1], para[3] }, 3);
		g.setColor(fi);
		g.drawPolygon(new int[] { po.x, para[0], para[2] }, new int[] { po.y,
				para[1], para[3] }, 3);
	}

}
