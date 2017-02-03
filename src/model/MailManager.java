package model;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import exception.MailSenderException;
import exception.ServiceLocatorException;

public class MailManager {
	
	public void SendMail(String email,String message){
		try {
			MailSender sender = MailSender.getMailSender();
			StringBuffer buffer = new StringBuffer(message);
			sender.sendMessage("yimuxia@gmail.com", email, "Movie System", buffer);
		} catch (ServiceLocatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MailSenderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
