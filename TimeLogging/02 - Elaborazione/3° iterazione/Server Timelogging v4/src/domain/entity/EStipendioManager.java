package domain.entity;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import persistence.foundation.XMLParser;

public class EStipendioManager extends EStipendioComposite {
	
	public EStipendioManager(){
		super("manager");
//		ArrayList<String> tipi = Util.parseStip("manager");
//		if (tipi.contains("Fisso")){
//			EStipendioFisso calcoloFisso = new EStipendioFisso();
//			this.add(calcoloFisso);
//		}
//		if (tipi.contains("Variabile")){
//			EStipendioVariabile calcoloVariabile = new EStipendioVariabile();
//			this.add(calcoloVariabile);
//		}
	}

	public EStipendio calcolaStipendio(EDipendente dipendente, long dataInizio, long dataFine) {
		EStipendio stipendio = new EStipendio("euro");
		for (ECalcoloStipendio regola: this.RegoleCalcoloStipendio){
			stipendio.add(regola.calcolaStipendio(dipendente,dataInizio, dataFine));
		}
		
		return stipendio;
		
	}
}