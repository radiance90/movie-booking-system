package model;

import java.util.Properties;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import exception.*;

 
public class MailSender{
 
	static Logger logger = Logger.getLogger(MailSender.class.getName());
	static MailSender sender;
	
	private static Session session;
	
	private InitialContext ctx;
	
	/**
	 * This contructor is invoked according to singleton pattern. It looks up the mail session from 
	 * the context, initialises it and then  
	 * @throws MailSenderException
	 * @throws ServiceLocatorException
	 */
	 private MailSender() throws MailSenderException, ServiceLocatorException{ 
		try{
			ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:comp/env");
			session = (Session) envContext.lookup("mail/Session");
			logger.info("Mailer Session obtained"+session.toString());
			Properties mailProps = session.getProperties();
			String username = (String)mailProps.get("mail.smtp.user");
			logger.info(username);
			String password = (String)mailProps.get("password");
			logger.info(password);
		}catch(NamingException e){
			logger.severe("Cannot find context, throwing exception"+e.getMessage());
			e.printStackTrace();
			throw new ServiceLocatorException();
		}
	}

	
	/**
	 * This function stores a username/password combination into the mail session. The authentication is 
	 * only performed when a mail is sent.
	 */
	public void setAuthData(final Properties mailProperties, final String username, final String password){
		session = Session.getInstance(mailProperties,
				  new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username,password);
					}
				  });
	}
	
	/**
	 * This function sends a mail from fromAddress to toAddress. The actual authentication
	 * is performed here, so there could be an authentication error. 
	 * 
	 * In contrast, setAuthData always returns true as no authentication is performed 
	 * in that function
	 * 
	 * This is a blocking call, so may be better executed in a separate thread.
	 * 
	 * @param fromAddress
	 * @param toAddress
	 * @param mailSubject
	 * @param text
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public void sendMessage(String fromAddress, String toAddress, String mailSubject, StringBuffer text) throws AddressException, MessagingException{
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(fromAddress));
		message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(toAddress));
		message.setSubject(mailSubject);
		message.setText(text.toString());

		Transport.send(message);

		logger.info("Sent message "+toAddress+" with subject "+mailSubject);
	}
	
	public static MailSender getMailSender() throws ServiceLocatorException, MailSenderException{
		if(sender==null)
			sender = new MailSender();	
		return sender;
	}
	
}