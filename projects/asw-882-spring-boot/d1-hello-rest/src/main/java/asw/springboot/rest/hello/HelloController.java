package asw.springboot.rest.hello;

import java.util.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestParam; 

import javax.annotation.PostConstruct;

@RestController
public class HelloController {

	/* mappa (dei formati) dei saluti nelle diverse lingue */
	private Map<String, String> saluti;

	@PostConstruct
	public void init() {
		/* inizializza la mappa dei saluti */
		saluti = new HashMap<>();
		saluti.put("it", "Ciao, %s!");
		saluti.put("en", "Hello, %s!");
		saluti.put("fr", "Bonjour, %s!");
		saluti.put("es", "Hola, %s!");
	}

    /* Restituisce Hello, world!
     * acceduta come GET /helloworld */
	@RequestMapping("/helloworld")
	public String helloworld() {
		return "Hello, world!"; 
	}
	
    /* Restituisce un saluto a "name"
     * acceduta come GET /hello/{name} */
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return "Hello, " + name + "!"; 
	}

    /* Restituisce un saluto a "name" nel "language" specificato
     * acceduta come GET /hello?name={name}&lang={language} */
	@RequestMapping("/hello")
    public String hello(@RequestParam("name") String name,
                        @RequestParam(value="lang", required=false, defaultValue="en") String lang) {
		String format = saluti.get(lang);
		String result = String.format(format, name);
		return result; 
    }	
	
}
