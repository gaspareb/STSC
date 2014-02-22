package superior.technology;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

import superior.technology.Config;

public class MailSender implements Config{
	
	private Logger log = null;
	static boolean messageSent = false;
	
	public MailSender(Logger logger) {
		log = logger;
	}
	
	public ByteArrayOutputStream imageConverter(String image) {	
		InputStream is = null; 
		BufferedImage img = null;
		ByteArrayOutputStream bao = null;
		try {
			is = this.getClass().getResourceAsStream(image); 
			img = ImageIO.read(is);
			bao = new ByteArrayOutputStream();
		} catch (IOException e) {
			log.error(DASH + e + DASH);
		}
		
       	return bao;
	}
	
//	public boolean mailAdminUpdate(Users user){
//		Properties props = new Properties(); 
//	    Multipart multipart = new MimeMultipart("related");
//		props.put("mail.smtp.host", ENTRYGUARDHOST);
//		try {  
//			String[] to = {user.getEmail()};
//			Session s = Session.getInstance(props, null); 
//			MimeMessage message = new MimeMessage(s);
//			InternetAddress fromIA = new InternetAddress(WEBMASTERMAILBOX);						
//			message.setFrom(fromIA);						
//			InternetAddress[] addressTo = new InternetAddress[to.length];
//			addressTo[0] = new javax.mail.internet.InternetAddress(to[0]);
////			addressTo[1] = new javax.mail.internet.InternetAddress(to[1]);
//			message.setRecipients(Message.RecipientType.TO, addressTo);
//			
//			message.setSubject(SPONSORUPSUBJECT);
//			
////			BodyPart logoPart = new MimeBodyPart();
////			DataSource source = new FileDataSource(new File(LOGOLOCATION));
////			logoPart.setDataHandler(new DataHandler(source));
////			logoPart.setFileName("test");
////			logoPart.setDisposition(MimeBodyPart.INLINE);
////			multipart.addBodyPart(logoPart);
//			
//			BodyPart htmlPart = new MimeBodyPart();
//			htmlPart.setContent("<html><body><p>Welcome to Entry Guard&#153, your account " + user.getCompanyEmail() + " was recently updated. If you have any questions please contact us at " + SUPPORTMAILBOX + ".", "text/html");			
//			multipart.addBodyPart(htmlPart);			
//			
//		    message.setContent(multipart);		    
//
//			Transport.send(message);								
//		    messageSent = true;
//		}
//		catch (MessagingException mex) {
//			log.error(DASH + mex + DASH);
//		}
//		return messageSent;
//	}
	
//	public boolean mailUserLookup(Users user){
//		Properties props = new Properties(); 
//	    Multipart multipart = new MimeMultipart("related");
//		props.put("mail.smtp.host", ENTRYGUARDHOST);
//		try {   
//			String[] to = {WEBMASTERMAILBOX};
//			Session s = Session.getInstance(props, null); 
//			MimeMessage message = new MimeMessage(s);
//			InternetAddress fromIA = new InternetAddress(WEBMASTERMAILBOX);						
//			message.setFrom(fromIA);						
//			InternetAddress[] addressTo = new InternetAddress[to.length];
//			addressTo[0] = new javax.mail.internet.InternetAddress(to[0]);
////			addressTo[1] = new javax.mail.internet.InternetAddress(to[1]);
//			message.setRecipients(Message.RecipientType.TO, addressTo);
//			
//			message.setSubject(USERLOOKEDUPSUBJECT);
//			
////			BodyPart logoPart = new MimeBodyPart();
////			DataSource source = new FileDataSource(new File(LOGOLOCATION));
////			logoPart.setDataHandler(new DataHandler(source));
////			logoPart.setFileName("test");
////			logoPart.setDisposition(MimeBodyPart.INLINE);
////			multipart.addBodyPart(logoPart);
//			
//			BodyPart htmlPart = new MimeBodyPart();
//			htmlPart.setContent("<html><body><p>Welcome to Entry Guard&#153, user " + user.getFirstName() + " " + user.getLastName() + " was just looked up. If you have any questions please contact us at " + SUPPORTMAILBOX + ".", "text/html");			
//			multipart.addBodyPart(htmlPart);			
//			
//		    message.setContent(multipart);		    
//
//			Transport.send(message);								
//		    messageSent = true;
//		}
//		catch (MessagingException mex) {
//			log.error(DASH + mex + DASH);
//		}
//		return messageSent;
//	}
//	
//	public boolean mailAddUser(Users user){
//		Properties props = new Properties(); 
//	    Multipart multipart = new MimeMultipart("related");
//		props.put("mail.smtp.host", ENTRYGUARDHOST);
//		try {   
//			String[] to = {user.getEmail()};
//			log.info("mailAddUser:" + user.getEmail());
//			Session s = Session.getInstance(props, null); 
//			MimeMessage message = new MimeMessage(s);
//			InternetAddress fromIA = new InternetAddress(WEBMASTERMAILBOX);						
//			message.setFrom(fromIA);						
//			InternetAddress[] addressTo = new InternetAddress[to.length];
//			addressTo[0] = new javax.mail.internet.InternetAddress(to[0]);
////			addressTo[1] = new javax.mail.internet.InternetAddress(to[1]);
//			message.setRecipients(Message.RecipientType.TO, addressTo);
//			
//			message.setSubject(ADDUSERSUBJECT);
//			
//			BodyPart logoPart = new MimeBodyPart();
//			DataSource source = new FileDataSource(new File(LOGOLOCATION));
//			logoPart.setDataHandler(new DataHandler(source));
//			logoPart.setFileName("test");
//			logoPart.setDisposition(MimeBodyPart.INLINE);
//			multipart.addBodyPart(logoPart);
//			
//			BodyPart htmlPart = new MimeBodyPart();
//			htmlPart.setContent("<html><body><p>Welcome to Entry Guard&#153, you have successfully added user " + user.getFirstName() + " " + user.getLastName() + ". If you have any questions please contact us at " + SUPPORTMAILBOX + ".", "text/html");			
//			multipart.addBodyPart(htmlPart);			
//			
//		    message.setContent(multipart);		    
//
//			Transport.send(message);								
//		    messageSent = true;
//		}
//		catch (MessagingException mex) {
//			log.error(DASH + mex + DASH);
//		}
//		return messageSent;
//	}
	
	public boolean mailSendRegistration(String email){ 
		Properties props = new Properties(); 
		props.put("mail.smtp.host", ENTRYGUARDHOST);
		try {   
			log.info("mailSendRegistration:" + email);
			String[] to = {email};
			log.info("mailSendRegistration:" + email);
			Session s = Session.getInstance(props, null); 
			MimeMessage message = new MimeMessage(s);
			InternetAddress fromIA = new InternetAddress(WEBMASTERMAILBOX);						
			message.setFrom(fromIA);						
			InternetAddress[] addressTo = new InternetAddress[to.length];
			addressTo[0] = new javax.mail.internet.InternetAddress(to[0]);
			message.setRecipients(Message.RecipientType.TO, addressTo);
			
			Multipart multipart = new MimeMultipart("related");
						
//			BodyPart imgPart=new MimeBodyPart();
//			DataSource ds=new FileDataSource(logoLocation);
//		    imgPart.setDataHandler(new DataHandler(ds));
//		    imgPart.setHeader("Content-ID","the-img-1");
//		    multipart.addBodyPart(imgPart);
		    
		    BodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent("<html><body><p>Welcome to Entry Guard&#153, your registration is now complete. Please use your email address and the chosen password to login. If you have any questions please contact us at " + SUPPORTMAILBOX + ".", "text/html");			
			multipart.addBodyPart(htmlPart);
			
		    message.setContent(multipart);		    
			message.setSubject(REGMSGSUBJECT);

			Transport.send(message);								
		    messageSent = true;
		}
		catch (MessagingException mex) {
			log.error(DASH + mex + DASH);
		}
		return messageSent;
	}

	public boolean mailSender(String pin, String email){ 
		Properties props = new Properties(); 
		props.put("mail.smtp.host", ENTRYGUARDHOST);
		try {   
			log.info("mailSender:" + email);
			String[] to = {email};
			log.info("mailSender:" + email);
			Session s = Session.getInstance(props, null); 
			MimeMessage message = new MimeMessage(s);
			InternetAddress fromIA = new InternetAddress(WEBMASTERMAILBOX);						
			message.setFrom(fromIA);						
			InternetAddress[] addressTo = new InternetAddress[to.length];
			addressTo[0] = new javax.mail.internet.InternetAddress(to[0]);
//			addressTo[1] = new javax.mail.internet.InternetAddress(to[1]);
			message.setRecipients(Message.RecipientType.TO, addressTo);
			
			Multipart multipart = new MimeMultipart("related");
						
//			BodyPart imgPart=new MimeBodyPart();
//			DataSource ds=new FileDataSource(logoLocation);
//		    imgPart.setDataHandler(new DataHandler(ds));
//		    imgPart.setHeader("Content-ID","the-img-1");
//		    multipart.addBodyPart(imgPart);
		    
		    BodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent("<html><body><p>Welcome to Entry Guard&#153 " + email + ", your requested PIN number is <br>" + DASH + "COPY BELOW" + DASH
		    + "<br>" + pin + "<br>" + DASH + "COPY ABOVE" + DASH + 
		    "<br>" + 
					"Please copy this number and paste it in the REGISTER under the site access menu option at <a href=www.entry-guard.com/unprotected/>www.entry-guard.com</a>", "text/html");			
			multipart.addBodyPart(htmlPart);
			
		    message.setContent(multipart);		    
			message.setSubject(PINMSGSUBJECT);

			Transport.send(message);								
		    messageSent = true;
		}
		catch (MessagingException mex) {
			log.error(DASH + mex + DASH);
		}
		return messageSent;
	}
	
	
	public boolean mailContactSender(ContactForm contactForm ){
		Properties props = new Properties(); 
		props.put("mail.smtp.host", ENTRYGUARDHOST);
		try {   
			String[] to = {SUPERIORMAILBOX, contactForm.getEmail()};
			Session s = Session.getInstance(props, null); 
			MimeMessage message = new MimeMessage(s);
			InternetAddress fromIA = new InternetAddress(WEBMASTERMAILBOX);						
			message.setFrom(fromIA);						
			InternetAddress[] addressTo = new InternetAddress[to.length];
			//addressTo[0] = new javax.mail.internet.InternetAddress(to[0]);
            for (int i = 0; i < to.length; i++)
            {
                addressTo[i] = new InternetAddress(to[i]);
            }
			message.setRecipients(Message.RecipientType.TO, addressTo);
			
			Multipart multipart = new MimeMultipart("related");
						
//			BodyPart imgPart=new MimeBodyPart();
//			DataSource ds=new FileDataSource(logoLocation);
//		    imgPart.setDataHandler(new DataHandler(ds));
//		    imgPart.setHeader("Content-ID","the-img-1");
//		    multipart.addBodyPart(imgPart);
		    
		    BodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent("<html><body><p>You have a message from " + contactForm.getName() + " at email address " + contactForm.getEmail() + ". This was sent from the Superior website.<br><br>" + contactForm.getMessage() + "<br>", "text/html");			
			multipart.addBodyPart(htmlPart);
			
		    message.setContent(multipart);		    
			message.setSubject(contactForm.getSubject());

			Transport.send(message);								
		    messageSent = true;
		}
		catch (MessagingException mex) {
			log.error(DASH + mex + DASH);
		}
		return messageSent;
	}	
}
