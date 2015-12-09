package fil.tiir.fakedistrib.dao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BanqueDaoTest {

	@RequestMapping("/BanqueDaoTest")
	public String testBanqueDAO(@RequestParam(value = "ibanstart", defaultValue = "4269") String ibanStart,
			@RequestParam(value = "url", defaultValue = "www.google.fr") String url) {
		return null;
	}

}