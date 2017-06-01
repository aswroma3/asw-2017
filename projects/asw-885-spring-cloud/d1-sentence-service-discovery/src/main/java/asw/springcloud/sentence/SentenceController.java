package asw.springcloud.sentence;

import java.net.URI;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger; 

@RestController
public class SentenceController {

	private final Logger logger = Logger.getLogger("asw.springcloud.sentence"); 

	@Autowired 
	private DiscoveryClient discoveryClient;

	@RequestMapping("/sentence")
	public String getSentence() {
		String sentence =  
			getWord("subject") + " " + 
			getWord("verb") + " " + 
			getWord("object") + ".";
		logger.info("getSentence(): " + sentence);
		return sentence; 
	}
	
	public String getWord(String service) {
		List<ServiceInstance> list = discoveryClient.getInstances(service);
		if (list!=null && list.size()>0) {
			URI uri = list.get(0).getUri();
			if (uri!=null) {
				return new RestTemplate().getForObject(uri,String.class);
			}
		}
		return null;
	}	
	
}
