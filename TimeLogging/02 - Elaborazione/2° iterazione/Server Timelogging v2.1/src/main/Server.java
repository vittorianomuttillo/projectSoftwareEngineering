package main;

import controller.handler.GestisciTaskHandler;
import persistence.foundation.Util;

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
            Util.setDocument(System.getProperty("user.home")+"\\Config.xml");
            
            String iceProtocol = Util.parseXml("iceProtocol");
            String icePort = Util.parseXml("icePort");
            String iceHost = Util.parseXml("iceHost");

            /* creazione dell'adapter 
             * Nome: HandlerAdapter
             * Protocollo: default (TCP)
             * IP: non specificato (localhost)
             * Porta: 10012
             */
            Ice.ObjectAdapter adapter =
                ic.createObjectAdapterWithEndpoints("HandlerAdapter", iceProtocol+" -h "+iceHost+" -p "+icePort);
            /*creazione oggetto da condividere e inserimento nell'adapter
             * sarà reperibile lato client tramite lo pseudonimo creaTaskHandler
             */
            Ice.Object object1 = new GestisciTaskHandler();
            adapter.add(object1, ic.stringToIdentity("GestisciTaskHandler"));
            // attivazione adapter
            adapter.activate();
            // specifichiamo che il server non verrà spento finchè non si interverrà direttamente per farlo
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
