/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eMail;

import java.io.File;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Lloyd
 */
public class sendEMail {
    public void send(String fileName,String[] mail,String from,String subject) throws AddressException, MessagingException{
        String smtp="mail.smtp.host";
        String host="localhost"; //mail.jlrooms.com";
        
        File f = new File(fileName);
        InternetAddress x[] = new InternetAddress[mail.length];
            for (int i = 0; i < mail.length; i++){
            
                x[i] = new InternetAddress(mail[i]);
            }
            Properties props = new Properties();
            props.put(smtp,host);
            Session session = Session.getDefaultInstance(props, null);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            InternetAddress[] address = x;
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText("See Attachment regarding: "+fileName);
            //MimeBodyPart mbp1 = new MimeBodyPart();
                //mbp1.setText("<h1> See Attachment<h1/> ","text/html");

                //Multipart multipart = new MimeMultipart();

                MimeBodyPart messageBodyPart = new MimeBodyPart();

                DataSource source = new FileDataSource(f);
                messageBodyPart.setDataHandler( new DataHandler(source));
                messageBodyPart.setFileName(fileName);
                //multipart.addBodyPart(messageBodyPart);
               // message.setContent(multipart);


                Multipart mp = new MimeMultipart();
                //mp.addBodyPart(mbp1);
                mp.addBodyPart(messageBodyPart);

                // add the Multipart to the message
                message.setContent(mp);

                // send the message
                Transport.send(message);
            
    }
    
}
