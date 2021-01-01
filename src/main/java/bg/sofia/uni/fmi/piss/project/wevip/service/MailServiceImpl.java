package bg.sofia.uni.fmi.piss.project.wevip.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {
  final String username = "softuerno15@gmail.com";
  final String password = "sEngineers2015";

  Properties props = new Properties();


  public void sendEmail(String email, String mess) {
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.socketFactory.port", "587");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
          }
        });
    Message mimeMessage = new MimeMessage(session);

    try {
      mimeMessage.setFrom(new InternetAddress(username));
      mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
      mimeMessage.setSubject("Registration email");
      mimeMessage.setText(mess);
      Transport.send(mimeMessage);
    } catch (MessagingException e) {
      System.out.println("Problem while sending the email!");
    }
  }
}
