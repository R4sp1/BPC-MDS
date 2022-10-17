package mds.MDScv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class MdsCv2Application {

	public static void main(String[] args) {
		SpringApplication.run(MdsCv2Application.class, args);
	}


	@GetMapping
	@ResponseBody
	public String hello(){
		return "Hello world";
	}

}
