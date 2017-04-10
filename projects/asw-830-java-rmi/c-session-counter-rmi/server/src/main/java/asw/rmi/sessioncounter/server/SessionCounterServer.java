package asw.rmi.sessioncounter.server;

import asw.rmi.sessioncounter.service.*;
import asw.rmi.sessioncounter.impl.*;

import java.rmi.registry.*;
import java.rmi.server.*;

import java.util.logging.Logger;

/*
 * Crea e avvia la factory del session counter.
 */
public class SessionCounterServer {

	/* logger */
	private static Logger logger = Logger.getLogger("asw.impl.sessioncounter.server");

	public static void main(String[] args) {
    	/* crea il servente (la factory) */
        logger.info("SessionCounterServer: creating servant for SessionCounterFactory");
    	SessionCounterFactory sessionCounterFactory = new SessionCounterFactoryImpl();
		
        /* crea il security manager */
    	if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
		
    	/* registra il servente (la factory) */
        try {
            String sessionCounterFactoryName = "rmi:/asw/SessionCounterFactory";
            logger.info("SessionCounterServer: Binding: " + sessionCounterFactoryName);
            SessionCounterFactory stub =
                (SessionCounterFactory) UnicastRemoteObject.exportObject(sessionCounterFactory, 0);
			/* il registry deve essere in esecuzione su questo stesso nodo */ 
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(sessionCounterFactoryName, stub);
            logger.info("SessionCounterServer: " + sessionCounterFactoryName + " bound");
        } catch (Exception e) {
        	logger.info("SessionCounterServer: Exception: " + e.getMessage());
        	e.printStackTrace();
        }
    }

}
