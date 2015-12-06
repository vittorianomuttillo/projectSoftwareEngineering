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
	
	private int ID;
	
	private double quantita;
	
	private String unita;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
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
	
	private static final long serialVersionUID = 1L;
	
	public ETariffa(double quantita, String unita) {
		this.quantita = quantita;
		this.unita = unita;
	}
	
	public void steTariffa(){
		
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
