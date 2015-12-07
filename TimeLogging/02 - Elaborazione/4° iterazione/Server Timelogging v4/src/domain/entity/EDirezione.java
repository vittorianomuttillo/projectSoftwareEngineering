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
public class EDirezione implements Serializable {
	public EDirezione() {
	}
	
	private int ID;
	
	private java.util.Set<EDipendente> elenco_dipendenti = new java.util.HashSet();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setElenco_dipendenti(java.util.Set value) {
		this.elenco_dipendenti = value;
	}
	
	public java.util.Set getElenco_dipendenti() {
		return elenco_dipendenti;
	}
	
	
	public domain.entity.EConsulente selezionaConsulente(int aIdConsulente) {
		//TODO: Implement Method
		throw new UnsupportedOperationException();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
