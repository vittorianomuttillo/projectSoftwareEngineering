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
public class EConsulente implements Serializable {
	public EConsulente() {
	}
	
	private int idConsulente;
	
	private String codiceFiscale;
	
	private String nomeConsulente;
	
	private String cognomeConsulente;
	
	private boolean _saved = false;
	
	public void setCodiceFiscale(String value) {
		this.codiceFiscale = value;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	private void setIdConsulente(int value) {
		this.idConsulente = value;
	}
	
	public int getIdConsulente() {
		return idConsulente;
	}
	
	public int getORMID() {
		return getIdConsulente();
	}
	
	public void setNomeConsulente(String value) {
		this.nomeConsulente = value;
	}
	
	public String getNomeConsulente() {
		return nomeConsulente;
	}
	
	public void setCognomeConsulente(String value) {
		this.cognomeConsulente = value;
	}
	
	public String getCognomeConsulente() {
		return cognomeConsulente;
	}
	
	public void set_saved(boolean value) {
		this._saved = value;
	}
	
	public boolean get_saved() {
		return _saved;
	}
	
	private static final long serialVersionUID = 1L;
	
	public EConsulente(String cf, String nome, String cognome) {
		this.codiceFiscale = cf;
		this.nomeConsulente = nome;
		this.cognomeConsulente = cognome;
	}
	
	public String toString() {
		return String.valueOf(getIdConsulente());
	}
	
}
