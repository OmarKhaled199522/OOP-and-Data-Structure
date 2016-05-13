package eg.edu.alexu.csd.oop.draw.cs07;

import java.util.*;
import java.util.Map.Entry;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import eg.edu.alexu.csd.oop.draw.Shape;


public class WritingXML {
	
	MyDrawingEngine engine = MyDrawingEngine.getInstance();
	
	Shape arr[] = {new Ellipse(), new Circle(),new Rectangle() };
	 
	
	public Shape[] getArr() {
		return arr;
	}


	public void setArr(Shape[] arr) {
		this.arr = arr;
	}

	public  void saveXML(String xml) {
		  try {
			  
			  DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			  DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			  Document doc = docBuilder.newDocument();
			  Element root = doc.createElement("Shape");
			  doc.appendChild(root);
			  
			  for (int i=0;i<arr.length;i++){
				  if (arr[i] == null)continue;
				  Element shape = doc.createElement("ShapeElement");
				  root.appendChild(shape);
				  Element type = doc.createElement("type");
				  type.appendChild(doc.createTextNode(arr[i].getClass().getName()));
				  shape.appendChild(type);
			try{	  for (Entry<String, Double> entry   : arr[i].getProperties().entrySet())
				  {
				     String key = entry.getKey();
				     Double value = entry.getValue();
				     Element par = doc.createElement(key);
				     par.appendChild(doc.createTextNode(""+value));
				     shape.appendChild(par);
				     
				  }
			}
			catch(Exception e){
				Element par = doc.createElement("Empty");
				par.appendChild(doc.createTextNode("empty"));
				shape.appendChild(par);
			}
				  Element pos= doc.createElement("position");
				  if (arr[i].getPosition() == null) pos.appendChild(doc.createTextNode(""+"null"+","+"null"));
				  else{
				  pos.appendChild(doc.createTextNode(""+arr[i].getPosition().x + "," +arr[i].getPosition().y));
				  }
				  shape.appendChild(pos);
				  Element bColor = doc.createElement("BorderColor");
				  
				  try{
						bColor.appendChild(doc.createTextNode(Integer.toString(arr[i].getColor().getRGB() ) ));
					}
					catch(Exception e){
						bColor.appendChild(doc.createTextNode("null" ));
					//	System.out.println("color");
					}
				  
				  
				  shape.appendChild(bColor);
				  
				  Element fColor = doc.createElement("FillColor");
				  try{
						fColor.appendChild(doc.createTextNode(Integer.toString(arr[i].getFillColor().getRGB() ) ));
					}
					catch(Exception e){
						fColor.appendChild(doc.createTextNode("null" ));
						//System.out.println("color");
					}
				  
				  shape.appendChild(fColor);
			  }
			  
			  //for the mapp
			  
			  try{
				  Element m = doc.createElement("MAP");
				  root.appendChild(m);
			  for (Entry<String, Integer> entry   : MyDrawingEngine.getInstance().getMapp().entrySet())
			  {
			     String key = entry.getKey();
			     int value = entry.getValue();
			     Element par = doc.createElement(key);
			     par.appendChild(doc.createTextNode(""+value));
			     m.appendChild(par); 
			  }
			  }
			  catch (Exception e){
				  System.out.println("mError");
			  }
			  
			  
			  
			  TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(xml));
				
			//	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				//transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
				transformer.transform(source, result);
			  
			  
		  } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	}

