import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class GmailSender {
    public static void main(String[] args){

        String to = {destination email};
        String from = {sender email};
        String password = {16 digit auth key};

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
           return new PasswordAuthentication(from, password);
           }
        });
        session.setDebug(true);

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            message.setSubject({mail subject});

            // For text-only messages
            message.setText({Text body});


            System.out.println("Sending.....");
            Transport.send(message);
            System.out.println("Message sent successfully");
        } catch(MessagingException mex){
            mex.printStackTrace();
        }
    }
}
