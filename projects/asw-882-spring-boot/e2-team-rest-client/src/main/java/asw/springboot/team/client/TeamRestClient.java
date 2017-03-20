package asw.springboot.team.client;

import asw.springboot.team.domain.*; 

import java.util.Set; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.client.RestTemplate; 

@Component
public class TeamRestClient implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(TeamRestClient.class);

	public void run(String[] args) {
		RestTemplate restTemplate = new RestTemplate(); 
		Team team = restTemplate.getForObject("http://localhost:8080/team", Team.class);
		
		/* ripete tante volte, altrimenti si perde tra i log di Spring Boot */
		for (int i=0; i<10; i++) {
			logger.info( team.getName() );
//			System.out.println( team.getName() );
		}
	}
	
}
