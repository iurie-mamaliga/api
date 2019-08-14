package org.camunda.bpm.getstarted.loanapproval;

import java.util.logging.Level;
//import java.util.logging.Logger;
import java.util.Properties;
import java.util.logging.Level;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

public class SendDenyEmail implements JavaDelegate {

	private final static Logger LOGGER = LoggerFactory.getLogger(SendApprovalEmail.class);

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("Processing request by '" + execution.getVariable("customerId") + "'...");
		sendMail(execution.getVariable("creditScore"), execution.getVariable("customerEmail"),
				execution.getVariable("firstName"));
	}

	public static void sendMail(Object credScore, Object custEmail, Object name) throws Exception {
		// String recepient = "coding.rescue@gmail.com";
		String score = credScore.toString();
		String recepient = custEmail.toString();
		String fName = name.toString();

		System.out.println(score);
		System.out.println("Preparing to send email");

		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		final String myAccountEmail = "coding.rescue@gmail.com";
		final String password = "password";

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});

		Message message = prepareMessage(session, myAccountEmail, recepient, score, fName);

		Transport.send(message);
		System.out.println("Email sent successfully");

	}

	private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String crScore,
			String name) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Loan application decision for " + name);
			message.setText("Based on your credit score of " + crScore + " your application has been denied!");
			return message;
		} catch (Exception e) {
			// Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

}