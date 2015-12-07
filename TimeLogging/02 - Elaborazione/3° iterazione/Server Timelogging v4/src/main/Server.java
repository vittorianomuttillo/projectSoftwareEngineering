package main;

import controller.handler.CalcolaStipendioHandler;
import controller.handler.GestisciTaskHandler;
import domain.entity.EAzienda;
import domain.entity.EConsulente;
import domain.entity.ESottoprogetto;
import domain.entity.ETariffa;
import domain.entity.ETask;
import persistence.DAO.ESottoprogettoDAO;
import persistence.DAO.ETariffaDAO;
import persistence.DAO.ETaskDAO;
import persistence.foundation.FDipendente;
import persistence.foundation.XMLParser;

public class Server {
	
	public static void main(String[] args)
    {	
		// codice relativo all'implementazione della parte server di ICE
        int status = 0;
        Ice.Communicator ic = null;
        try {
        	// inizializzazione ice comunicator
            ic = Ice.Util.initialize(args);
            //System.out.println(System.getProperty("user.home"));
            XMLParser.setDocument(System.getProperty("user.home")+"/ConfigServer.xml");
            
            String iceProtocol = XMLParser.parseXml("iceProtocol");
            String icePort = XMLParser.parseXml("icePort");
            String iceHost = XMLParser.parseXml("iceHost");
            System.out.println(XMLParser.parseStip("consulente"));
            
            /* creazione dell'adapter 
             * Nome: HandlerAdapter
             * Protocollo: default (TCP)
             * IP: non specificato (localhost)
             * Porta: 10012
             */
            Ice.ObjectAdapter adapter =
                ic.createObjectAdapterWithEndpoints("HandlerAdapter", iceProtocol+" -h "+iceHost+" -p "+icePort);
            /*creazione oggetto da condividere e inserimento nell'adapter
             * sar� reperibile lato client tramite lo pseudonimo creaTaskHandler
             */
            Ice.Object object1 = new GestisciTaskHandler();
            adapter.add(object1, ic.stringToIdentity("GestisciTaskHandler"));
            Ice.Object object2 = new CalcolaStipendioHandler();
            adapter.add(object2, ic.stringToIdentity("CalcolaStipendioHandler"));
            // attivazione adapter
            adapter.activate();
            // specifichiamo che il server non verr� spento finch� non si interverr� direttamente per farlo
            ic.waitForShutdown();
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        }
        if (ic != null) {
            try {
                ic.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
        }
        System.exit(status);
    }

}
