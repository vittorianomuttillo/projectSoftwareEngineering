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

	private static final long serialVersionUID = 1L;

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
	
	private domain.entity.EStipendio stipendio;
	
	private int idDipendente;
	
	private String nomeDipendente;
	
	private String cognomeDipendente;
	
	private String livello;
	
	@SuppressWarnings("rawtypes")
	private java.util.Set eTariffas = new java.util.HashSet();
	
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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
	
	public void setLivello(String value) {
		this.livello = value;
	}
	
	public String getLivello() {
		return livello;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public domain.entity.ETask[] geteTasks() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = eTariffas.iterator();lIter.hasNext();) {
			lValues.add(((domain.entity.ETariffa)lIter.next()).geteTask());
		}
		return (domain.entity.ETask[])lValues.toArray(new domain.entity.ETask[lValues.size()]);
	}
	
	@SuppressWarnings("unchecked")
	public void removeeTask(domain.entity.ETask aeTask) {
		domain.entity.ETariffa[] leTariffas = (domain.entity.ETariffa[])eTariffas.toArray(new domain.entity.ETariffa[eTariffas.size()]);
		for(int i = 0; i < leTariffas.length; i++) {
			if(leTariffas[i].geteTask().equals(aeTask)) {
				eTariffas.remove(leTariffas[i]);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void addeTask(domain.entity.ETariffa aETariffa, domain.entity.ETask aeTask) {
		aETariffa.seteTask(aeTask);
		eTariffas.add(aETariffa);
	}
	
	@SuppressWarnings("unchecked")
	public domain.entity.ETariffa getETariffaByeTask(domain.entity.ETask aeTask) {
		domain.entity.ETariffa[] leTariffas = (domain.entity.ETariffa[])eTariffas.toArray(new domain.entity.ETariffa[eTariffas.size()]);
		for(int i = 0; i < leTariffas.length; i++) {
			if(leTariffas[i].geteTask().equals(aeTask)) {
				return leTariffas[i];
			}
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public void seteTariffas(java.util.Set value) {
		this.eTariffas = value;
	}
	
	@SuppressWarnings("rawtypes")
	public java.util.Set geteTariffas() {
		return eTariffas;
	}
	
	
	public void setStipendio(domain.entity.EStipendio value) {
		this.stipendio = value;
	}
	
	public domain.entity.EStipendio getStipendio() {
		return stipendio;
	}
	
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String aTipo) {
		tipo = aTipo;
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
