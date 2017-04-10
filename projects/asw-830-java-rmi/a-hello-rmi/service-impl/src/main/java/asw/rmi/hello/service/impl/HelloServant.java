package asw.rmi.hello.service.impl;

import asw.rmi.hello.service.*;

import java.util.logging.Logger;

/**
 * Implementazione del servizio Hello.
 */
public class HelloServant implements Hello {

	/* logger */
	private Logger logger = Logger.getLogger("asw.rmi.hello.service.impl");

	public HelloServant() {
		super();
	}

	/**
	 * Crea un saluto specifico per il nome name.
	 * Name deve essere non nullo, altrimenti viene sollevata una HelloException.
	 */
    public String sayHello(String name) throws HelloException {
    	if (name==null) {
			logger.info("HelloServant: executing sayHello: HelloException: name is null");
    		throw new HelloException("HelloServant: executing sayHello: HelloException: name is null");
    	} else {
        	String result = "Hello, " + name + "!";
        	/* se il nome e' molto lungo, introduce un ritardo */
        	if (name.length()>20) {
        		sleep(10000);
        	}
			logger.info("HelloServant: executing sayHello(" + name + ") ==> " + result);
        	return result;
    	}
	}
	
	/* Introduce un ritardo di esattamente delay millisecondi. */
	private static void sleep(int delay) {
        try {
        	// int delay = (int)(Math.random()*maxDelay);
            Thread.sleep(delay);
        } catch (InterruptedException e) {}
	}	
	
}

