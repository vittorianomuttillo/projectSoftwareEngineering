/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package domain.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import persistence.foundation.FDipendente;
import persistence.foundation.FTariffa;
import persistence.foundation.FTask;

public class ESottoprogetto implements Serializable {

	private static final long serialVersionUID = 1L;

	public ESottoprogetto() {
	}
	
	private int idSottoprogetto;
	
	private domain.entity.EManager manager;
	
	private String nomeSottoprogetto;
	
	private java.util.Set elenco_task = new java.util.HashSet();
	
	private void setIdSottoprogetto(int value) {
		this.idSottoprogetto = value;
	}
	
	public int getIdSottoprogetto() {
		return idSottoprogetto;
	}
	
	public int getORMID() {
		return getIdSottoprogetto();
	}
	
	public void setNomeSottoprogetto(String value) {
		this.nomeSottoprogetto = value;
	}
	
	public String getNomeSottoprogetto() {
		return nomeSottoprogetto;
	}
	
	public void setManager(domain.entity.EManager value) {
		this.manager = value;
	}
	
	public domain.entity.EManager getManager() {
		return manager;
	}
	
	public void setElenco_task(java.util.Set value) {
		this.elenco_task = value;
	}
	
	public java.util.Set getElenco_task() {
		return elenco_task;
	}
	
	
	public ESottoprogetto(String nome, domain.entity.EManager manager) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public void modificaTask(String old, String nomeTask, String aDescrizione) {
		ETask t = null;
		Iterator<ETask> iterator = this.elenco_task.iterator();
	    while(iterator.hasNext()) {
	    	ETask ti = iterator.next();
	        if (ti.getNomeTask().equals(old))
	        	t = ti;
	    }
		t.setNomeTask(nomeTask);
		t.setDescrizione(aDescrizione);
		FTask ft = new FTask();
		ft.update(t);
	}
	
	public void eliminaTask(String nomeTask) {
		ETask t = null;
		Iterator<ETask> iterator = this.elenco_task.iterator();
	    while(iterator.hasNext()) {
	    	ETask ti = iterator.next();
	        if (ti.getNomeTask().equals(nomeTask))
	        	t = ti;
	    }
	    
	    Set<ETariffa> lista = t.geteTariffas();
		for (ETariffa l : lista){
			FTariffa ftar = new FTariffa();
			ftar.delete(l);
		}
		//t.geteTariffas().clear();
		
		this.elenco_task.remove(t);
		FTask ft = new FTask();
		ft.delete(t);
	}
	
	public void aggiungiTask(String nomeTask, String descrizione, java.util.List<String[]> idDipendente) {
		FDipendente fdip = new FDipendente();
		HashSet elencoDip = new HashSet();
		ETask task = new ETask (nomeTask, descrizione, elencoDip);
		this.elenco_task.add(task);
		FTask ftas = new FTask();
		ftas.save(task);
		for (int i = 0; i<idDipendente.size(); i++){	
			
			ETariffa tar = new ETariffa(Double.parseDouble(idDipendente.get(i)[2]), idDipendente.get(i)[1]);
			EConsulente dip = (EConsulente) (fdip.getDipendentebyID(Integer.parseInt(idDipendente.get(i)[0])));
			
			tar.seteDipendente(dip);
			tar.seteTask(task);
			task.geteTariffas().add(tar);
			FTariffa ftar = new FTariffa();
			ftar.save(tar);
		}
	}
	
	public domain.entity.ETask selezionaTask(String nomeTask) {
		Iterator<ETask> iterator = this.elenco_task.iterator();
	    while(iterator.hasNext()) {
	    	ETask t = iterator.next();
	        if (t.getNomeTask().equals(nomeTask))
	        	return t;
	    }
		return null;
	}
	
	public String toString() {
		return String.valueOf(getIdSottoprogetto());
	}
	
}
