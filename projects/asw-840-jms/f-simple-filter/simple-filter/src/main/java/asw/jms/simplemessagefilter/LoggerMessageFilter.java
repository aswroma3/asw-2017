package asw.jms.simplemessagefilter;

import java.util.logging.Logger;

/**
 * LoggerMessageFilter.java
 *
 * LoggerMessageFilter e' un esempio di filtro, che dunque definisce come filtrare dei messaggi testuali 
 * (nell'ipotesi semplificativa che a ciascun messaggio in entrata debba corrispondere 
 * esattamente un messaggio in uscita. 
 *
 * I messaggi vengono ricevuti tramite un SimpleFilter,
 * ma l'elaborazione di ciascun messaggio viene invece fatta
 * da un LoggerMessageFilter che implementa SimpleMessageFilter.
 *
 * @author Luca Cabibbo
 */
public class LoggerMessageFilter implements SimpleMessageFilter {

	/* logger */
	private Logger logger = Logger.getLogger("asw.jms.simplemessagefilter");

	/* nome di questo filter */
    private String name;

    /* numero di messaggi filtrati finora */
    private int messagesReceived;

    /**
	 * Crea un nuovo LoggerMessageFilter.
	 */
	public LoggerMessageFilter(String name) {
		this.name = name;
		this.messagesReceived = 0;
	}

	/**
	 * Filtra il messaggio di testo inMessage.
	 */
	public String filterMessage(String inMessage) {
		this.messagesReceived++;
		String outMessage = "* " + inMessage + " * (filtered by " + name + ")"; 
    	logger.info(this.name + ": Reading message #" + this.messagesReceived + ": " + inMessage);
    	logger.info(this.name + ": Sending message #" + this.messagesReceived + ": " + outMessage);
    	return outMessage; 
	}

}
