package dta.pizzeria.backend.metier;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import dta.pizzeria.backend.entity.Client;

/***
 * 
 * @author Hantaro
 *
 */

@Service
public class MailService {

	public boolean envoyerMailSMTP(Client client) {
		String server = "smtp.gmail.com";
		boolean result = false;
		String mdp = "pizzeriadta";
		String mailSend = "pizzeria.dta@gmail.com";
		String mailReceiver = client.getMail();
		System.out.println("mailReceiver : "+mailReceiver);
		int hashCode = (client.getLogin()+client.getMail()).hashCode();
		try {
			Properties prop = System.getProperties();
			prop.put("mail.smtp.host", server);
			prop.put("mail.smtp.port", "587");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.starttls.enable", "true");

			Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mailSend, mdp);
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailSend));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailReceiver));
			message.setSubject("Confirmation inscription à Pizzeria Web");
			message.setText("Pour confirmer votre inscription, veuillez cliquer sur le lient suivant.\n"
					+ " http://127.0.0.1:1234/#/validation/?hash="+hashCode+"&id="+client.getId());

			Transport.send(message);
			System.out.println("Done");
			result = true;
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
