package asw.springboot.team;

import asw.springboot.team.domain.*; 

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate; 

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class TeamApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void restTemplateTest() {
		RestTemplate restTemplate = new RestTemplate(); 
		Team team = restTemplate.getForObject("http://localhost:8080/team", Team.class);
		assertEquals("Peanuts", team.getName()); 
	}	
	
}
