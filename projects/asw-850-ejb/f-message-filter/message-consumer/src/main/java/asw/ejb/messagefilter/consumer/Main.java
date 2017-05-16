package asw.ejb.messagefilter.consumer;

public class Main {

    private final static String queueTwo = "jms/asw/ejb/QueueTwo";
    private final static String connectionFactory = "jms/asw/ConnectionFactory";

    public static void main(String[] args) {
    	ConsumatoreMessaggi client = new ConsumatoreMessaggi(queueTwo, connectionFactory);
    	client.run();
    }

}
