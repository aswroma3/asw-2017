package asw.jms.simplesynchconsumer;

import javax.jms.*;
import javax.annotation.Resource;

import java.util.logging.Logger;

/**
 * Main.java
 *
 * Classe principale per l'application client SimpleSynchProducer.
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
	
	
	// private static final String BASE_CONSUMER_NAME = "SimpleSynchConsumer";
	private static final String BASE_CONSUMER_NAME = "SSC";

	/* logger */
	private static Logger logger = Logger.getLogger("asw.jms.simplesynchconsumer");

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
         * riceve una sequenza di messaggi tramite un SimpleSynchConsumer
         */
        logger.info("simpleconsumer.Main: " + consumerName + " ready to receive " + numMsgs + " messages from " + destinationName);

        /* crea un consumer */
//        SimpleSynchConsumer simpleConsumer = new SimpleSynchConsumer(consumerName, destination, connectionFactory);
        SimpleSynchConsumer simpleConsumer = new SimpleSynchConsumer(consumerName, destinationName, CONNECTION_FACTORY_NAME);
        logger.info("simpleconsumer.Main: Creato consumer: " + simpleConsumer.toString());

        /* connessione */
    	simpleConsumer.connect();
    	simpleConsumer.start();

    	/* ricezione messaggi */
    	for (int i=0; i<numMsgs || numMsgs==0; i++) {
        	String message = simpleConsumer.receiveMessage();
        	randomSleep(maxDelay/2,maxDelay);
        	/* se e' arrivato un messaggio vuoto, allora interrompe la ricezione di messaggi */
        	if (message==null || message.length()==0) {
        		break;
        	}
    	}

    	/* disconnessione */
    	simpleConsumer.stop();
        simpleConsumer.disconnect();

        logger.info("simpleconsumer.Main: Consumer: " + consumerName + ": Done");
        System.exit(0);
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
