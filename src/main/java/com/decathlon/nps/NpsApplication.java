package com.decathlon.nps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages = {"com.decathlon.nps"})
@EnableSwagger2
public class NpsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NpsApplication.class, args);
	}

}
