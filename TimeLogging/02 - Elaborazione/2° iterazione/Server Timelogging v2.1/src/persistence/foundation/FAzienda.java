package persistence.foundation;

import persistence.DAO.EAziendaDAO;
import domain.entity.EAzienda;

public class FAzienda {

	
	public EAzienda getAzienda(){
		Util.setDocument(System.getProperty("user.home")+"\\Config.xml");
        String azienda = Util.parseXml("nome");
		EAzienda a = EAziendaDAO.getEAziendaByORMID(azienda);
		return a;
	}
	
	
}
