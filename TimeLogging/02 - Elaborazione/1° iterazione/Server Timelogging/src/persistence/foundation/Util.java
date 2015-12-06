package persistence.foundation;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import persistence.DAO.TimelogginPersistentManager;

public class Util {

	private static PersistentSession session;
	public static Document config;
	
	public static PersistentSession getSession() {
		try {
			session = TimelogginPersistentManager.instance().getSession();
		} catch (PersistentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}
	
	public static void setDocument(String path){
		File fXmlFile = new File(path);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		Document doc = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(fXmlFile);
			Util.config = doc;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public static String parseXml(String tag){
		//carico in host il contenuto del tag host del file config.xml
		Util.config.getDocumentElement().normalize();
		NodeList iceHost = Util.config.getElementsByTagName(tag);
		return iceHost.item(0).getTextContent();
	}
	
	
}
