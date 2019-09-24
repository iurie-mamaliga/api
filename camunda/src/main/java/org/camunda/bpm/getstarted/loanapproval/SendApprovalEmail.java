package org.camunda.bpm.getstarted.loanapproval;

import java.util.Properties;

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

public class SendApprovalEmail implements JavaDelegate {

	private final static Logger LOGGER = LoggerFactory.getLogger(SendApprovalEmail.class);

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("Processing request by '" + execution.getVariable("userId") + "'...");
		sendMail(execution.getVariable("creditScore"), execution.getVariable("email"),
				execution.getVariable("firstName"), execution.getVariable("loanApproved"),
				execution.getVariable("loanAmount"));
	}

	public static void sendMail(Object credScore, Object custEmail, Object name, Object loanApproved, Object loanAmount) throws Exception {
		String score = credScore.toString();
		String recepient = custEmail.toString();
		String fName = name.toString();
		boolean loanIsApproved = (boolean) loanApproved;
		System.out.println("loan approval status " + loanIsApproved);
		System.out.println(score);
		System.out.println("Preparing to send email");

		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		final String myAccountEmail = "loan.approval.camunda@gmail.com";
		final String password = "CamundaCamunda123";

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);
			}
		});

		Message message = prepareMessage(session, myAccountEmail, recepient, score, fName, loanIsApproved, loanAmount);

		Transport.send(message);
		System.out.println("Email sent successfully");
		System.out.println("loan amount " + loanAmount.toString());

	}

	private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String crScore,
			String name, boolean loanIsApproved, Object loanAmount) {
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Loan application decision for " + name);
			
			if(loanIsApproved && Integer.parseInt(crScore) > 599) {
				message.setText("Based on your credit score of " + crScore + " your loan application has been approved " +
						"in the full amount requested of " + loanAmount + " dollars.");
			}else if(loanIsApproved && Integer.parseInt(crScore) < 600) {
				message.setText("Based on your low credit score of " + crScore + " your application has been approved " +
						"in the amount of " + loanAmount + " dollars.");
			}else if(!loanIsApproved && Integer.parseInt(crScore) < 600) {
				message.setText("Based on your low credit score of " + crScore + " your application has been denied.");
			}
			
			return message;
		} catch (Exception e) {
			// Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, e);
		}
		return null;
	}

}