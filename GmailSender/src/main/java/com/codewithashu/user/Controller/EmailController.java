package com.codewithashu.user.Controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.codewithashu.user.config.GmailSender;
import com.codewithashu.user.entity.Email;

import jakarta.mail.Multipart;

@RestController
public class EmailController {
	
	@Autowired
	private  GmailSender gmailSender;
	

	
	
	@PostMapping("/sendmail")
	public String sendEmail(@RequestBody Email email)
	{
		boolean sendEmail = gmailSender.sendEmail(email.getTo(), email.getFrom(), email.getSubject(),email.getText(), email.getContent());
		
		if(sendEmail)
		{
		return "Email has been sent successfully......!!!!";

			
		}

		else {
			
			return "sorry email not send.....!!!";	
			
		}
		}

	
	/*
	 * @PostMapping("/sendEmail") public ResponseEntity<String>
	 * sendEmailController(@RequestParam String to,
	 * 
	 * @RequestParam String from,
	 * 
	 * @RequestParam String subject,
	 * 
	 * @RequestParam String text,
	 * 
	 * @RequestParam("file") File file) {
	 * 
	 * // boolean emailSent = sendEmail(to, from, subject, text, new
	 * File(file.getOriginalFilename())); boolean sendEmail =
	 * gmailSender.sendEmail(to, from, subject, text, file);
	 * 
	 * if (sendEmail) { return ResponseEntity.ok("Email sent successfully!"); } else
	 * { return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
	 * body("Email sending failed."); } }
	 * 
	 * 
	 * 
	 * private boolean sendEmail(String to, String from, String subject, String
	 * text, File file) { // TODO Auto-generated method stub return false; }
	 * 
	 */
}
