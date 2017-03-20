package asw.springboot.hello;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// in alternativa 
// import java.util.logging.Logger; 

@Component
public class MyHelloRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(MyHelloRunner.class);
	
	// in alternativa 
	// private static final Logger logger = Logger.getLogger("asw.springboot.hello"); 

	public void run(String[] args) {
		
		/* ripete tante volte, altrimenti si perde tra i log di Spring Boot */
		for (int i=0; i<10; i++) {
			// System.out.println("Hello, world!");
			logger.info("Hello, world!"); 
		}
	}
}
