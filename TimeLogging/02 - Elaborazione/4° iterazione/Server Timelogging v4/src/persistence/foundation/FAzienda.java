package persistence.foundation;

import persistence.DAO.EAziendaDAO;
import domain.entity.EAzienda;

public class FAzienda {

	
	public EAzienda getAzienda(){
		XMLParser.setDocument(System.getProperty("user.home")+"/ConfigServer.xml");
        String azienda = XMLParser.parseXml("nome");
		EAzienda a = EAziendaDAO.getEAziendaByORMID(azienda);
		return a;
	}
	
	
}
