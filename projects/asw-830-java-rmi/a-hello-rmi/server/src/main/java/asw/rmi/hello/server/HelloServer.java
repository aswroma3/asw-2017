package asw.rmi.hello.server;

import asw.rmi.hello.service.Hello;
import asw.rmi.hello.service.impl.HelloServant;

import java.rmi.server.*;
import java.rmi.registry.*;

import java.util.logging.Logger;

/**
 * Server per il servizio Hello.
 * Crea un servant e lo registra sul registry RMI.
 */
public class HelloServer {

	/* logger */
	private static Logger logger = Logger.getLogger("asw.rmi.hello.server");

	public static void main(String[] args) {
    	/* crea il servente */
        logger.info("Server: creating servant for Hello");
    	Hello hello = new HelloServant();

    	/* crea il security manager */
    	if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

    	/* esporta il servente come oggetto RMI, e lo registra sul registry */
        try {
        	/* esporta il servente come oggetto RMI */
        	/* nota: usando UnicastRemoteObject.exportObject(hello) non funziona */
            Hello helloStub =
                    (Hello) UnicastRemoteObject.exportObject(hello, 0);
            /* registra il servente presso il registry RMI */
            String helloServiceName = "rmi:/asw/Hello";
            logger.info("Server: Binding: " + helloServiceName);
			/* il registry deve essere in esecuzione su questo stesso nodo */ 
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(helloServiceName, helloStub);
            logger.info("Server: " + helloServiceName + " bound");
        } catch (Exception e) {
            logger.info("Server: Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

}


