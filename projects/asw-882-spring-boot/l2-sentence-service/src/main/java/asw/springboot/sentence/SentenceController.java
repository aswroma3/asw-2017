package asw.springboot.sentence;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger; 

@RestController
public class SentenceController {

	private final Logger logger = Logger.getLogger("asw.springboot.sentence"); 

	@Value("${word.subject.uri}") 
	private String subjectUri;

	@Value("${word.verb.uri}") 
	private String verbUri;

	@Value("${word.object.uri}") 
	private String objectUri;

	@RequestMapping("/sentence")
	public String getSentence() {
		String sentence =  
			getSubject() + " " + 
			getVerb() + " " + 
			getObject() + ".";
		logger.info("getSentence(): " + sentence);
		return sentence; 
	}
	
	private String getWord(String uri) {
		return new RestTemplate().getForObject(uri,String.class);
	}	

	private String getSubject() {
		return getWord(subjectUri);
	}	

	private String getVerb() {
		return getWord(verbUri);
	}	

	private String getObject() {
		return getWord(objectUri);
	}	
	
}
