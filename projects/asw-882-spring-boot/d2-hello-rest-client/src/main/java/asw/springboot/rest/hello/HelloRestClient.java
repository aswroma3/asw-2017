package asw.springboot.rest.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*; 

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.client.RestTemplate; 

@Component
public class HelloRestClient implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(HelloRestClient.class);

	public void run(String[] args) {
		RestTemplate restTemplate = new RestTemplate(); 
		String helloworld = restTemplate.getForObject("http://localhost:8080/helloworld", String.class);
		
		/* ripete tante volte, altrimenti si perde tra i log di Spring Boot */
		for (int i=0; i<3; i++) {
			logger.info( helloworld );
		}

//		String helloMario = restTemplate.getForObject("http://localhost:8080/hello/Mario", String.class);
		String helloMario = restTemplate.getForObject("http://localhost:8080/hello/{name}", String.class, "Mario");
		
		/* ripete tante volte, altrimenti si perde tra i log di Spring Boot */
		for (int i=0; i<3; i++) {
			logger.info( helloMario );
		}

//		String ciaoMario = restTemplate.getForObject("http://localhost:8080/hello?name=Mario&lang=it", String.class);
		Map<String, String> urlVariables = new HashMap<>(); 
		urlVariables.put("name", "Mario");
		urlVariables.put("lang", "it");		
		String ciaoMario = restTemplate.getForObject("http://localhost:8080/hello?name={name}&lang={lang}", String.class, urlVariables);
		
		/* ripete tante volte, altrimenti si perde tra i log di Spring Boot */
		for (int i=0; i<3; i++) {
			logger.info( ciaoMario );
		}
		
	}
	
}
