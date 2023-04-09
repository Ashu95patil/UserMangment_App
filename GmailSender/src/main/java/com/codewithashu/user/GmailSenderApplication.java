package com.codewithashu.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootApplication
public class GmailSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmailSenderApplication.class, args);
	}
	
	
	@Bean
	public JavaMailSender javaMailSender()
	{
		return new JavaMailSenderImpl();
	}

}
