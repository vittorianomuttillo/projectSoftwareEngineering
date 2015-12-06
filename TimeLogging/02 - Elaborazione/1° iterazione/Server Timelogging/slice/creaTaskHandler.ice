module Handler {

	interface GestisciTaskHandler {
	
	    void creaTask(string aNomeProgetto, string aNomeSottoprogetto, string aDescrizione, 
	    	int aIdConsulente, double quantita, string unita, string nomeTask);
	    
	    string getSottoprogetti(int idManager);
		
		string getConsulenti();
		
		string getInfoSottoprogetto(string nomeProgetto, string nomeSottoprogetto);
	    
	    string getInfoTask(string nomeProgetto, string nomeSottoprogetto, string nomeTask);
	    
	    void cancellaTask(string aNomeProgetto, string aNomeSottoprogetto, string nomeTask);
	    
	    void modificaTask(string aNomeProgetto, string aNomeSottoprogetto,
			string aDescrizione, string nomeTask, string oldNomeTask);
	    
	};
};