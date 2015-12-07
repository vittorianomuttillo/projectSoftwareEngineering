/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteTimeloggingData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = persistence.DAO.TimeloggingPersistentManager.instance().getSession().beginTransaction();
		try {
			domain.entity.EAzienda ldomainentityEAzienda = persistence.DAO.EAziendaDAO.loadEAziendaByQuery(null, null);
			// Delete the persistent object
			persistence.DAO.EAziendaDAO.delete(ldomainentityEAzienda);
			domain.entity.EConsulente ldomainentityEConsulente = persistence.DAO.EConsulenteDAO.loadEConsulenteByQuery(null, null);
			// Delete the persistent object
			persistence.DAO.EConsulenteDAO.delete(ldomainentityEConsulente);
			domain.entity.EDirezione ldomainentityEDirezione = persistence.DAO.EDirezioneDAO.loadEDirezioneByQuery(null, null);
			// Delete the persistent object
			persistence.DAO.EDirezioneDAO.delete(ldomainentityEDirezione);
			domain.entity.EManager ldomainentityEManager = persistence.DAO.EManagerDAO.loadEManagerByQuery(null, null);
			// Delete the persistent object
			persistence.DAO.EManagerDAO.delete(ldomainentityEManager);
			domain.entity.EProgetto ldomainentityEProgetto = persistence.DAO.EProgettoDAO.loadEProgettoByQuery(null, null);
			// Delete the persistent object
			persistence.DAO.EProgettoDAO.delete(ldomainentityEProgetto);
			domain.entity.ESottoprogetto ldomainentityESottoprogetto = persistence.DAO.ESottoprogettoDAO.loadESottoprogettoByQuery(null, null);
			// Delete the persistent object
			persistence.DAO.ESottoprogettoDAO.delete(ldomainentityESottoprogetto);
			domain.entity.ETariffa ldomainentityETariffa = persistence.DAO.ETariffaDAO.loadETariffaByQuery(null, null);
			// Delete the persistent object
			persistence.DAO.ETariffaDAO.delete(ldomainentityETariffa);
			domain.entity.ETask ldomainentityETask = persistence.DAO.ETaskDAO.loadETaskByQuery(null, null);
			// Delete the persistent object
			persistence.DAO.ETaskDAO.delete(ldomainentityETask);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteTimeloggingData deleteTimeloggingData = new DeleteTimeloggingData();
			try {
				deleteTimeloggingData.deleteTestData();
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
