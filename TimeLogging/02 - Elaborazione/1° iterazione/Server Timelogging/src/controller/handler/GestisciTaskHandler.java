package controller.handler;

import java.util.ArrayList;
import java.util.Iterator;

import Ice.Current;
import domain.entity.EAzienda;
import domain.entity.EConsulente;
import domain.entity.EProgetto;
import domain.entity.ESottoprogetto;
import domain.entity.ETask;

public class GestisciTaskHandler extends Handler._GestisciTaskHandlerDisp {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void creaTask(String aNomeProgetto, String aNomeSottoprogetto,
			String aDescrizione, int aIdConsulente,
			double quantita, String unita, String nomeTask, Current __current) {
			
			EAzienda azienda = EAzienda.getInstance();
			
			EConsulente consulente = azienda.selezionaConsulente(aIdConsulente);
			
			EProgetto progetto = azienda.selezionaProgetto(aNomeProgetto);
			
			ESottoprogetto sottoprogetto = progetto.selezionaSottoprogetto(aNomeSottoprogetto);
			
			sottoprogetto.aggiungiTask(nomeTask, aDescrizione, consulente, quantita, unita);
	}
	
	public void modificaTask(String aNomeProgetto, String aNomeSottoprogetto,
			String aDescrizione, String nomeTask, String oldNomeTask, Current __cuurent){
		
		EAzienda azienda = EAzienda.getInstance();
		
		EProgetto progetto = azienda.selezionaProgetto(aNomeProgetto);
		
		ESottoprogetto sottoprogetto = progetto.selezionaSottoprogetto(aNomeSottoprogetto);
		
		sottoprogetto.modificaTask(oldNomeTask, nomeTask, aDescrizione);
	
	}
	
	public void cancellaTask(String aNomeProgetto, String aNomeSottoprogetto, String nomeTask, Current __current){
		
		EAzienda azienda = EAzienda.getInstance();
		
		EProgetto progetto = azienda.selezionaProgetto(aNomeProgetto);
		
		ESottoprogetto sottoprogetto = progetto.selezionaSottoprogetto(aNomeSottoprogetto);
		
		sottoprogetto.eliminaTask(nomeTask);
	}
	
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

	@Override
	public String getConsulenti(Current __current) {
		String ret = "";
		EAzienda azienda = EAzienda.getInstance();
		Iterator<EConsulente> iterator = azienda.getElenco_consulenti().iterator();
	    while(iterator.hasNext()) {
	    	EConsulente c = iterator.next();
	    	ret += c.getIdConsulente()+"-"+c.getNomeConsulente()+";";
	    }
		return ret;
	}

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

	public String getInfoTask(String nomeProgetto,
			String nomeSottoprogetto, String nomeTask, Current __current){
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
		ret += String.valueOf(task.getTariffa().getQuantita())+";";
		ret += task.getTariffa().getUnita()+";";
		ret+= task.getConsulente().getNomeConsulente()+" "+task.getConsulente().getCognomeConsulente()+";";
		return ret;
	}


}