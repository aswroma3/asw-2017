package asw.ejb.messagefilter.producer;

public class Main {

    private final static String queueOne = "jms/asw/ejb/QueueOne";
    private final static String connectionFactory = "jms/asw/ConnectionFactory";

    public static void main(String[] args) {
    	ProduttoreMessaggi client = new ProduttoreMessaggi(queueOne, connectionFactory);
    	client.run();
    }

}
