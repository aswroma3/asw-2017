package asw.rmi.counter.server;

import asw.rmi.counter.service.Counter;
import asw.rmi.counter.impl.CounterImpl;

import java.util.logging.Logger;

import java.rmi.server.*;
import java.rmi.registry.*;

public class CounterServer {

	/* logger */
	private static Logger logger = Logger.getLogger("asw.rmi.counter.server");

	public static void main(String[] args) {
    	/* crea il servente */
        logger.info("CounterServer: creating servant for Counter");
    	Counter counterService = new CounterImpl();
		
        /* crea il security manager */
    	if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
    	
		/* registra il servente */
    	try {
            String counterServiceName = "rmi:/asw/Counter";
            logger.info("CounterServer: Binding: " + counterServiceName);
            Counter counterStub =
                (Counter) UnicastRemoteObject.exportObject(counterService, 0);
			/* il registry deve essere in esecuzione su questo stesso nodo */ 
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(counterServiceName, counterStub);
            logger.info("CounterServer: " + counterServiceName + " bound");
        } catch (Exception e) {
        	logger.info("CounterServer: Exception: " + e.getMessage());
        	e.printStackTrace();
        }
    }

}
