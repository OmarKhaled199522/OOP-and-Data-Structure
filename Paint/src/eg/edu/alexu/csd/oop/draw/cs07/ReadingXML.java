package eg.edu.alexu.csd.oop.draw.cs07;

import java.util.*;
import java.util.Map.Entry;
import java.awt.Point;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import eg.edu.alexu.csd.oop.draw.Shape;

public class ReadingXML {
	private Shape arr[];
	private Map<String, Integer> map = new HashMap<String, Integer>();

	public Map<String, Integer> getMap() {
		return map;
	}

	public Shape[] getArr() {
		return arr;
	}

	public void setArr(Shape[] arr) {
		this.arr = arr;
	}

	public void readXML(String xml) throws ParserConfigurationException,
			SAXException, IOException {
		try {

			File fXmlFile = new File(xml);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			Factory_Of_Shapes f = new Factory_Of_Shapes();
			doc.getDocumentElement().normalize();
			NodeList list = doc.getElementsByTagName("ShapeElement");
			arr = new Shape[list.getLength()];

			for (int i = 0; i < list.getLength(); i++) {

				org.w3c.dom.Node n = list.item(i);

				if (n.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) n;
					Map<String, Double> map = new HashMap<String, Double>();
					Shape h = f.bringShape(eElement
							.getElementsByTagName("type").item(0)
							.getTextContent());

					arr[i] = h;
					boolean flag = false;
					String check = "";
					try {
						check = eElement.getElementsByTagName("Empty").item(0)
								.getTextContent();
					} catch (Exception e) {
						System.out.println("not found");
					}
					// System.out.println(list.getLength());

					if (check.equalsIgnoreCase("empty")) {
						// System.out.println("oo");
						arr[i].setProperties(null);
						flag = true;
					} else {
						for (Entry<String, Double> entry : h.getProperties()
								.entrySet()) {
							String key = entry.getKey();
							String value = eElement.getElementsByTagName(key)
									.item(0).getTextContent();

							if (!value.equalsIgnoreCase("null")) {

								map.put(key,
										(Double) (Double.parseDouble(value)));

							} else {
								map.put(key, null);
							}

						}
					}

					if (!flag)
						arr[i].setProperties(map);
					flag = false;

					String bColor = eElement
							.getElementsByTagName("BorderColor").item(0)
							.getTextContent();
					String fColor = eElement.getElementsByTagName("FillColor")
							.item(0).getTextContent();
					if (!bColor.equalsIgnoreCase("null"))
						arr[i].setColor(new Color(Integer.parseInt(bColor)));
					else
						arr[i].setColor(null);
					if (!fColor.equalsIgnoreCase("null"))
						arr[i].setFillColor(new Color(Integer.parseInt(fColor)));
					else
						arr[i].setFillColor(null);
					String position = eElement.getElementsByTagName("position")
							.item(0).getTextContent();
					String[] parts = position.split(",");
					Point x;
					try {
						x = new Point(Integer.parseInt(parts[0]),
								Integer.parseInt(parts[1]));
						arr[i].setPosition(x);
					} catch (Exception e) {
					}

				}

			}

			try {
				NodeList mapList = doc.getElementsByTagName("MAP");
				org.w3c.dom.Node mapN = mapList.item(0);
				if (mapN.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) mapN;
					NodeList myList = eElement.getChildNodes();
					for (int i = 0; i < myList.getLength(); i++) {
						Element e = (Element) myList.item(i);
						map.put(e.getNodeName(), null);
					}
					for (Entry<String, Integer> entry : map.entrySet()) {
						String key = entry.getKey();
						String value = eElement.getElementsByTagName(key)
								.item(0).getTextContent();
						System.out.println(value);
						map.put(key, Integer.parseInt(value));
					}
				}
			} catch (Exception e) {
				// System.out.println("mapE");
			}

		} catch (Exception e) {
			// System.out.println("Error");
		}
	}

}
