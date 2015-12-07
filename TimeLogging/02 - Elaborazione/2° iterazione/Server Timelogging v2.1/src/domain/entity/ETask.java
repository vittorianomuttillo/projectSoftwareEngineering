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

import persistence.foundation.FDipendente;
import persistence.foundation.FTask;
public class ETask implements Serializable {
	public ETask() {
	}
	
	private int idTask;
	
	private String descrizione;
	
	private String nomeTask;
	
	private java.util.Set<EDipendente> consulente = new java.util.HashSet<EDipendente>();
	
	private void setIdTask(int value) {
		this.idTask = value;
	}
	
	public int getIdTask() {
		return idTask;
	}
	
	public int getORMID() {
		return getIdTask();
	}
	
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
	
	public void setConsulente(java.util.Set value) {
		this.consulente = value;
	}
	
	public java.util.Set getConsulente() {
		return consulente;
	}
	
	
	private static final long serialVersionUID = 1L;
	
	public ETask(String descrizione, String nome, java.util.HashSet dip) {
		this.setDescrizione(descrizione);
		this.setNomeTask(nome);
		this.setConsulente(dip);
	}
	
	public void aggiungiDip(int idDipendente) {
		FDipendente fdip = new FDipendente();
		EDipendente dip = fdip.getDipendentebyID(idDipendente);
		this.getConsulente().add(dip);
		FTask ftask = new FTask();
		ftask.update(this);
	}
	
	public void eliminaDip(int idDipendente) {
		FDipendente fdip = new FDipendente();
		EDipendente dip = fdip.getDipendentebyID(idDipendente);
		this.getConsulente().remove(dip);
		FTask ftask = new FTask();
		ftask.update(this);
	}
	
	public void sostituisciDip(int idDipendente, int idDipendenteOld) {
		FDipendente fdip = new FDipendente();
		EDipendente dip = fdip.getDipendentebyID(idDipendente);
		EDipendente oldDip = fdip.getDipendentebyID(idDipendenteOld);
		this.getConsulente().remove(oldDip);
		this.getConsulente().add(dip);		
		FTask ftask = new FTask();
		ftask.update(this);
	}
	
	public String toString() {
		return String.valueOf(getIdTask());
	}
	
}
