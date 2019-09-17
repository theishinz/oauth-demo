package nl.hinz.oauthdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class OauthDemoClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthDemoClientApplication.class, args);
	}
}
