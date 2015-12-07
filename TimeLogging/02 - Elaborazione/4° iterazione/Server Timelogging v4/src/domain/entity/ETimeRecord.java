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

public class ETimeRecord implements Serializable {
	public ETimeRecord() {
	}
	
	private int ID;
	
	private java.util.Date timeInizio;
	
	private java.util.Date timeFine;
	
	private long secondi;
	
	private String descrizione;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setTimeInizio(java.util.Date value) {
		this.timeInizio = value;
	}
	
	public java.util.Date getTimeInizio() {
		return timeInizio;
	}
	
	public void setTimeFine(java.util.Date value) {
		this.timeFine = value;
	}
	
	public java.util.Date getTimeFine() {
		return timeFine;
	}
	
	public void setDescrizione(String value) {
		this.descrizione = value;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}

	public long getSecondi() {
		return secondi;
	}

	public void setSecondi(long secondi) {
		this.secondi = secondi;
	}
	
}
