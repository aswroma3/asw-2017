package asw.ejb.messagefilter.consumer;

import javax.jms.*;

import asw.jms.simpleasynchconsumer.SimpleAsynchConsumer;
import asw.jms.simpleasynchconsumer.SimpleAsynchConsumerThread;

import asw.jms.simplemessageprocessor.SimpleMessageProcessor;

import asw.util.cancellable.KeyboardKiller;
import java.util.logging.Logger;

public class ConsumatoreMessaggi {

	/* logger */
	private static Logger logger = Logger.getLogger("asw.ejb.messagefilter.consumer");

	/* la destinazione da cui consumare messaggi */
	private String destination;

	/* connection factory */
	private String connectionFactory;

    /* il destinatario finale dei messaggi */
    SimpleMessageProcessor messageProcessor;

	/* Crea un nuovo consumatore di messaggi. */
	public ConsumatoreMessaggi(String destination, String connectionFactory) {
		this.destination = destination;
		this.connectionFactory = connectionFactory;
	}

    public void run() {

		/* definizione dei parametri */
    	String name = "Consumatore[" + (int)(Math.random()*1000) + "]";

		/* crea il consumatore "finale" del messaggio */
		messageProcessor = new ConsumatoreMessageProcessor();

		/* crea un consumatore sulla propria destinazione - girera' messaggi al proprio processore/listener */
		SimpleAsynchConsumer consumer= new SimpleAsynchConsumer(name, destination, connectionFactory, messageProcessor);
        logger.info("Creato consumatore: " + consumer.toString());

        /* per interrompere il consumatore premendo INVIO */
        KeyboardKiller k = new KeyboardKiller();
        k.add(consumer);
        k.start();

        /* avvia il consumatore (entro un thread) */
        SimpleAsynchConsumerThread tc = new SimpleAsynchConsumerThread(consumer, consumer.toString());
        tc.start();

    	/* attende la terminazione del thread - poi termina il programma */
        try {
			tc.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        /* disconnette il consumatore */
        consumer.disconnect();
        /* termina */
        System.exit(0);
    }

}
