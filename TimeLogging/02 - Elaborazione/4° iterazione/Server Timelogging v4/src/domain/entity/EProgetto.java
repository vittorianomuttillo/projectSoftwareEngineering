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
import java.util.ArrayList;
import java.util.Iterator;
public class EProgetto implements Serializable {
	public EProgetto() {
	}
	
	private int idProgetto;
	
	private String nomeProgetto;
	
	private java.util.Set<ESottoprogetto> elenco_sottoprogetti = new java.util.HashSet();
	
	private void setIdProgetto(int value) {
		this.idProgetto = value;
	}
	
	public int getIdProgetto() {
		return idProgetto;
	}
	
	public int getORMID() {
		return getIdProgetto();
	}
	
	public void setNomeProgetto(String value) {
		this.nomeProgetto = value;
	}
	
	public String getNomeProgetto() {
		return nomeProgetto;
	}
	
	public void setElenco_sottoprogetti(java.util.Set value) {
		this.elenco_sottoprogetti = value;
	}
	
	public java.util.Set getElenco_sottoprogetti() {
		return elenco_sottoprogetti;
	}
	
	
	private static final long serialVersionUID = 1L;
	
	public domain.entity.ESottoprogetto selezionaSottoprogetto(String nomeSottoprogetto) {
		Iterator<ESottoprogetto> iterator = this.elenco_sottoprogetti.iterator();
	    while(iterator.hasNext()) {
	    	ESottoprogetto sp = iterator.next();
	        if (sp.getNomeSottoprogetto().equals(nomeSottoprogetto))
	        	return sp;
	    }
		return null;
	}
	
	public java.util.ArrayList<String> getSottoprogettiByManager(int idManager) {
		ArrayList<String> s = new ArrayList<String>();
		Iterator<ESottoprogetto> iterator = this.elenco_sottoprogetti.iterator();
	    while(iterator.hasNext()) {
	    	ESottoprogetto sp = iterator.next();
	        if (sp.getIdSottoprogetto() == idManager)
	        	s.add(this.nomeProgetto+"-"+sp.getNomeSottoprogetto());
	    }
		return s;
	}
	
	public String toString() {
		return String.valueOf(getIdProgetto());
	}
	
}
