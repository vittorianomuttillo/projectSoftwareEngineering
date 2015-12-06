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
public class ETask implements Serializable {
	public ETask() {
	}
	
	private int idTask;
	
	private domain.entity.EConsulente consulente;
	
	private domain.entity.ETariffa tariffa;
	
	private String descrizione;
	
	private String nomeTask;
	
	public void setDescrizione(String value) {
		this.descrizione = value;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setNomeTask(String value) {
		this.nomeTask = value;
	}
	
	public String getNomeTask() {
		return nomeTask;
	}
	
	private void setIdTask(int value) {
		this.idTask = value;
	}
	
	public int getIdTask() {
		return idTask;
	}
	
	public int getORMID() {
		return getIdTask();
	}
	
	public void setTariffa(domain.entity.ETariffa value) {
		this.tariffa = value;
	}
	
	public domain.entity.ETariffa getTariffa() {
		return tariffa;
	}
	
	public void setConsulente(domain.entity.EConsulente value) {
		this.consulente = value;
	}
	
	public domain.entity.EConsulente getConsulente() {
		return consulente;
	}
	
	private static final long serialVersionUID = 1L;
	
	public ETask(String descrizione, domain.entity.ETariffa tariffa, domain.entity.EConsulente consulente, String nome) {
		this.descrizione = descrizione;
		this.tariffa = tariffa;
		this.consulente = consulente;
		this.nomeTask = nome;
	}
	
	public String toString() {
		return String.valueOf(getIdTask());
	}

	public void setTariffa(double quantita, String unita) {
		ETariffa t = new ETariffa(quantita, unita);
		this.tariffa = t;
	}

	
}
