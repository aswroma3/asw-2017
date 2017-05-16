package asw.ejb.counter.client;

import asw.ejb.counter.SessionCounter;

import java.util.logging.Logger;

import javax.ejb.EJB;

/*
 * Application client per l'EJB SessionCounter.
 */
public class Main {

	@EJB(lookup = "ejb/asw/SessionCounter")
	private static SessionCounter counter;

	/* logger */
	private static Logger logger = Logger.getLogger("asw.ejb.counter.client");

	public static void main(String[] args) {
		new Main() . run();
	}

	public Main() {
	}

	private void run() {
		logger.info("SessionCounter AppClient: Ora invoco 20 volte il metodo getCounter() di un bean SessionCounter: ");
		for (int i=1; i<=20; i++) {
			logger.info("SessionCounter AppClient: Invocazione " + i + ": " + counter.getCounter());
			sleep(150);
		}
		counter.close();
		logger.info("SessionCounter AppClient: Ho finito di usare il bean SessionCounter");
	}

	/* Introduce un ritardo di esattamente delay millisecondi. */
	private static void sleep(int delay) {
        try {
        	// int delay = (int)(Math.random()*maxDelay);
            Thread.sleep(delay);
        } catch (InterruptedException e) {}
	}
	
}