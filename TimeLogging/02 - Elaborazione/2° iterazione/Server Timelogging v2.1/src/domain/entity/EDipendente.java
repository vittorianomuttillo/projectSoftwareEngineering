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
public abstract class EDipendente implements Serializable {
	public EDipendente() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof EDipendente))
			return false;
		EDipendente edipendente = (EDipendente)aObj;
		if ((getCodiceFiscale() != null && !getCodiceFiscale().equals(edipendente.getCodiceFiscale())) || (getCodiceFiscale() == null && edipendente.getCodiceFiscale() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getCodiceFiscale() == null ? 0 : getCodiceFiscale().hashCode());
		return hashcode;
	}
	
	private String codiceFiscale;
	
	private domain.entity.ETariffa tariffa;
	
	private int idDipendente;
	
	private String nomeDipendente;
	
	private String cognomeDipendente;
	
	private String tipo;
	
	public void setCodiceFiscale(String value) {
		this.codiceFiscale = value;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	
	public String getORMID() {
		return getCodiceFiscale();
	}
	
	public void setIdDipendente(int value) {
		this.idDipendente = value;
	}
	
	public int getIdDipendente() {
		return idDipendente;
	}
	
	public void setNomeDipendente(String value) {
		this.nomeDipendente = value;
	}
	
	public String getNomeDipendente() {
		return nomeDipendente;
	}
	
	public void setCognomeDipendente(String value) {
		this.cognomeDipendente = value;
	}
	
	public String getCognomeDipendente() {
		return cognomeDipendente;
	}
	
	public void setTipo(String value) {
		this.tipo = value;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTariffa(domain.entity.ETariffa value) {
		this.tariffa = value;
	}
	
	public domain.entity.ETariffa getTariffa() {
		return tariffa;
	}
	
	public String toString() {
		return String.valueOf(getCodiceFiscale());
	}
	
	private boolean _saved = false;
	
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
