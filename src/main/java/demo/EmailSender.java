package demo;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class EmailSender {
	public static void main(String[] args) {
		final String senderEmail = "testautom@gmail.com";
		final String appPass = "yourapp paas key";
		final String recipentEmail = "vishwakarmaarvind920@gmail.com";

		// SMTP properties
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");

		// Creating the session with authenticaiton
		Session session = Session.getInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, appPass);
			}
		});
		session.setDebug(true);

		try {	
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(senderEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipentEmail));
			message.setSubject("QA Automatio REprot on Email");
//			message.setText("Hello \n This is the test email Java \n Regards,\n QA Team");

			//Email Body
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setText("Hello \\n This is the test email Java \\n Regards,\\n QA Team");
			
			//Attachmennt Part
			MimeBodyPart attachmentpart  = new MimeBodyPart();
			String filePath = System.getProperty("user.dir")+ "/reports/ExtentReprot.html";
			attachmentpart.attachFile(new File(filePath));
			
			//Combine Body and Attachment part
			MimeMultipart  multipart = new MimeMultipart();
			multipart.addBodyPart(textPart);
			multipart.addBodyPart(attachmentpart);
			
			message.setContent(multipart);
			
			Transport.send(message);
			System.out.println("Email Sent Succesfully");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
}
