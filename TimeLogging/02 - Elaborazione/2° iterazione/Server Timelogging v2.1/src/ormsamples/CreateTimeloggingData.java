/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateTimeloggingData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = persistence.DAO.TimeloggingPersistentManager.instance().getSession().beginTransaction();
		try {
			domain.entity.EAzienda ldomainentityEAzienda = persistence.DAO.EAziendaDAO.createEAzienda();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : elenco_progetti, instance, direzione, nomeAzienda
			persistence.DAO.EAziendaDAO.save(ldomainentityEAzienda);
			domain.entity.EConsulente ldomainentityEConsulente = persistence.DAO.EConsulenteDAO.createEConsulente();
			// Initialize the properties of the persistent object here
			persistence.DAO.EConsulenteDAO.save(ldomainentityEConsulente);
			domain.entity.EDirezione ldomainentityEDirezione = persistence.DAO.EDirezioneDAO.createEDirezione();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : elenco_dipendenti
			persistence.DAO.EDirezioneDAO.save(ldomainentityEDirezione);
			domain.entity.EManager ldomainentityEManager = persistence.DAO.EManagerDAO.createEManager();
			// Initialize the properties of the persistent object here
			persistence.DAO.EManagerDAO.save(ldomainentityEManager);
			domain.entity.EProgetto ldomainentityEProgetto = persistence.DAO.EProgettoDAO.createEProgetto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : elenco_sottoprogetti
			persistence.DAO.EProgettoDAO.save(ldomainentityEProgetto);
			domain.entity.ESottoprogetto ldomainentityESottoprogetto = persistence.DAO.ESottoprogettoDAO.createESottoprogetto();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : elenco_task
			persistence.DAO.ESottoprogettoDAO.save(ldomainentityESottoprogetto);
			domain.entity.ETariffa ldomainentityETariffa = persistence.DAO.ETariffaDAO.createETariffa();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : quantita
			persistence.DAO.ETariffaDAO.save(ldomainentityETariffa);
			domain.entity.ETask ldomainentityETask = persistence.DAO.ETaskDAO.createETask();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : consulente
			persistence.DAO.ETaskDAO.save(ldomainentityETask);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateTimeloggingData createTimeloggingData = new CreateTimeloggingData();
			try {
				createTimeloggingData.createTestData();
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
