package domain.entity;

import java.util.Set;

public class EStipendioVariabile implements ECalcoloStipendio {

	@Override
	public EStipendio calcolaStipendio(EDipendente dipendente, long dataInizio, long dataFine) {
		
		EStipendio stipendio = new EStipendio("euro");
		double ammontare = 0;
		ETask[] tasks = dipendente.geteTasks();
		EConsulente dip = (EConsulente) dipendente;
		Set<ETimeRecord> timeRecords = dip.getTimeRecordsInTime(dataInizio, dataFine);
		for (ETask t : tasks){
			Set<ETimeRecord> giovanni = t.getTimeRecords();
			for (ETimeRecord time : giovanni){
				for(ETimeRecord timeRecord : timeRecords) {
					if (timeRecord.getID() == time.getID()){
						ETariffa tariffa = dipendente.getETariffaByeTask(t);
						double ore = (timeRecord.getSecondi() / 3600000);
						ammontare += ore*tariffa.getQuantita();
					}					
				}			
			}
		}		
		stipendio.setAmmontare(ammontare);
		return stipendio;
		
	}
	
}