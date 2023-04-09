package com.codewithashu.user.config;

import java.io.File;
import java.util.Properties;

import org.springframework.stereotype.Component;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

@Component
public class GmailSender {

	public boolean sendEmail(String to, String from, String subject, String text, String content) {

		boolean flag = false;

		// smtp properties

		Properties properties = new Properties();

		properties.put("mail.smtp.auth", true);

		properties.put("mail.smtp.starttls.enable", true);

		properties.put("mail.smtp.port", "587");

		properties.put("mail.smtp.host", "smtp.gmail.com");

		String username = "ashu24patil95";

		String password = "sflhizjgickumbop";

		// session

		Session instance = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}

		});

		/*
		 * try {
		 * 
		 * MimeMessage mimeMessage = new MimeMessage(instance);
		 * 
		 * mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		 * 
		 * mimeMessage.setFrom(new InternetAddress(from));
		 * 
		 * mimeMessage.setSubject(subject);
		 * 
		 * MimeBodyPart part1 = new MimeBodyPart();
		 * 
		 * part1.setText(text);
		 * 
		 * MimeBodyPart part2 = new MimeBodyPart(); part2.attachFile(content);
		 * 
		 * MimeMultipart mimeMultipart = new MimeMultipart();
		 * 
		 * mimeMultipart.addBodyPart(part1); mimeMultipart.addBodyPart(part2);
		 * 
		 * mimeMessage.setContent(mimeMultipart);
		 * 
		 * Transport.send(mimeMessage);
		 * 
		 * flag=true;
		 * 
		 * } catch (Exception e) {
		 * 
		 * e.printStackTrace();
		 * 
		 * }
		 * 
		 * return flag;
		 * 
		 * 
		 * }
		 */

		try {

			Message msg = new MimeMessage(instance);
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setFrom(new InternetAddress(from));
			msg.setSubject(subject);
			msg.setText(text);
//		File sending code
			MimeBodyPart messgeBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messgeBodyPart);

			DataSource source = new FileDataSource(content);
			messgeBodyPart.setDataHandler(new DataHandler(source));
			multipart.addBodyPart(messgeBodyPart);
			messgeBodyPart.setContent(multipart);
			Transport.send(msg);
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
