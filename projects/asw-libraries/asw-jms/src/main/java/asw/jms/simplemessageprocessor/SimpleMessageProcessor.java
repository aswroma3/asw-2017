package asw.jms.simplemessageprocessor;

/**
 * SimpleMessageProcessor.java
 *
 * Definisce l'interfaccia di un oggetto/componente in grado
 * di elaborare un messaggio di testo.
 *
 * @author Luca Cabibbo
 */
public interface SimpleMessageProcessor {

	/**
	 * Elabora il messaggio di testo message.
	 */
	public void processMessage(String message);

}
