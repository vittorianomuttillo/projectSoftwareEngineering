package controller.handler;

import java.util.Set;

import domain.entity.EAzienda;
import domain.entity.EDipendente;
import domain.entity.EProgetto;
import domain.entity.ESottoprogetto;
import domain.entity.ETask;
import Ice.Current;

public class InserisciTimerecordHandler extends Handler._InserisciTimerecordHandlerDisp {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public String getElencoTask(int id, Current __current) {
		
		String ret = "";
		EAzienda azienda = EAzienda.getInstance();
		Set<EProgetto> progetto = azienda.getElenco_progetti();
		
		for(EProgetto pro : progetto){
			
			Set<ESottoprogetto> sottoprogetto = pro.getElenco_sottoprogetti();
			for(ESottoprogetto sottopro : sottoprogetto){
				
				Set<ETask> task = sottopro.getElenco_task();
				for (ETask t : task){
					
					EDipendente[] dips = t.geteDipendentes();
					for (EDipendente d : dips){
						
						if (d.getIdDipendente() == id){
							
							ret += pro.getNomeProgetto()+"-"+sottopro.getNomeSottoprogetto()+"-"+t.getNomeTask()+"-"+t.getIdTask()+";";
							
						}
						
					}
					
				}
				
			}
			
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean inserisciTimerecord(String descrizione,
			long datai, long dataf, long secondi, String nomeTask, String sottoprogetto, String progetto, int idDip,
			Current __current) {
		
		EAzienda azienda = EAzienda.getInstance();
		EProgetto pro = azienda.selezionaProgetto(progetto);
		ESottoprogetto sottopro = pro.selezionaSottoprogetto(sottoprogetto);
		Set<ETask> iterator = sottopro.getElenco_task();
	   for (ETask ti : iterator){
	        if (ti.getNomeTask().equals(nomeTask)){
	        	ti.aggiungiTimerecord(descrizione, datai, dataf, secondi, idDip);
	        	return true;
	        }
	    }
		
		return false;
	}

}
