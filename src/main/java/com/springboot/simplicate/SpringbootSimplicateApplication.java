package com.springboot.simplicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = { "com.springboot" })
@EnableConfigurationProperties(AppConfig.class)
public class SpringbootSimplicateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSimplicateApplication.class, args);
	}
}
