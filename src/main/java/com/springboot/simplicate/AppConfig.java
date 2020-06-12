package com.springboot.simplicate;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties(prefix = "simplicate")
@EnableScheduling
public class AppConfig {

	@Bean("clientRest")
	public RestTemplate registRestTemplate() {
		return new RestTemplate();
	}

	private String authenticationsecret;
	private String authenticationkey;
	private String apiUrl;
	private String emailTo;

	public String getAuthenticationsecret() {
		return authenticationsecret;
	}

	public void setAuthenticationsecret(String authenticationsecret) {
		this.authenticationsecret = authenticationsecret;
	}

	public String getAuthenticationkey() {
		return authenticationkey;
	}

	public void setAuthenticationkey(String authenticationkey) {
		this.authenticationkey = authenticationkey;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
}
