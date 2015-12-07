/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateTimeloggingData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = persistence.DAO.TimeloggingPersistentManager.instance().getSession().beginTransaction();
		try {
			domain.entity.EAzienda ldomainentityEAzienda = persistence.DAO.EAziendaDAO.loadEAziendaByQuery(null, null);
			// Update the properties of the persistent object
			persistence.DAO.EAziendaDAO.save(ldomainentityEAzienda);
			domain.entity.EConsulente ldomainentityEConsulente = persistence.DAO.EConsulenteDAO.loadEConsulenteByQuery(null, null);
			// Update the properties of the persistent object
			persistence.DAO.EConsulenteDAO.save(ldomainentityEConsulente);
			domain.entity.EDirezione ldomainentityEDirezione = persistence.DAO.EDirezioneDAO.loadEDirezioneByQuery(null, null);
			// Update the properties of the persistent object
			persistence.DAO.EDirezioneDAO.save(ldomainentityEDirezione);
			domain.entity.EManager ldomainentityEManager = persistence.DAO.EManagerDAO.loadEManagerByQuery(null, null);
			// Update the properties of the persistent object
			persistence.DAO.EManagerDAO.save(ldomainentityEManager);
			domain.entity.EProgetto ldomainentityEProgetto = persistence.DAO.EProgettoDAO.loadEProgettoByQuery(null, null);
			// Update the properties of the persistent object
			persistence.DAO.EProgettoDAO.save(ldomainentityEProgetto);
			domain.entity.ESottoprogetto ldomainentityESottoprogetto = persistence.DAO.ESottoprogettoDAO.loadESottoprogettoByQuery(null, null);
			// Update the properties of the persistent object
			persistence.DAO.ESottoprogettoDAO.save(ldomainentityESottoprogetto);
			domain.entity.ETariffa ldomainentityETariffa = persistence.DAO.ETariffaDAO.loadETariffaByQuery(null, null);
			// Update the properties of the persistent object
			persistence.DAO.ETariffaDAO.save(ldomainentityETariffa);
			domain.entity.ETask ldomainentityETask = persistence.DAO.ETaskDAO.loadETaskByQuery(null, null);
			// Update the properties of the persistent object
			persistence.DAO.ETaskDAO.save(ldomainentityETask);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateTimeloggingData retrieveAndUpdateTimeloggingData = new RetrieveAndUpdateTimeloggingData();
			try {
				retrieveAndUpdateTimeloggingData.retrieveAndUpdateTestData();
			}
			finally {
				persistence.DAO.TimeloggingPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
