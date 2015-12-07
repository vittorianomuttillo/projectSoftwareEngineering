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
import java.util.Set;

public class EConsulente extends domain.entity.EDipendente implements Serializable {

	private static final long serialVersionUID = 1L;

	public EConsulente() {
	}
	
	@SuppressWarnings("rawtypes")
	private java.util.Set<ETimeRecord> timeRecords = new java.util.HashSet();
	
	@SuppressWarnings("rawtypes")
	public void setTimeRecords(java.util.Set value) {
		this.timeRecords = value;
	}
	
	@SuppressWarnings("rawtypes")
	public java.util.Set getTimeRecords() {
		return timeRecords;
	}
	
	
	public EConsulente(String cf, String nome, String cognome) {
		throw new UnsupportedOperationException();
	}
	
	@SuppressWarnings( { "unchecked", "rawtypes" } )
	public java.util.Set getTimeRecordsInTime(long inizio, long fine) {
		Set<ETimeRecord> records = this.timeRecords;
		 Iterator<ETimeRecord> it = records.iterator();
		 while (it.hasNext())
		 {
			 ETimeRecord t = it.next();
			 if (t.getTimeInizio().getTime() < inizio || t.getTimeFine().getTime() > fine){
				 it.remove();
			 }
		 }
		return records;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
