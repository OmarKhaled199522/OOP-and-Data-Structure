package eg.edu.alexu.csd.oop.draw.cs07;

import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import eg.edu.alexu.csd.oop.draw.Shape;

public class Json {
	private Shape arr[];
	private Shape read[] = new Shape[100];
	private Map<String, Integer> mapp = new HashMap<String, Integer>();
	Factory_Of_Shapes f = new Factory_Of_Shapes();

	public Map<String, Integer> getMapp() {
		return mapp;
	}

	public Shape[] getRead() {
		int size = 0;
		for (int i = 0; i < read.length; i++) {
			if (read[i] != null)
				size++;
			else
				break;
		}
		Shape returned[] = new Shape[size];
		returned = Arrays.copyOfRange(read, 0, size);
		return returned;
	}

	public void setArr(Shape[] arr) {
		this.arr = arr;
	}

	public void writeJson(String file) {
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter(file));
			w.write("{{\"Shapes\" : [");
			w.newLine();
			for (int i = 0; i < arr.length; i++) {
				// if (arr[i] == null)continue;
				w.write("    \"ShapeElement\" : {");
				w.newLine();
				w.write("       {\"type\" : " + arr[i].getClass().getName()
						+ "},");
				w.newLine();
				try {
					w.write("       {\"position\" : " + arr[i].getPosition().x
							+ "," + arr[i].getPosition().y + "},");
				} catch (Exception e) {
					w.write("       {\"position\" : " + "null" + "," + "null"
							+ "},");
				}
				w.newLine();
				try {
					// int zzz = arr[i].getColor().getRGB();
					w.write("       {\"BorderColor\" : "
							+ Integer.toString(arr[i].getColor().getRGB())
							+ "},");
				} catch (Exception e) {
					w.write("       {\"BorderColor\" : " + "null" + "},");
					System.out.println("color");
				}
				w.newLine();
				try {
					// int zzz = arr[i].getFillColor().getRGB();
					w.write("       {\"FillColor\" : "
							+ Integer.toString(arr[i].getFillColor().getRGB())
							+ "}");
				} catch (Exception e) {
					w.write("       {\"FillColor\" : " + "null" + "},");
					// System.out.println("color");
				}
				try {
					for (Entry<String, Double> entry : arr[i].getProperties()
							.entrySet()) {
						System.out.println("sorry");
						w.newLine();
						w.write("       {\"" + entry.getKey() + "\" : "
								+ entry.getValue() + "},");
						// w.newLine();
					}
				} catch (Exception e) {
					w.newLine();
					w.write("       {\"" + "Empty" + "\" : " + "empty" + "}");

				}

				w.newLine();
				w.write("    }");
				if (i != arr.length - 1)
					w.write(",");
				w.newLine();
			}
			w.write("  ]");
			w.newLine();
			w.write(" },");
			w.newLine();
			try {

				w.write("  \"MAP\" : {");
				w.newLine();
				int cnt = 0;
				for (Entry<String, Integer> entry : MyDrawingEngine
						.getInstance().getMapp().entrySet()) {
					String key = entry.getKey();
					Integer value = entry.getValue();
					cnt++;
					w.write("    {\"" + key + "\" : " + value + "}");
					if (cnt != MyDrawingEngine.getInstance().getMapp().size())
						w.write(",");
					w.newLine();

				}
				w.write(" }");
				w.newLine();
				w.write("}");
				w.newLine();
			} catch (Exception e) {
				// System.out.println("maperror");
			}
			w.close();
		} catch (Exception e) {
			// System.out.println("Werror");
		}
	}

	public void readJson(String path) throws IOException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException {
		int cnt = 0;
		BufferedReader r = new BufferedReader(new FileReader(path));
		String line = "";
		line = r.readLine();
		while (/* line!= null && */!line.equalsIgnoreCase("  ]")) {
			while (line.contains("Shapes") || line.contains("ShapeElement"))
				line = r.readLine();
			read[cnt] = this.bringClass(line);
			line = r.readLine();
			read[cnt].setPosition(this.getPos(line));
			line = r.readLine();
			read[cnt].setColor(this.bringColor(line));
			line = r.readLine();

			read[cnt].setFillColor(this.bringColor(line));
			Map<String, Double> map = new HashMap<String, Double>();
			line = r.readLine();
			boolean flag = false;
			while (!line.equalsIgnoreCase("    }")
					&& !line.equalsIgnoreCase("    },")
					&& !line.equalsIgnoreCase("  ]")) {
				if (line.contains("Empty")) {
					read[cnt].setPosition(null);
					line = r.readLine();
					flag = true;
					break;
				}
				this.setMap(line, map);
				line = r.readLine();
			}

			if (!flag)
				read[cnt].setProperties(map);
			flag = false;
			cnt++;
			line = r.readLine();
		}

		try {
			line = r.readLine();
			line = r.readLine();
			line = r.readLine();
			while (!line.equalsIgnoreCase(" }")) {
				String[] n = line.split(":");
				char[] letters1 = n[0].toCharArray();
				char[] letters2 = n[1].toCharArray();
				String key = "", value = "";
				for (int i = 0; i < letters2.length; i++) {
					if ((letters2[i] >= '0' && letters2[i] <= '9')
							|| (letters2[i] >= '0' && letters2[i] <= '9')
							|| letters2[i] == '-' || letters2[i] == '.') {
						value += letters2[i];
					}

				}
				for (int i = 0; i < letters1.length; i++) {
					if ((letters1[i] >= 'a' && letters1[i] <= 'z')
							|| (letters1[i] >= 'A' && letters1[i] <= 'Z')
							|| (letters1[i] >= '0' && letters1[i] <= '9'))
						key += letters1[i];
				}
				if (value == "") {
					mapp.put(key, null);
				} else
					mapp.put(key, Integer.parseInt(value));
				line = r.readLine();

			}

		} catch (Exception e) {
			// System.out.println("RError");
		}
		r.close();

	}

	public Point getPos(String line) {
		String x = "", y = "";
		char letters[] = line.toCharArray();
		boolean flag = false;
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] == ',')
				flag = true;
			if ((letters[i] >= '0' && letters[i] <= '9')
					|| (letters[i] >= '0' && letters[i] <= '9')
					|| letters[i] == '-' || letters[i] == '.') {
				if (!flag) {
					x += letters[i];
				} else {
					y += letters[i];
					// break;
				}
			}
		}
		if (x.equalsIgnoreCase("") && y.equalsIgnoreCase("")) {
			return null;
		}
		double px = Double.parseDouble(x);
		double py = Double.parseDouble(y);
		return new Point((int) px, (int) py);

	}

	public Shape bringClass(String line) throws InstantiationException,
			IllegalAccessException, ClassNotFoundException {
		String[] parts = line.split("\"");
		char[] letters = parts[2].toCharArray();
		String value = "";
		for (int i = 0; i < parts[2].length(); i++) {
			if ((letters[i] >= 'a' && letters[i] <= 'z')
					|| (letters[i] >= 'A' && letters[i] <= 'Z')
					|| letters[i] == '.'
					|| ((letters[i] >= '0' && letters[i] <= '9') || (letters[i] >= '0' && letters[i] <= '9')))
				value += letters[i];
		}
		return f.bringShape(value);
	}

	public Color bringColor(String line) {
		char letters[] = line.toCharArray();
		String value = "";
		for (int i = 0; i < letters.length; i++) {
			if ((letters[i] >= '0' && letters[i] <= '9')
					|| (letters[i] >= '0' && letters[i] <= '9')
					|| letters[i] == '-' || letters[i] == '.') {
				value += letters[i];
			}
		}
		if (value.equalsIgnoreCase(""))
			return null;
		return new Color(Integer.parseInt(value));
	}

	public void setMap(String line, Map<String, Double> map) {
		char[] letters = line.toCharArray();
		String key = "", value = "";
		for (int i = 0; i < letters.length; i++) {
			if ((letters[i] >= '0' && letters[i] <= '9')
					|| (letters[i] >= '0' && letters[i] <= '9')
					|| letters[i] == '-' || letters[i] == '.') {
				value += letters[i];
			}
			if ((letters[i] >= 'a' && letters[i] <= 'z')
					|| (letters[i] >= 'A' && letters[i] <= 'Z'))
				key += letters[i];
		}
		if (value == "") {
			map.put(key, null);
		} else
			map.put(key, Double.parseDouble(value));

	}

}