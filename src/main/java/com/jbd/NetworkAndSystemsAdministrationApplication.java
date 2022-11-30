package com.jbd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NetworkAndSystemsAdministrationApplication {

	@GetMapping("/home")
	public String getMessage() {

		return "Welcome AWS Code Pipeline";
	}

	public static void main(String[] args) {
		SpringApplication.run(NetworkAndSystemsAdministrationApplication.class, args);

	}

}
