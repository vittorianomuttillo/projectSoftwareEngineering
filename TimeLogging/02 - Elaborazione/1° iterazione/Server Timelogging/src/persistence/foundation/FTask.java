package persistence.foundation;

import persistence.DAO.EProgettoDAO;
import persistence.DAO.ESottoprogettoDAO;
import persistence.DAO.ETariffaDAO;
import persistence.DAO.ETaskDAO;
import domain.entity.EProgetto;
import domain.entity.ESottoprogetto;
import domain.entity.ETask;

public class FTask {
	
	public ETask[] getTasksBySottoprogetto(String progetto, String sottoprogetto){
		EProgetto p = EProgettoDAO.listEProgettoByQuery("NomeProgetto='"+progetto+"'", null)[0];
		int idp = p.getIdProgetto();
		ESottoprogetto[] sp = ESottoprogettoDAO.listESottoprogettoByQuery("NomeSottoprogetto='"+sottoprogetto+"' AND EProgettoIdProgetto="+idp, null);
		int id = sp[0].getIdSottoprogetto();
		ETask[] t = ETaskDAO.listETaskByQuery("ESottoprogettoIdSottoprogetto="+id, null);
		return t;
	}

	public void save(ETask task) {
		ETaskDAO.save(task);
	}

	public void update(ETask t) {
		ETaskDAO.save(t);
		//ETaskDAO.refresh(t);
	}

	public void delete(ETask t) {
		
		ETaskDAO.delete(t);
		ETariffaDAO.delete(t.getTariffa());	
	}
	
	
	
}
