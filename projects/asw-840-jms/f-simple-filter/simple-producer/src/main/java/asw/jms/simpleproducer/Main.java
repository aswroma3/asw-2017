package asw.jms.simpleproducer;

import javax.jms.*;
import javax.annotation.Resource;

import java.util.logging.Logger;

/**
 * Main.java
 *
 * Classe principale per l'application client SimpleProducer.
 *
 * Esecuzione: dal prompt dei comandi, dalla cartella del progetto, tramite appclient:
 * appclient -client build\SimpleProducer <nome-destinazione> <nome-producer> <ritardo-tra-messaggi> <numero-messaggi>
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

	// private static final String BASE_PRODUCER_NAME = "SimpleProducer";
	private static final String BASE_PRODUCER_NAME = "SP";

	/* logger */
	private static Logger logger = Logger.getLogger("asw.jms.simpleproducer");

	/**
     * Utilizzo nel caso in cui l'application client viene eseguito nell'host dell'AS:
     *     appclient -client SimpleProducer.jar [<nome-destinazione> [<nome-producer> [<delay> [<numero-messaggi>] ] ] ]
     *
     * @param args the command line arguments:
     * @param args[0] il nome della destinazione: "jms/asw/Queue" o "jms/asw/Topic" [opt] default = jms/asw/Queue
     * @param args[1] il nome del producer [opt] default = nome casuale
     * @param args[2] ritardo massimo per la generazione dei messaggi, in ms [opt] default = 500
     * @param args[3] numero di messaggi inviati - 0 per inviare un solo messaggio vuoto (finale) [opt] default = 20
     */
    public static void main(String[] args) {
    	String producerName = null;
    	String destinationName = null;
        int    maxDelay;
        int    numMsgs;


        /* accesso ed analisi dei parametri */

        /* valori di default */
    	destinationName = QUEUE_NAME;
    	producerName = BASE_PRODUCER_NAME + "[" + (int)(Math.random()*1000) + "]";
    	maxDelay = 500;
        numMsgs = 20;

    	/* prova a vedere i parametri specificati dall'utente */
        try {
        	destinationName = new String(args[0]);
        	producerName = new String(args[1]);
        	maxDelay = (new Integer(args[2])).intValue();
            numMsgs = (new Integer(args[3])).intValue();
        } catch(Exception e) {
        	/* indice fuori dai limiti o altro errore (e.g., conversione) */
        	/* ok, ci sono i valori di default */
        }

        /*
         * attivita' principali del programma:
         * invia una sequenza di messaggi tramite un SimpleProducer
         */

        logger.info("simpleproducer.Main: " + producerName + " will send " + numMsgs + " messages to " + destinationName);

        /* crea un producer */
//        SimpleProducer simpleProducer = new SimpleProducer(producerName, destination, connectionFactory);
        SimpleProducer simpleProducer = new SimpleProducer(producerName, destinationName, CONNECTION_FACTORY_NAME);
        logger.info("simpleproducer.Main: Creato producer: " + simpleProducer.toString());

        /* connessione */
        simpleProducer.connect();

        /* invio di nomMsgs messaggi */
        for (int i=1; i<=numMsgs; i++) {
        	simpleProducer.sendMessage("Message #" + i + " from " + producerName);
        	randomSleep(maxDelay/2,maxDelay);
        }

        /* se richiesto, infine invia un messaggio vuoto (usato qui per interrompere il consumer) */
        if (numMsgs==0) {
        	simpleProducer.sendMessage("");
        }

        /* disconnessione */
    	simpleProducer.disconnect();

    	logger.info("simpleproducer.Main: producer " + producerName + ": Done");
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
