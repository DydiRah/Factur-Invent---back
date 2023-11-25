package facture.Service;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service 
public class EmailService {

    public void sendEmail(String subjet, String message, String to, MultipartFile multi){
        String from = "nohan.razafinjato.pro@gmail.com";
        String host = "smtp.gmail.com";
        
        Properties properties = System.getProperties();
        System.out.println("PROPRETIES : " + properties);

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
           @Override
           protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
                return new javax.mail.PasswordAuthentication("nohan.razafinjato.pro@gmail.com", "alavmodebaapslzw");
            } 
        });

        session.setDebug(true);
        MimeMessage m = new MimeMessage(session);
       
        try {
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            m.setSubject(subjet);
            m.setText(message);
            m.setContent(multi.getBytes(), multi.getContentType());
            m.setFileName(multi.getOriginalFilename());
            Transport.send(m);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
