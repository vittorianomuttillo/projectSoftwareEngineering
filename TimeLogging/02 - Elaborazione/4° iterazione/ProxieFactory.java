package Handler;

import main.Client;

public class ProxieFactory {
	
	private static String host=null;
	private static String port=null;
	private static String protocol=null;
	private static DeliveryMode comunication=DeliveryMode.TWOWAY;
	enum DeliveryMode
    {
        TWOWAY,
        TWOWAY_SECURE,
        ONEWAY,
        ONEWAY_BATCH,
        ONEWAY_SECURE,
        ONEWAY_SECURE_BATCH,
        DATAGRAM,
        DATAGRAM_BATCH;

        Ice.ObjectPrx apply(Ice.ObjectPrx prx)
        {
            switch (this)
            {
            case TWOWAY:
                prx = prx.ice_twoway();
                break;
            case TWOWAY_SECURE:
                prx = prx.ice_twoway().ice_secure(true);
                break;
            case ONEWAY:
                prx = prx.ice_oneway();
                break;
            case ONEWAY_BATCH:
                prx = prx.ice_batchOneway();
                break;
            case ONEWAY_SECURE:
                prx = prx.ice_oneway().ice_secure(true);
                break;
            case ONEWAY_SECURE_BATCH:
                prx = prx.ice_batchOneway().ice_secure(true);
                break;
            case DATAGRAM:
                prx = prx.ice_datagram();
                break;
            case DATAGRAM_BATCH:
                prx = prx.ice_batchDatagram();
                break;
            }
            return prx;
        }
       

        public boolean isBatch()
        {
            return this == ONEWAY_BATCH || this == DATAGRAM_BATCH || this == ONEWAY_SECURE_BATCH;
        }
    }
	
	public ProxieFactory()
	{
		
	}
	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		ProxieFactory.host = host;
	}

	public static String getPort() {
		return port;
	}
	public static void setPort(String port) {
		ProxieFactory.port = port;
	}
	public static String getProtocol() {
		return protocol;
	}
	public static void setProtocol(String protocol) {
		ProxieFactory.protocol = protocol;
	}
	public static Ice.ObjectPrx factoryMethod(String id ,String host,String port,DeliveryMode comunication)
	{
		if(host==null)
			host=ProxieFactory.host;
		if(port==null)
			port=ProxieFactory.port;
		if(comunication==null)
			comunication=ProxieFactory.comunication;
		String proxieString=id+":"+ProxieFactory.protocol+" -h " + host + " -p "+port;
		Ice.ObjectPrx prx=null;
		System.out.println(proxieString);
		
		try
		{
			Ice.Communicator com = Client.getIc();
			prx=com.stringToProxy(proxieString);
			prx=comunication.apply(prx);
			System.out.println("subito prima del checkedcast");
			
		}
		catch(Ice.LocalException ex)
		{
			System.out.println("eccezione");
		}
		
		if(id.equals("GestisciTaskHandler"))
		{
			System.out.println("gestisci");
			try
			{
				GestisciTaskHandlerPrx cthp = GestisciTaskHandlerPrxHelper.checkedCast(prx);
				System.out.println("checkedcast");
				if(cthp == null) 
					throw new Error("Invalid proxy");
				System.out.println(cthp);
				return cthp;
			}catch(Ice.LocalException ex)
			{
				ex.printStackTrace();
			}
		} else if(id.equals("CalcolaStipendioHandler"))
		{
			System.out.println("calcola");
			try
			{
				CalcolaStipendioHandlerPrx cthp = CalcolaStipendioHandlerPrxHelper.checkedCast(prx);
				System.out.println("checkedcast");
				if(cthp == null) 
					throw new Error("Invalid proxy");
				System.out.println(cthp);
				return cthp;
			}catch(Ice.LocalException ex)
			{
				ex.printStackTrace();
			}
		}else if(id.equals("LoginHandler"))
		{
			try
			{
				LoginHandlerPrx cthp = LoginHandlerPrxHelper.checkedCast(prx);
				System.out.println("checkedcast");
				if(cthp == null) 
					throw new Error("Invalid proxy");
				System.out.println(cthp);
				return cthp;
			}catch(Ice.LocalException ex)
			{
				ex.printStackTrace();
			}
		}else if(id.equals("InserisciTimerecordHandler"))
		{
			try
			{
				InserisciTimerecordHandlerPrx cthp = InserisciTimerecordHandlerPrxHelper.checkedCast(prx);
				System.out.println("checkedcast");
				if(cthp == null) 
					throw new Error("Invalid proxy");
				System.out.println(cthp);
				return cthp;
			}catch(Ice.LocalException ex)
			{
				ex.printStackTrace();
			}
		}
		
		
		return null;
	}
}