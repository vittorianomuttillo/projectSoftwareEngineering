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
public class ETariffa implements Serializable {
	public ETariffa() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof ETariffa))
			return false;
		ETariffa etariffa = (ETariffa)aObj;
		if ((geteDipendente_CodiceFiscale() != null && !geteDipendente_CodiceFiscale().equals(etariffa.geteDipendente_CodiceFiscale())) || (geteDipendente_CodiceFiscale() == null && etariffa.geteDipendente_CodiceFiscale() != null))
			return false;
		if (geteTask_IdTask() != etariffa.geteTask_IdTask())
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (geteDipendente_CodiceFiscale() == null ? 0 : geteDipendente_CodiceFiscale().hashCode());
		hashcode = hashcode + (int) geteTask_IdTask();
		return hashcode;
	}
	
	private double quantita;
	
	private String unita;
	
	private domain.entity.EDipendente eDipendente;
	
	private String eDipendenteId;
	
	private void seteDipendenteId(String value) {
		this.eDipendenteId = value;
	}
	
	public String geteDipendenteId() {
		return eDipendenteId;
	}
	
	private domain.entity.ETask eTask;
	
	private int eTaskId;
	
	private void seteTaskId(int value) {
		this.eTaskId = value;
	}
	
	public int geteTaskId() {
		return eTaskId;
	}
	
	public void setQuantita(double value) {
		this.quantita = value;
	}
	
	public double getQuantita() {
		return quantita;
	}
	
	public void setUnita(String value) {
		this.unita = value;
	}
	
	public String getUnita() {
		return unita;
	}
	
	public void seteTask(domain.entity.ETask value) {
		this.eTask = value;
		if (value != null) {
			eTask_IdTask = value.getIdTask();
		}
		else {
			eTask_IdTask = 0;
		}
	}
	
	public domain.entity.ETask geteTask() {
		return eTask;
	}
	
	public void seteDipendente(domain.entity.EDipendente value) {
		this.eDipendente = value;
		if (value != null) {
			eDipendente_CodiceFiscale = value.getCodiceFiscale();
		}
		else {
			eDipendente_CodiceFiscale = null;
		}
	}
	
	public domain.entity.EDipendente geteDipendente() {
		return eDipendente;
	}
	
	public ETariffa(double quantita, String unita) {
		this.setQuantita(quantita);
		this.setUnita(unita);
	}
	
	public String toString() {
		return String.valueOf(geteDipendente_CodiceFiscale() + " " + geteTask_IdTask());
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
	
	
	private String eDipendente_CodiceFiscale;
	
	public void seteDipendente_CodiceFiscale(String value) {
		this.eDipendente_CodiceFiscale = value;
	}
	
	public String geteDipendente_CodiceFiscale() {
		return eDipendente_CodiceFiscale;
	}
	
	private int eTask_IdTask;
	
	public void seteTask_IdTask(int value) {
		this.eTask_IdTask = value;
	}
	
	public int geteTask_IdTask() {
		return eTask_IdTask;
	}
	
}
