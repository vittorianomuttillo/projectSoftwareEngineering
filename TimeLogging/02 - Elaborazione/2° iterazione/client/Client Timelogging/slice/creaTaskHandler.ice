module Handler {

		sequence<string> StringList;
	
	["java:type:java.util.ArrayList<String[]>"] sequence<StringList> IntArrayList;

	interface GestisciTaskHandler {
	
	    void creaTask(string NomeProgetto, string NomeSottoprogetto,
			string Descrizione, IntArrayList IdDipendente,
			string nomeTask);
	    
	    string getSottoprogetti(int idManager);
		
		string getDipendenti();
		
		IntArrayList aggiornaElencoDipendenti (IntArrayList elencoDip, int idDipendente, string unita, double quantita);
		
		string getInfoSottoprogetto(string nomeProgetto, string nomeSottoprogetto);
	    
	    string getInfoTask(string nomeProgetto, string nomeSottoprogetto, string nomeTask);
	    
	    void cancellaTask(string aNomeProgetto, string aNomeSottoprogetto, string nomeTask);
	    
	    void modificaTask(string aNomeProgetto, string aNomeSottoprogetto, string aDescrizione, string nomeTask, string oldNomeTask);
			
		void aggiungiDipendente (string aNomeProgetto, string aNomeSottoprogetto, string nomeTask, int IdDipendente);
		
		void eliminaDipendente (string aNomeProgetto, string aNomeSottoprogetto, string nomeTask, int IdDipendente);
		
		void sostituisciDipendente (string aNomeProgetto, string aNomeSottoprogetto, string nomeTask, int IdDipendente, int IdDipendenteOld);
	    
	};
};