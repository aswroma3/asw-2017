package asw.jms.simplemessageprocessor;

import java.util.logging.Logger;

/**
 * LoggerMessageProcessor.java
 *
 * LoggerMessageProcessor e' un esempio di consumatore finale di messaggi
 * che vengono ricevuti in modo asincrono.
 *
 * I messaggi vengono ricevuti tramite un SimpleAsynchConsumer,
 * ma l'elaborazione di ciascun messaggio viene invece fatta
 * da un LoggerMessageProcessor che implementa SimpleMessageProcessor.
 *
 * @author Luca Cabibbo
 */
public class LoggerMessageProcessor implements SimpleMessageProcessor {

	/* logger */
	private Logger logger = Logger.getLogger("asw.jms.simplemessageprocessor");

	/* nome di questo processor */
    private String name;

    /* numero di messaggi consumati finora */
    private int messagesReceived;

    /**
	 * Crea un nuovo LoggerMessageProcessor.
	 */
	public LoggerMessageProcessor(String name) {
		this.name = name;
		this.messagesReceived = 0;
	}

	/**
	 * Elabora il messaggio di testo message.
	 */
	public void processMessage(String message) {
		this.messagesReceived++;
    	logger.info(this.name + ": Reading message #" + this.messagesReceived + ": " + message);
	}

}
