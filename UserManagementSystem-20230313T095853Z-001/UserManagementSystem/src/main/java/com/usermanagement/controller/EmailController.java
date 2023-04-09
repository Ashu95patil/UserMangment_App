package com.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.usermanagement.Email.Email;
import com.usermanagement.Email.GEmailSender;


@RestController
public class EmailController {

	
	@Autowired
	private GEmailSender emailSender;
	
	
	
	@PostMapping("/sendmail")
	public String sendMail(@RequestBody Email email)
	
	{
		boolean send = emailSender.sendEmail(email.getTo(), email.getFrom(), email.getSubject(), email.getContent());
		
		
		if(send)
		{
			
			return "Email has been sent successfully....";
		}
		else
		{
			return "Sorry Email Not sent ....";
		}
		
		
		
		
	}
	
	
}
