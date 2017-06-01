package asw.springcloud.sentence;

import asw.springcloud.sentence.wordclient.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger; 

@RestController
public class SentenceController {

	private final Logger logger = Logger.getLogger("asw.springcloud.sentence"); 

	@Autowired 
	private SubjectClient subjectClient;

	@Autowired 
	private VerbClient verbClient;

	@Autowired 
	private ObjectClient objectClient;
	
	@RequestMapping("/sentence")
	public String getSentence() {
		String sentence =  
			subjectClient.getWord() + " " + 
			verbClient.getWord() + " " + 
			objectClient.getWord() + ".";
		logger.info("getSentence(): " + sentence);
		return sentence; 
	}

}
