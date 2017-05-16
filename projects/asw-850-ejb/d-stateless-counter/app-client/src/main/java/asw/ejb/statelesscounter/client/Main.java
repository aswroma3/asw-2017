package asw.ejb.statelesscounter.client;

import asw.ejb.statelesscounter.StatelessCounter;

import javax.ejb.EJB;

import java.util.logging.Logger;

/*
 * Application client per l'EJB StatelessCounter.
 */
public class Main {

	@EJB(lookup = "ejb/asw/StatelessCounter")
	private static StatelessCounter counter;

	/* logger */
	private static Logger logger = Logger.getLogger("asw.ejb.statelesscounter.client");

	public static void main(String[] args) {
		new Main() . run();
	}

	public Main() {
	}

	private void run() {
		logger.info("StatelessCounter AppClient: Ora invoco 20 volte il metodo getCounter() di un bean StatelessCounter: ");
		for (int i=1; i<=20; i++) {
			logger.info("StatelessCounter AppClient: Invocazione " + i + ": " + counter.getCounter());
			sleep(250);
		}
		logger.info("StatelessCounter AppClient: Ho finito di usare il bean StatelessCounter");
	}

	/* Introduce un ritardo di esattamente delay millisecondi. */
	private static void sleep(int delay) {
        try {
        	// int delay = (int)(Math.random()*maxDelay);
            Thread.sleep(delay);
        } catch (InterruptedException e) {}
	}
	
}