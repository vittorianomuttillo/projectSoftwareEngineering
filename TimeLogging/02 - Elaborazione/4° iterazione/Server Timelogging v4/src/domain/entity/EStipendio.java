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
public class EStipendio implements Serializable {
	public EStipendio() {
	}
	
	private int ID;
	
	private double ammontare;
	
	private String unita;
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public EStipendio(String unita){
		this.unita =unita;		
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setAmmontare(double value) {
		this.ammontare = value;
	}
	
	public double getAmmontare() {
		return ammontare;
	}
	
	public void setUnita(String value) {
		this.unita = value;
	}
	
	public String getUnita() {
		return unita;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
	public void add(EStipendio stipendio){
		if (stipendio.unita.equals(this.unita)){
			this.ammontare += stipendio.ammontare;
		}
	}
	
}
