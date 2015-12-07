/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListTimeloggingData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing EAzienda...");
		domain.entity.EAzienda[] domainentityEAziendas = persistence.DAO.EAziendaDAO.listEAziendaByQuery(null, null);
		int length = Math.min(domainentityEAziendas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(domainentityEAziendas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing EConsulente...");
		domain.entity.EConsulente[] domainentityEConsulentes = persistence.DAO.EConsulenteDAO.listEConsulenteByQuery(null, null);
		length = Math.min(domainentityEConsulentes.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(domainentityEConsulentes[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing EDirezione...");
		domain.entity.EDirezione[] domainentityEDireziones = persistence.DAO.EDirezioneDAO.listEDirezioneByQuery(null, null);
		length = Math.min(domainentityEDireziones.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(domainentityEDireziones[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing EManager...");
		domain.entity.EManager[] domainentityEManagers = persistence.DAO.EManagerDAO.listEManagerByQuery(null, null);
		length = Math.min(domainentityEManagers.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(domainentityEManagers[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing EProgetto...");
		domain.entity.EProgetto[] domainentityEProgettos = persistence.DAO.EProgettoDAO.listEProgettoByQuery(null, null);
		length = Math.min(domainentityEProgettos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(domainentityEProgettos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing ESottoprogetto...");
		domain.entity.ESottoprogetto[] domainentityESottoprogettos = persistence.DAO.ESottoprogettoDAO.listESottoprogettoByQuery(null, null);
		length = Math.min(domainentityESottoprogettos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(domainentityESottoprogettos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing ETariffa...");
		domain.entity.ETariffa[] domainentityETariffas = persistence.DAO.ETariffaDAO.listETariffaByQuery(null, null);
		length = Math.min(domainentityETariffas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(domainentityETariffas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing ETask...");
		domain.entity.ETask[] domainentityETasks = persistence.DAO.ETaskDAO.listETaskByQuery(null, null);
		length = Math.min(domainentityETasks.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(domainentityETasks[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public static void main(String[] args) {
		try {
			ListTimeloggingData listTimeloggingData = new ListTimeloggingData();
			try {
				listTimeloggingData.listTestData();
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
