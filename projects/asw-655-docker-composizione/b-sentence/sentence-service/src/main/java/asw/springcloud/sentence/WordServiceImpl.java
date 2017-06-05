package asw.springcloud.sentence;

import asw.springcloud.sentence.wordclient.*;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service 
public class WordServiceImpl implements WordService {

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
		return "Someone"; 
	}
	
	@HystrixCommand(fallbackMethod="getFallbackVerb")
	public String getVerb() {
		return verbClient.getWord(); 
	}
	
	public String getFallbackVerb() {
		return "does"; 
	}
	
	@HystrixCommand(fallbackMethod="getFallbackObject")
	public String getObject() {
		return objectClient.getWord(); 
	}
	
	public String getFallbackObject() {
		return "something"; 
	}

}
