package controller.handler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import persistence.foundation.XMLParser;
import Ice.Current;
import domain.entity.EAzienda;
import domain.entity.EDipendente;
import domain.entity.EDirezione;
import domain.entity.EProgetto;
import domain.entity.ESottoprogetto;
import domain.entity.ETariffa;
import domain.entity.ETask;

public class GestisciTaskHandler extends Handler._GestisciTaskHandlerDisp {
	
	private static final long serialVersionUID = 1L;
		
	@SuppressWarnings("unchecked")
	@Override
	public String getSottoprogetti(int idManager, Current __current) {
		String ret = "";
		EAzienda azienda = EAzienda.getInstance();
		ArrayList<String> sp = new ArrayList<String>();
		Iterator<EProgetto> iterator = azienda.getElenco_progetti().iterator();
	    while(iterator.hasNext()) {
	    	EProgetto p = iterator.next();
	        sp.addAll(p.getSottoprogettiByManager(idManager));
	    }
		for (int i=0; i<sp.size(); i++){
			ret += sp.get(i)+";";
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getDipendenti(Current __current) {
		ArrayList<String> dip = XMLParser.parseDip();
		
		String ret = "";
		EAzienda azienda = EAzienda.getInstance();
		EDirezione direzione = azienda.getDirezione();
		
		Iterator<EDipendente> iterator = direzione.getElenco_dipendenti().iterator();
	    while(iterator.hasNext()) {
	    	EDipendente c = iterator.next();
	    	if (dip.contains(c.getTipo()))
	    			ret += c.getIdDipendente()+"-"+c.getNomeDipendente()+";";
	    }
	    
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getInfoSottoprogetto(String nomeProgetto,
			String nomeSottoprogetto, Current __current) {
		String ret = "";
		
		EAzienda azienda = EAzienda.getInstance();
		EProgetto progetto = azienda.selezionaProgetto(nomeProgetto);
		ESottoprogetto sottoprogetto = progetto.selezionaSottoprogetto(nomeSottoprogetto);
		Iterator<ETask> iterator = sottoprogetto.getElenco_task().iterator();
	    while(iterator.hasNext()) {
	    	ETask ti = iterator.next();
	    	ret += ti.getNomeTask()+";";
	    }
		return ret;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getInfoTask(String nomeProgetto, String nomeSottoprogetto,
			String nomeTask, Current __current) {
		
		String ret = "";
		EAzienda azienda = EAzienda.getInstance();
		EProgetto progetto = azienda.selezionaProgetto(nomeProgetto);
		ESottoprogetto sottoprogetto = progetto.selezionaSottoprogetto(nomeSottoprogetto);
		ETask task = null;
		Iterator<ETask> iterator = sottoprogetto.getElenco_task().iterator();
	    while(iterator.hasNext()) {
	    	ETask ti = iterator.next();
	        if (ti.getNomeTask().equals(nomeTask))
	        	task = ti;
	    }
		
		ret += task.getNomeTask()+";";
		ret += task.getDescrizione()+";";
		EDipendente[] consulenti = task.geteDipendentes();
		for (EDipendente dip: consulenti){
			ret += dip.getNomeDipendente()+" "+dip.getCognomeDipendente()+"-"+String.valueOf(dip.getIdDipendente())+";";
		}
		return ret;
		
	}

	@Override
	public void cancellaTask(String aNomeProgetto, String aNomeSottoprogetto,
			String nomeTask, Current __current) {

		EAzienda azienda = EAzienda.getInstance();
		
		EProgetto progetto = azienda.selezionaProgetto(aNomeProgetto);
		
		ESottoprogetto sottoprogetto = progetto.selezionaSottoprogetto(aNomeSottoprogetto);
		
		sottoprogetto.eliminaTask(nomeTask);
		
	}

	@Override
	public void modificaTask(String aNomeProgetto, String aNomeSottoprogetto,
			String aDescrizione, String nomeTask, String oldNomeTask,
			Current __current) {
		
		EAzienda azienda = EAzienda.getInstance();
		
		EProgetto progetto = azienda.selezionaProgetto(aNomeProgetto);
		
		ESottoprogetto sottoprogetto = progetto.selezionaSottoprogetto(aNomeSottoprogetto);
		
		sottoprogetto.modificaTask(oldNomeTask, nomeTask, aDescrizione);
		
	}

	@Override
	public List<String[]> aggiornaElencoDipendenti(List<String[]> elencoDip,
			int idDipendente, String unita, double quantita, Current __current) {
		String[] el = new String[3];
		el[0] = String.valueOf(idDipendente);
		el[1] = String.valueOf(unita);
		el[2] = String.valueOf(quantita);
		elencoDip.add(el);
		return elencoDip;
	}

	@Override
	public void creaTask(String NomeProgetto, String NomeSottoprogetto,
			String Descrizione, List<String[]> IdDipendente, String nomeTask,
			Current __current) {
		EAzienda azienda = EAzienda.getInstance();
		
		EProgetto progetto = azienda.selezionaProgetto(NomeProgetto);
		
		ESottoprogetto sottoprogetto = progetto.selezionaSottoprogetto(NomeSottoprogetto);
		
		sottoprogetto.aggiungiTask(nomeTask, Descrizione, IdDipendente);
		
	}

	@Override
	public void aggiungiDipendente(String aNomeProgetto,
			String aNomeSottoprogetto, String nomeTask, int IdDipendente, String unita, double quantita,
			Current __current) {

		EAzienda azienda = EAzienda.getInstance();
		
		EProgetto progetto = azienda.selezionaProgetto(aNomeProgetto);
		
		ESottoprogetto sottoprogetto = progetto.selezionaSottoprogetto(aNomeSottoprogetto);
		
		ETask task = sottoprogetto.selezionaTask(nomeTask);
		
		ETariffa tariffa = new ETariffa(quantita, unita);
				
		task.aggiungiDip(IdDipendente, tariffa);
		
	}

	@Override
	public void eliminaDipendente(String aNomeProgetto,
			String aNomeSottoprogetto, String nomeTask, int IdDipendente,
			Current __current) {

		EAzienda azienda = EAzienda.getInstance();
		
		EProgetto progetto = azienda.selezionaProgetto(aNomeProgetto);
		
		ESottoprogetto sottoprogetto = progetto.selezionaSottoprogetto(aNomeSottoprogetto);	
		
		ETask task = sottoprogetto.selezionaTask(nomeTask);
		
		task.eliminaDip(IdDipendente);
		
	}

	@Override
	public void sostituisciDipendente(String aNomeProgetto,
			String aNomeSottoprogetto, String nomeTask, int IdDipendente, String unita, double quantita,
			int IdDipendenteOld, Current __current) {

		EAzienda azienda = EAzienda.getInstance();
		
		EProgetto progetto = azienda.selezionaProgetto(aNomeProgetto);
		
		ESottoprogetto sottoprogetto = progetto.selezionaSottoprogetto(aNomeSottoprogetto);

		ETask task = sottoprogetto.selezionaTask(nomeTask);
		
		ETariffa tariffa = new ETariffa(quantita, unita);
		
		task.sostituisciDip(IdDipendente, tariffa, IdDipendenteOld);
	}
	
	
	
}