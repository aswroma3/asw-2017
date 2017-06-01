package asw.springcloud.sentence;

import asw.springcloud.sentence.wordclient.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.logging.Logger; 

@Service 
public class WordServiceImpl implements WordService {

	private final Logger logger = Logger.getLogger("asw.springcloud.sentence"); 

	@Autowired 
	private SubjectClient subjectClient;

	@Autowired 
	private VerbClient verbClient;

	@Autowired 
	private ObjectClient objectClient;
	
	@HystrixCommand(fallbackMethod="getFallbackSubject")
	public String getSubject() {
		return subjectClient.getWord(); 
	} 
	
	public String getFallbackSubject() {
		logger.info("getSubject(): using fallback word: Someone");
		return "Someone"; 
	}
	
	@HystrixCommand(fallbackMethod="getFallbackVerb")
	public String getVerb() {
		return verbClient.getWord(); 
	}
	
	public String getFallbackVerb() {
		logger.info("getVerb(): using fallback word: does");
		return "does"; 
	}
	
	@HystrixCommand(fallbackMethod="getFallbackObject")
	public String getObject() {
		return objectClient.getWord(); 
	}
	
	public String getFallbackObject() {
		logger.info("getObject(): using fallback word: something");
		return "something"; 
	}

}
