package main;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import Handler.ProxieFactory;
import ui.home.Splash;

import java.io.File;

public class Client {
	
	public static Ice.Communicator ic;
	
	public static void main(String[] args)
    {
		
		try
        {
			
			try {
				//parsifico il file config.xml in doc
				File fXmlFile = new File(System.getProperty("user.home")+"\\Config.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
				doc.getDocumentElement().normalize();
				System.out.println(doc+"asddsa");
				
				//carico in host il contenuto del tag host del file config.xml
				NodeList iceHost = doc.getElementsByTagName("iceHost");
				String host = iceHost.item(0).getTextContent();

				
				//carico in port il contenuto del tag port del file config.xml
				NodeList icePort = doc.getElementsByTagName("icePort");
				String port = icePort.item(0).getTextContent();
				
				//carico in protocol il contenuto del tag protocol del file config.xml
				NodeList iceProtocol = doc.getElementsByTagName("iceProtocol");				
				String protocol = iceProtocol.item(0).getTextContent();			
				
				Ice.Communicator communicator;
	            communicator = Ice.Util.initialize();
	            Client.ic = communicator;
	            
	            ProxieFactory.setHost(host);
	            ProxieFactory.setPort(port);
	            ProxieFactory.setProtocol(protocol);
	            
	            Splash splash = new Splash();
	    		splash.start();
				}
	        	catch(Ice.LocalException ex)
	        	{
	            System.out.println(ex.ice_name());
	        	}
	    		
			} catch (Exception e) {
				e.printStackTrace();
			}
	
    }

	public static Ice.Communicator getIc() {
		return ic;
	}

	public static void setIc(Ice.Communicator ic) {
		Client.ic = ic;
	}


}
