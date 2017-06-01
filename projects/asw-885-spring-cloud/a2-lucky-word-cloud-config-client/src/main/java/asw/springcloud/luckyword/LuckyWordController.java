package asw.springcloud.luckyword;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class LuckyWordController {

	@Value("${lucky-word}") 
	private String luckyWord;

	@RequestMapping("/lucky-word")
	public String luckyWord() {
		return "The lucky word is: " + luckyWord; 
	}
}
