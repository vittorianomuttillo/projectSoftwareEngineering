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
	public EConsulente() {
	}
	
	private java.util.Set timeRecords = new java.util.HashSet();
	
	public void setTimeRecords(java.util.Set value) {
		this.timeRecords = value;
	}
	
	public java.util.Set getTimeRecords() {
		return timeRecords;
	}
	
	
	public EConsulente(String cf, String nome, String cognome) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public java.util.Set getTimeRecordsInTime(long inizio, long fine) {
		Set<ETimeRecord> records = this.timeRecords;
	    for(ETimeRecord t : records) {
			if (t.getTimeInizio().getTime() < inizio || t.getTimeFine().getTime() > fine){
				records.remove(t);
			}
		}
		return records;
	}
	
	public String toString() {
		return super.toString();
	}
	
}
