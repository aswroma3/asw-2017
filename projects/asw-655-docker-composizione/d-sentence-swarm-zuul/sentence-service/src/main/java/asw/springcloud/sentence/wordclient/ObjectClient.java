package asw.springcloud.sentence.wordclient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="object", url="object:8080")
public interface ObjectClient {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getWord(); 

}
