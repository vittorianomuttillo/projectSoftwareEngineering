module Handler {

interface InserisciTimerecordHandler {			
	
		string getElencoTask(int id);
		
		bool inserisciTimerecord(string descrizione, long datai, long dataf, long secondi, string nomeTask, string sottoprogetto, string progetto, int idDip);
		
	};
};