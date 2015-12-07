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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class EMarketing implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public EMarketing() {
	}
	
	private int ID;
	
	private int giornoPaga;
	
	private ECalcolaStipendioFactory calcoloStipendio = new ECalcolaStipendioFactory();
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getID() {
		return ID;
	}
	
	public int getORMID() {
		return getID();
	}
	
	public void setGiornoPaga(int value) {
		this.giornoPaga = value;
	}
	
	public int getGiornoPaga() {
		return giornoPaga;
	}
	
	public void calcolaStipendio(java.util.Set elenco_dipendenti) {
		
		EStipendio stipendio = new EStipendio();
		
		GregorianCalendar dataInizio = new GregorianCalendar();
		GregorianCalendar dataFine = new GregorianCalendar();
		if (this.giornoPaga>dataInizio.get(Calendar.DAY_OF_MONTH)){
			dataFine.set(5, this.giornoPaga);
		}
		else {
			dataFine.add(2, -1);
			dataFine.set(5, this.giornoPaga);
		}
		
		long timeInizio = dataInizio.getTimeInMillis();
		long timeFine = dataFine.getTimeInMillis();
		
		Iterator<EDipendente> iterator = elenco_dipendenti.iterator();
		
	    while(iterator.hasNext()) {
	    	EDipendente d = iterator.next();	        
	    	
	    	stipendio = this.calcoloStipendio.factoryMethod(d.getTipo()).calcolaStipendio(d, timeInizio, timeFine);

	    	d.setStipendio(stipendio);
	    }
	}
	
	public double calcolaStipendio(domain.entity.EDipendente dipendente) {
		
		EStipendio stipendio = new EStipendio();
		
		GregorianCalendar dataInizio = new GregorianCalendar();
		GregorianCalendar dataFine = new GregorianCalendar();
		if (this.giornoPaga<dataInizio.get(Calendar.DAY_OF_MONTH)){
			dataInizio.set(Calendar.DAY_OF_MONTH, this.giornoPaga);
		}
		else {
			dataInizio.add(Calendar.MONTH, -1);
			dataInizio.set(Calendar.DAY_OF_MONTH, this.giornoPaga);
		}
		
		long timeInizio = dataInizio.getTimeInMillis();
		long timeFine = dataFine.getTimeInMillis();
		
		
    	stipendio = this.calcoloStipendio.factoryMethod(dipendente.getTipo()).calcolaStipendio(dipendente, timeInizio, timeFine);

		return stipendio.getAmmontare();
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
