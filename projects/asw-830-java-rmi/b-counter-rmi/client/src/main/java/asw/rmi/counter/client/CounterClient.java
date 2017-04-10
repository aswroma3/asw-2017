package asw.rmi.counter.client;

import asw.rmi.counter.service.Counter;

import java.rmi.RemoteException;

import java.util.logging.Logger;

public class CounterClient {

	/* logger */
	private Logger logger = Logger.getLogger("asw.rmi.counter.client");

	/* il servizio */
	private Counter counter;

	public CounterClient(Counter counter) {
		this.counter = counter;
	}

	public void run() {
        /* usa il servizio remoto */
        try {
        	logger.info("CounterClient: Ora uso il servizio Counter");
        	for (int i=0; i<25; i++) {
        		int result = counter.getCounter();
            	logger.info("CounterClient: counter.getCounter() ==> " + result);
        		/* introduci un ritardo causale (comunque meno di 1 secondo) */
            	randomSleep(400,800);
        	}
        } catch (RemoteException e) {
            logger.info("CounterClient: RemoteException: " + e.getMessage());
        }
    }

	/* Introduce un ritardo di esattamente delay millisecondi. */
	private static void sleep(int delay) {
        try {
        	// int delay = (int)(Math.random()*maxDelay);
            Thread.sleep(delay);
        } catch (InterruptedException e) {}
	}

	/* Introduce un ritardo casuale, compreso tra minDelay e maxDelay millisecondi. */
	private static void randomSleep(int minDelay, int maxDelay) {
    	int delay = (int)(minDelay + Math.random()*(maxDelay-minDelay));
    	sleep(delay);
	}	
	
}
