package persistence.foundation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLParser {

	public static Document config;
	
	public static void setDocument(String path){
		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			XMLParser.config = doc;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public static String parseXml(String tag){
		//carico in host il contenuto del tag host del file config.xml
		XMLParser.config.getDocumentElement().normalize();
		NodeList iceHost = XMLParser.config.getElementsByTagName(tag);
		return iceHost.item(0).getTextContent();
	}
	
	public static ArrayList<String> parseDip(){
		XMLParser.config.getDocumentElement().normalize();
		NodeList iceHost = XMLParser.config.getElementsByTagName("dip");
		ArrayList<String> a = new ArrayList<String>();
		for (int i=0; i<iceHost.getLength(); i++)
			a.add(iceHost.item(i).getTextContent());
		return a;
	}
	
	public static ArrayList<String> parseStip(String tipo){		
		XMLParser.config.getDocumentElement().normalize();
		NodeList iceHost = XMLParser.config.getElementsByTagName("stip"+tipo);
		ArrayList<String> a = new ArrayList<String>();
		for (int i=0; i<iceHost.getLength(); i++)
			a.add(iceHost.item(i).getTextContent());
		return a;
		
	}
	
	public static HashMap<String,String> parseLevel(String tipo){		
		XMLParser.config.getDocumentElement().normalize();
		NodeList iceHost = XMLParser.config.getElementsByTagName("livelli_salariali");
		HashMap<String, String> a = new HashMap<String,String>();
		NodeList child = iceHost.item(0).getChildNodes();
		for (int i=0; i<child.getLength(); i++)
			a.put(child.item(i).getNodeName(), child.item(i).getTextContent());	
		//System.out.println(a.get("alto"));
		return a;
		
	}
	
	
	
}
