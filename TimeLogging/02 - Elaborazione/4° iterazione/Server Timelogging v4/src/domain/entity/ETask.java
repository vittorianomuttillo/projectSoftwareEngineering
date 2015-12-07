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
import java.util.GregorianCalendar;

import persistence.foundation.FDipendente;
import persistence.foundation.FTariffa;
import persistence.foundation.FTimerecord;

public class ETask implements Serializable {
	
	public ETask() {
	}
	
	private int idTask;
	
	private String descrizione;
	
	private String nomeTask;
	
	private java.util.Set<ETimeRecord> timeRecords = new java.util.HashSet();
	
	private java.util.Set<ETariffa> eTariffas = new java.util.HashSet();
	
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
	
	public void setTimeRecords(java.util.Set value) {
		this.timeRecords = value;
	}
	
	public java.util.Set getTimeRecords() {
		return timeRecords;
	}
	
	
	public domain.entity.EDipendente[] geteDipendentes() {
		java.util.ArrayList lValues = new java.util.ArrayList(5);
		for(java.util.Iterator lIter = eTariffas.iterator();lIter.hasNext();) {
			lValues.add(((domain.entity.ETariffa)lIter.next()).geteDipendente());
		}
		return (domain.entity.EDipendente[])lValues.toArray(new domain.entity.EDipendente[lValues.size()]);
	}
	
	public void removeeDipendente(domain.entity.EDipendente aeDipendente) {
		domain.entity.ETariffa[] leTariffas = (domain.entity.ETariffa[])eTariffas.toArray(new domain.entity.ETariffa[eTariffas.size()]);
		for(int i = 0; i < leTariffas.length; i++) {
			if(leTariffas[i].geteDipendente().equals(aeDipendente)) {
				eTariffas.remove(leTariffas[i]);
			}
		}
	}
	
	public void addeDipendente(domain.entity.ETariffa aETariffa, domain.entity.EDipendente aeDipendente) {
		aETariffa.seteDipendente(aeDipendente);
		eTariffas.add(aETariffa);
	}
	
	public domain.entity.ETariffa getETariffaByeDipendente(domain.entity.EDipendente aeDipendente) {
		domain.entity.ETariffa[] leTariffas = (domain.entity.ETariffa[])eTariffas.toArray(new domain.entity.ETariffa[eTariffas.size()]);
		for(int i = 0; i < leTariffas.length; i++) {
			if(leTariffas[i].geteDipendente().equals(aeDipendente)) {
				return leTariffas[i];
			}
		}
		return null;
	}
	
	public void seteTariffas(java.util.Set value) {
		this.eTariffas = value;
	}
	
	public java.util.Set geteTariffas() {
		return eTariffas;
	}
	
	
	public ETask(String descrizione, String nome, java.util.HashSet dip) {
		this.setDescrizione(descrizione);
		this.setNomeTask(nome);
	}
	
	public void aggiungiDip(int idDipendente, ETariffa tariffa) {
		FDipendente fdip = new FDipendente();
		EDipendente dip = fdip.getDipendentebyID(idDipendente);
		
		tariffa.seteDipendente(dip);
		tariffa.seteTask(this);
		this.geteTariffas().add(tariffa);
		FTariffa ftar = new FTariffa();
		ftar.save(tariffa);
	}
	
	public void eliminaDip(int idDipendente) {
		FDipendente fdip = new FDipendente();
		EDipendente dip = fdip.getDipendentebyID(idDipendente);		
		ETariffa tariffa = dip.getETariffaByeTask(this);
		dip.geteTariffas().remove(tariffa);
		this.geteTariffas().remove(tariffa);
		FTariffa ftar = new FTariffa();
		ftar.delete(tariffa);
	}
	
	public void sostituisciDip(int idDipendente, ETariffa tariffa, int idDipendenteOld) {		
		this.eliminaDip(idDipendenteOld);
		this.aggiungiDip(idDipendente, tariffa);	
	}
	
	public String toString() {
		return String.valueOf(getIdTask());
	}

	public void aggiungiTimerecord(String descrizione,
			long datai, long dataf, long secondi, int idDip) {
		GregorianCalendar inizio = new GregorianCalendar();
		GregorianCalendar fine = new GregorianCalendar();
		
		ETimeRecord tr = new ETimeRecord();
		tr.setDescrizione(descrizione);
		inizio.setTimeInMillis(datai);
		tr.setTimeInizio(inizio.getTime());
		fine.setTimeInMillis(dataf);
		tr.setTimeFine(fine.getTime());
		tr.setSecondi(secondi);
		
		this.timeRecords.add(tr);
		EDipendente[] dips = this.geteDipendentes();
		for (EDipendente d : dips){
			if (d.getIdDipendente() == idDip){
				((EConsulente)d).getTimeRecords().add(tr);
			}
				
		}
		
		FTimerecord ftr = new FTimerecord();
		ftr.save(tr);
	}
	
}
