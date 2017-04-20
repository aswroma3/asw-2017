package asw.jms.simplefilter;

import javax.jms.*;
import javax.annotation.Resource;

import java.util.logging.Logger;
import asw.jms.simplemessagefilter.*;
import asw.util.cancellable.KeyboardKiller;

/**
 * Main.java
 *
 * Classe principale per l'application client SimpleFilter.
 *
 * Esecuzione: dal prompt dei comandi, dalla cartella del progetto, tramite appclient:
 * appclient -client build\SimpleFilter <nome-sorgente> <nome-destinazione> <nome-filtro> <ritardo-tra-messaggi>
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
	private static Logger logger = Logger.getLogger("asw.jms.simplefilter");

	/**
     * Utilizzo nel caso in cui l'application client viene eseguito nell'host dell'AS:
     *     appclient -client SimpleFilter.jar [<nome-sorgente> [<nome-destinazione> [<client-name> [<delay>] ] ] ]
     *
     * @param args the command line arguments:
     * @param args[0] la sorgente del filtro: "jms/asw/Queue" o "jms/asw/Topic" [opt] default = jms/asw/Queue
     * @param args[1] la destinazione del filtro: "jms/asw/Queue" o "jms/asw/Topic" [opt] default = jms/asw/Topic
     * @param args[2] il nome del consumer [opt] default = nome casuale
     * @param args[3] ritardo massimo per il consumo dei messaggi, in ms [opt] default = 400
     */
    public static void main(String[] args) {
    	String filterName = null;
    	String sourceName = null;
    	String destinationName = null;
        int maxDelay;

        /* accesso ed analisi dei parametri */

        /* valori di default */
    	sourceName = QUEUE_NAME;
    	destinationName = TOPIC_NAME;
    	filterName = BASE_CONSUMER_NAME + "[" + (int)(Math.random()*1000) + "]";
    	maxDelay = 400;

    	/* prova a vedere i parametri specificati dall'utente */
        try {
        	sourceName = new String(args[0]);
        	destinationName = new String(args[1]);
        	filterName = new String(args[2]);
        	maxDelay = (new Integer(args[3])).intValue();
        } catch(Exception e) {
        	/* indice fuori dai limiti o altro errore (e.g., conversione) */
        	/* ok, ci sono i valori di default */
        }

        if (sourceName.equals(destinationName)) {
            System.out.println("Source and destination should differ");
            System.exit(1);        	
        }
        

        /*
         * attivita' principali del programma:
         * riceve una sequenza di messaggi tramite un SimpleAsynchConsumer
         */
        logger.info("simplefilter.Main: " + filterName + " ready to receive messages from the " + sourceName);
        logger.info("simplefilter.Main: " + filterName + " ready to send messages to the " + destinationName);

        /* crea un message filter */
        SimpleMessageFilter messageFilter = new LoggerMessageFilter(filterName);
        /* crea il filtro */ 
//        SimpleFilter simpleFilter = new SimpleFilter(filterName, source, destination, connectionFactory, messageFilter, maxDelay);
        SimpleFilter simpleFilter = new SimpleFilter(filterName, sourceName, destinationName, CONNECTION_FACTORY_NAME, messageFilter, maxDelay);
        logger.info("simplefilter.Main: Creato filter: " + simpleFilter.toString());

        /* la cancellazione del filtro avviene premendo il tasto INVIO dalla tastiera */

        KeyboardKiller k = new KeyboardKiller();
        k.add(simpleFilter);
        k.start();

        /* connessione */
    	simpleFilter.connect();

    	/* filtraggio messaggi */
    	simpleFilter.filterMessages();

    	/* disconnessione */
        simpleFilter.disconnect();

        logger.info("simplefilter.Main: Filter: " + filterName + ": Done");
        System.exit(0);

    }

}
