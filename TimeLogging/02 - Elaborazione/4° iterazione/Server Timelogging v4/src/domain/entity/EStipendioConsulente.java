package domain.entity;

import java.util.ArrayList;

import persistence.foundation.XMLParser;

public class EStipendioConsulente extends EStipendioComposite {

	public EStipendioConsulente(){
		super("consulente");
		
//		if (tipi.contains("Fisso")){
//			EStipendioFisso calcoloFisso = new EStipendioFisso();
//			this.add(calcoloFisso);
//		}
//		if (tipi.contains("Variabile")){
//			EStipendioVariabile calcoloVariabile = new EStipendioVariabile();
//			this.add(calcoloVariabile);
//		}
		
	}
	
	@Override
	public EStipendio calcolaStipendio(EDipendente dipendente, long dataInizio,
			long dataFine) {
		EStipendio stipendio = new EStipendio("euro");
		for (ECalcoloStipendio regola: this.RegoleCalcoloStipendio){
			stipendio.add(regola.calcolaStipendio(dipendente, dataInizio, dataFine));
		}		
		return stipendio;
	}
		
}