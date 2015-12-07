package domain.entity;

public interface ECalcoloStipendio {

	public EStipendio calcolaStipendio(domain.entity.EDipendente dipendente, long dataInizio, long dataFine);
}