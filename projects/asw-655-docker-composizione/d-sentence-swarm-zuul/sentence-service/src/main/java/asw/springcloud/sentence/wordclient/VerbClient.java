package asw.springcloud.sentence.wordclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="verb", url="verb:8080")
public interface VerbClient {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getWord(); 

}
