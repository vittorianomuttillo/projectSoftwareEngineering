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
public class EManager implements Serializable {
	public EManager() {
	}
	
	private int idManager;
	
	private String codiceFiscale;
	
	private String nomeManager;
	
	private String cognomeManager;
	
	private boolean _saved = false;
	
	public void setCodiceFiscale(String value) {
		this.codiceFiscale = value;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	private void setIdManager(int value) {
		this.idManager = value;
	}
	
	public int getIdManager() {
		return idManager;
	}
	
	public int getORMID() {
		return getIdManager();
	}
	
	public void setNomeManager(String value) {
		this.nomeManager = value;
	}
	
	public String getNomeManager() {
		return nomeManager;
	}
	
	public void setCognomeManager(String value) {
		this.cognomeManager = value;
	}
	
	public String getCognomeManager() {
		return cognomeManager;
	}
	
	public void set_saved(boolean value) {
		this._saved = value;
	}
	
	public boolean get_saved() {
		return _saved;
	}
	
	private static final long serialVersionUID = 1L;
	
	public EManager(String cf, String nome, String cognome) {
		this.codiceFiscale = cf;
		this.nomeManager = nome;
		this.cognomeManager = cognome;
	}
	
	public String toString() {
		return String.valueOf(getIdManager());
	}
	
}
