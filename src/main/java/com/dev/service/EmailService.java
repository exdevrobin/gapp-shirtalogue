package com.dev.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	
    String to;
    String subject;
    String text;

    public EmailService(String to, String subject, String text) {
        this.to = to;
        this.subject = subject;
        this.text = text;
    }

    public boolean sendEmail() {
    	try {
			final String username = "emailremoved";
			final String password = "passwordremoved";
	
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
	
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				message.setSubject(subject);
				message.setText(text);
	
				Transport.send(message);
				return true;
    	}
    	catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }
}