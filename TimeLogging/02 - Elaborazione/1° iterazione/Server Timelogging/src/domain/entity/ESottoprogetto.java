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
import java.util.Iterator;

import persistence.foundation.FTask;
public class ESottoprogetto implements Serializable {
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
	
	
	private static final long serialVersionUID = 1L;
	
	public ESottoprogetto(String nome, domain.entity.EManager manager) {
		this.nomeSottoprogetto = nome;
		this.manager = manager;
	}
	
	public void aggiungiTask(String nomeTask, String aDescrizione, domain.entity.EConsulente consulente, double quantita, String unita) {
		ETask task = new ETask();
		task.setConsulente(consulente);
		task.setDescrizione(aDescrizione);
		task.setNomeTask(nomeTask);
		task.setTariffa(quantita, unita);
		
		this.getElenco_task().add(task);
		
		FTask ft = new FTask();
		ft.save(task);
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
		
		this.elenco_task.remove(t);
		FTask ft = new FTask();
		ft.delete(t);
	}
	
	public String toString() {
		return String.valueOf(getIdSottoprogetto());
	}
	
}
