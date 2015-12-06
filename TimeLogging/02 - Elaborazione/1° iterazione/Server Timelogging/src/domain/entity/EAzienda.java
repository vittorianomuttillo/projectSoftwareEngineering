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

import persistence.foundation.FAzienda;

public class EAzienda implements Serializable {
	private EAzienda() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof EAzienda))
			return false;
		EAzienda eazienda = (EAzienda)aObj;
		if ((getNomeAzienda() != null && !getNomeAzienda().equals(eazienda.getNomeAzienda())) || (getNomeAzienda() == null && eazienda.getNomeAzienda() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getNomeAzienda() == null ? 0 : getNomeAzienda().hashCode());
		return hashcode;
	}
	
	private String nomeAzienda;
	
	private String indirizzo;
	
	private boolean _saved = false;
	
	private java.util.Set elenco_progetti = new java.util.HashSet();
	
	private java.util.Set elenco_consulenti = new java.util.HashSet();
	
	public void setNomeAzienda(String value) {
		this.nomeAzienda = value;
	}
	
	public String getNomeAzienda() {
		return nomeAzienda;
	}
	
	public String getORMID() {
		return getNomeAzienda();
	}
	
	public void setIndirizzo(String value) {
		this.indirizzo = value;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void set_saved(boolean value) {
		this._saved = value;
	}
	
	public boolean get_saved() {
		return _saved;
	}
	
	public void setElenco_progetti(java.util.Set value) {
		this.elenco_progetti = value;
	}
	
	public java.util.Set getElenco_progetti() {
		return elenco_progetti;
	}
	
	
	public void setElenco_consulenti(java.util.Set value) {
		this.elenco_consulenti = value;
	}
	
	public java.util.Set getElenco_consulenti() {
		return elenco_consulenti;
	}
	
	
	private static final long serialVersionUID = 1L;
	
	private static domain.entity.EAzienda instance;
	
	public static EAzienda getInstance(){
		if (EAzienda.instance == null){
			FAzienda fazienda = new FAzienda();
			EAzienda.instance = fazienda.getAzienda();
		}
		return EAzienda.instance;
	}
	
	public domain.entity.EProgetto selezionaProgetto(String nomeProgetto) {
		Iterator<EProgetto> iterator = this.elenco_progetti.iterator();
	    while(iterator.hasNext()) {
	    	EProgetto p = iterator.next();
	        if (p.getNomeProgetto().equals(nomeProgetto))
	        	return p;
	    }
		return null;
	}
	
	public domain.entity.EConsulente selezionaConsulente(int idConsulente) {
		Iterator<EConsulente> iterator = this.elenco_consulenti.iterator();
	    while(iterator.hasNext()) {
	    	EConsulente c = iterator.next();
	        if (c.getIdConsulente() == idConsulente)
	        	return c;
	    }
		return null;
	}
	
	public String toString() {
		return String.valueOf(getNomeAzienda());
	}
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}
	
	
}
