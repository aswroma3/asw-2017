package asw.ejb.calculator.client;

import asw.ejb.calculator.Calculator;

import javax.ejb.EJB;

import java.util.logging.Logger;

/*
 * Normalmente viene eseguito il client con un'interfaccia testuale,
 * ma l'uso di un argomento X11 fa' si' che venga eseguito il client
 * con un'interfaccia Swing.
 */
public class Main {

	@EJB(mappedName = "ejb/asw/Calculator")
	private static Calculator calculator;

	/* logger */
	private Logger logger = Logger.getLogger("asw.ejb.calculator.client");

	public static void main(String[] args) {
		new Main() . run();
	}

	public Main() {
	}

	public void run() {

		this.println("Calculator Application Client");

//		Sleeper.sleep(1000);

		this.println("Ora accedo al bean Calculator per calcolare la radice quadrata di 16");
		this.println("calculator.sqrt(16) ==> " + calculator.sqrt(16));

//		Sleeper.sleep(1000);

		this.println("Ora accedo al bean Calculator per calcolare altre radici quadrate");
		for (int i=0; i<=20; i++) {
			this.println("calculator.sqrt( " + i + " ) ==> " + calculator.sqrt(i));
		}

//		Sleeper.sleep(1000);

		this.println("Ho finito di usare il bean Calculator");
	}

	private void println(String x) {
		logger.info(x);
	}	
	
}