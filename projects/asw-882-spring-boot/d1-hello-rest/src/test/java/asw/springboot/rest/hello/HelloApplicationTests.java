package asw.springboot.rest.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.util.*; 

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testHelloworld() {
		assertEquals(
			"Hello, world!", 
			restTemplate.getForObject("/helloworld", String.class)
		);
	}

	@Test
	public void testHelloMario() {
		assertEquals(
			"Hello, Mario!", 
			restTemplate.getForObject("/hello/{name}", String.class, "Mario")
		);
	}	

	@Test
	public void testHelloMarioIt() {
		Map<String, String> urlVariables = new HashMap<>(); 
		urlVariables.put("name", "Mario");
		urlVariables.put("lang", "it");		
		assertEquals(
			"Ciao, Mario!", 
			restTemplate.getForObject("/hello?name={name}&lang={lang}", String.class, urlVariables)
		);
	}	

}
