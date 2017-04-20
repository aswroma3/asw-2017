package asw.jms.simpleasynchconsumer;

import asw.jms.simplemessageprocessor.*;

import javax.jms.*;
import javax.annotation.Resource;

import java.util.logging.Logger;

import asw.util.cancellable.KeyboardKiller;

/**
 * Main.java
 *
 * Classe principale per l'application client SimpleAsynchProducer.
 *
 * Esecuzione: dal prompt dei comandi, dalla cartella del progetto, tramite appclient:
 * appclient -client build\SimpleAsynchConsumer <nome-destinazione)> <nome-consumer> <ritardo-tra-messaggi> 
 *
 * Variante di un esempio nel tutorial per Java EE.
 *
 * @author Luca Cabibbo
 */
public class Main {

	/* L'iniezione delle dipendenze puo' avvenire solo nella main class. */
	@Resource(lookup = "jms/asw/Queue")
    private static Queue queue;
    @Resource(lookup = "jms/asw/Topic")
    private static Topic topic;
    @Resource(lookup = "jms/asw/ConnectionFactory")
    private static ConnectionFactory connectionFactory;

	/* nome della coda */ 
	private static final String QUEUE_NAME="jms/asw/Queue"; 
	/* nome del topic */ 
	private static final String TOPIC_NAME="jms/asw/Topic"; 
	/* nome della connection factory */ 
	private static final String CONNECTION_FACTORY_NAME="jms/asw/ConnectionFactory"; 	
	
	// private static final String BASE_CONSUMER_NAME = "SimpleAsynchConsumer";
	private static final String BASE_CONSUMER_NAME = "SAC";

	/* logger */
	private static Logger logger = Logger.getLogger("asw.jms.simpleasynchconsumer");

	/**
     * Utilizzo nel caso in cui l'application client viene eseguito nell'host dell'AS:
     *     appclient -client SimpleAsynchConsumer.jar [<nome-destinazione> [<nome-producer> [<delay> ] ] ]
     *
     * @param args the command line arguments:
     * @param args[0] il nome della destinazione: "jms/asw/Queue" o "jms/asw/Topic" [opt] default = jms/asw/Queue
     * @param args[1] il nome del consumer [opt] default = nome casuale
     * @param args[2] ritardo massimo per il consumo dei messaggi, in ms [opt] default = 400
     */
    public static void main(String[] args) {
    	String consumerName = null;
    	String destinationName = null;
        int    maxDelay;

        /* accesso ed analisi dei parametri */

        /* valori di default */
    	destinationName = QUEUE_NAME;
    	consumerName = BASE_CONSUMER_NAME + "[" + (int)(Math.random()*1000) + "]";
    	maxDelay = 400;

    	/* prova a vedere i parametri specificati dall'utente */
        try {
        	destinationName = new String(args[0]);
        	consumerName = new String(args[1]);
        	maxDelay = (new Integer(args[2])).intValue();
        } catch(Exception e) {
        	/* indice fuori dai limiti o altro errore (e.g., conversione) */
        	/* ok, ci sono i valori di default */
        }


        /*
         * attivita' principali del programma:
         * riceve una sequenza di messaggi tramite un SimpleAsynchConsumer
         */
        logger.info("asynchconsumer.Main: " + consumerName + " ready to receive messages from " + destinationName);

        /* crea un message processor */
        SimpleMessageProcessor messageProcessor = new LoggerMessageProcessor(consumerName);
//        SimpleAsynchConsumer asynchConsumer = new SimpleAsynchConsumer(consumerName, destination, connectionFactory, messageProcessor, maxDelay);
        SimpleAsynchConsumer asynchConsumer = new SimpleAsynchConsumer(consumerName, destinationName, CONNECTION_FACTORY_NAME, messageProcessor, maxDelay);
        logger.info("asynchconsumer.Main: Creato consumer: " + asynchConsumer.toString());

        /* la cancellazione del consumer avviene premendo il tasto INVIO dalla tastiera */

        KeyboardKiller k = new KeyboardKiller();
        k.add(asynchConsumer);
        k.start();

        /* connessione */
    	asynchConsumer.connect();

    	/* ricezione messaggi */
    	asynchConsumer.receiveMessages();

    	/* disconnessione */
        asynchConsumer.disconnect();

        logger.info("asynchconsumer.Main: Consumer: " + consumerName + ": Done");
        System.exit(0);

    }

}
