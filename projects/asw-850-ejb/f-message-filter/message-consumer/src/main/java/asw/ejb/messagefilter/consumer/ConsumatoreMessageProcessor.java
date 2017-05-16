package asw.ejb.messagefilter.consumer;

import javax.jms.*;

import asw.jms.simplemessageprocessor.SimpleMessageProcessor;

import java.util.logging.Logger;

/*
 * Ascoltatore di messaggi.
 * Implementa MessageListener.
 * Visualizza il messaggio ricevuto.
 */
public class ConsumatoreMessageProcessor implements SimpleMessageProcessor {

	/* logger */
	private static Logger logger = Logger.getLogger("asw.ejb.messagefilter.consumer");

	/* numero di messaggi ricevuti */
	private int messaggiRicevuti;

	/**
	 * Crea un nuovo ConsumatoreMessageProcessor.
	 */
	public ConsumatoreMessageProcessor() {
		this.messaggiRicevuti = 0;
	}

	/*
	 * Gestisce la ricezione di un messaggio:
	 * visualizza il messaggio ricevuto.
	 */
	public void processMessage(String message) {
		/* conta il messaggio ricevuto */
		this.messaggiRicevuti++;
		/* visualizza il messaggio */
		logger.info("MessageProcessor: Ricevuto messaggio # " + messaggiRicevuti + ": "+ message);
	}

}
