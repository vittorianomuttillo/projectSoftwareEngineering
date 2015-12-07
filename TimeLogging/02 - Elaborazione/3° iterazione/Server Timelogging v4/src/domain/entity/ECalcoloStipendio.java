package domain.entity;

import java.util.GregorianCalendar;

public interface ECalcoloStipendio {

	public EStipendio calcolaStipendio(domain.entity.EDipendente dipendente, long dataInizio, long dataFine);
}