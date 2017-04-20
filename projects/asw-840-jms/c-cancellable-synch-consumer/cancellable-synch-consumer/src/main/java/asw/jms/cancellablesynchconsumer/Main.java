package asw.jms.cancellablesynchconsumer;

import javax.jms.*;
import javax.annotation.Resource;

import java.util.logging.Logger;

import asw.util.cancellable.KeyboardKiller;
import asw.util.sleep.Sleeper;

/**
 * Main.java
 *
 * Classe principale per l'application client CancellableSynchProducer.
 *
 * Esecuzione: dal prompt dei comandi, dalla cartella del progetto, tramite appclient:
 * appclient -client build\SimpleSynchConsumer <nome-destinazione)> <nome-consumer> <ritardo-tra-messaggi> <numero-messaggi>
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
	
	// private static final String BASE_CONSUMER_NAME = "CancellableSynchConsumer";
	private static final String BASE_CONSUMER_NAME = "CSC";

	/* logger */
	private static Logger logger = Logger.getLogger("asw.jms.cancellablesynchconsumer");

	/**
     * Utilizzo nel caso in cui l'application client viene eseguito nell'host dell'AS:
     *     appclient -client SimpleSynchConsumer.jar [<nome-destinazione> [<nome-producer> [<delay> [<numero-messaggi>] ] ] ]
     *
     * @param args the command line arguments:
     * @param args[0] il nome della destinazione: "jms/asw/Queue" o "jms/asw/Topic" [opt] default = jms/asw/Queue
     * @param args[1] il nome del consumer [opt] default = nome casuale
     * @param args[2] ritardo massimo per il consumo dei messaggi, in ms [opt] default = 400
     * @param args[3] numero di messaggi ricevuti - 0 per infinito [opt] default = 0
     */
    public static void main(String[] args) {
    	String consumerName = null;
    	String destinationName = null;
        int    maxDelay;
        int    numMsgs;

        /* accesso ed analisi dei parametri */

        /* valori di default */
    	destinationName = QUEUE_NAME;
    	consumerName = BASE_CONSUMER_NAME + "[" + (int)(Math.random()*1000) + "]";
    	maxDelay = 400;
        numMsgs = 0;  /* 0 vuol dire: ricevi messaggi all'infinito */

    	/* prova a vedere i parametri specificati dall'utente */
        try {
        	destinationName = new String(args[0]);
        	consumerName = new String(args[1]);
        	maxDelay = (new Integer(args[2])).intValue();
            numMsgs = (new Integer(args[3])).intValue();
        } catch(Exception e) {
        	/* indice fuori dai limiti o altro errore (e.g., conversione) */
        	/* ok, ci sono i valori di default */
        }


        /*
         * attivita' principali del programma:
         * riceve una sequenza di messaggi tramite un CancellableSynchConsumer
         */
        logger.info("cancellableconsumer.Main: " + consumerName + " ready to receive " + numMsgs + " messages from " + destinationName);

        /* crea un consumer */
//        CancellableSynchConsumer cancellableConsumer = new CancellableSynchConsumer(consumerName, destination, connectionFactory);
        CancellableSynchConsumer cancellableConsumer = new CancellableSynchConsumer(consumerName, destinationName, CONNECTION_FACTORY_NAME);
        logger.info("cancellableconsumer.Main: Creato consumer: " + cancellableConsumer.toString());

        /* la cancellazione del consumer avviene premendo il tasto INVIO dalla tastiera */

        KeyboardKiller k = new KeyboardKiller();
        k.add(cancellableConsumer);
        k.start();

        /* connessione */
    	cancellableConsumer.connect();
    	cancellableConsumer.start();

    	/* ricezione messaggi */
    	for (int i=0; i<numMsgs || numMsgs==0; i++) {
        	String message = cancellableConsumer.receiveMessage();
        	logger.info("ConsumerThread: " + consumerName + ": Received message: " + message);
        	Sleeper.randomSleep(maxDelay/2,maxDelay);
        	/* se il consumatore e' stato cancellato, allora interrompe la ricezione di messaggi */
        	if (cancellableConsumer.isCancelled()) {
        		break;
        	}
    	}

    	/* disconnessione */
    	cancellableConsumer.stop();
        cancellableConsumer.disconnect();

        logger.info("cancellableconsumer.Main: Consumer: " + consumerName + ": Done");
        System.exit(0);

    }

}
