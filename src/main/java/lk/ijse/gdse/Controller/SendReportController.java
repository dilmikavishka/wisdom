package lk.ijse.gdse.Controller;
import javafx.event.ActionEvent;
import lk.ijse.gdse.smtp.Mail;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;

public class SendReportController  {
//    public void run() {
//        if (msg != null) {
//            try {
//                outMail();
//            } catch (MessagingException e) {
//                throw new RuntimeException(e);
//            }
//        } else {
//            System.out.println("not sent. empty msg!");
//        }
//    }

//    private void outMail() throws MessagingException {
//        String from = "rayancooray123456@gmail.com"; //sender's email address
//        String host = "localhost";
//
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", 587);
//        Session session = Session.getDefaultInstance(properties, new Authenticator() {
//            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("rayancooray123456@gmail.com", "djmdheowxakwcfrz");  // have to change some settings in SMTP
//            }
//        });
//        MimeMessage mimeMessage = new MimeMessage(session);
//        mimeMessage.setFrom(new InternetAddress(from));
//        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//        mimeMessage.setSubject(this.subject);
//
//        if (file != null) {
//            //3) create MimeBodyPart object and set your message text
//            BodyPart messageBodyPart1 = new MimeBodyPart();
//            messageBodyPart1.setText(msg);
//
//            //4) create new MimeBodyPart object and set DataHandler object to this object
//            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
//            DataSource source = new FileDataSource(file);
//            messageBodyPart2.setDataHandler(new DataHandler(source));
//            messageBodyPart2.setFileName("Report.pdf");
//
//            //5) create Multipart object and add MimeBodyPart objects to this object
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messageBodyPart1);
//            multipart.addBodyPart(messageBodyPart2);
//
//            //6) set the multiplart object to the message object
//            mimeMessage.setContent(multipart);
//        } else {
//            mimeMessage.setText(this.msg);
//        }
//        Transport.send(mimeMessage);
//
//        System.out.println("sent");
//
//    }


    public void SendUSerReportViaEmailOnAction(ActionEvent actionEvent) throws MessagingException {
        Mail mail = new Mail();
        mail.setMsg("Welcome -Welcome to the Wisdom Student Management System");
        mail.setTo("raycooray32@gmail.com");
        mail.setSubject("Wisdom Login");

        

        Thread thread = new Thread(mail);
        thread.start();
    }

    public void SendStudentReportViaEmailOnAction(ActionEvent actionEvent) throws MessagingException {
//        String from = "rayancooray123456@gmail.com"; //sender's email address
//        String host = "localhost";
//
//        Properties properties = new Properties();
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//        properties.put("mail.smtp.host", "smtp.gmail.com");
//        properties.put("mail.smtp.port", 587);
//        Session session = Session.getDefaultInstance(properties, new Authenticator() {
//            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("rayancooray123456@gmail.com", "djmdheowxakwcfrz");  // have to change some settings in SMTP
//            }
//        });
//        MimeMessage mimeMessage = new MimeMessage(session);
//        mimeMessage.setFrom(new InternetAddress(from));
//        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//        mimeMessage.setSubject(this.subject);
//
//        if (file != null){
//            //3) create MimeBodyPart object and set your message text
//            BodyPart messageBodyPart1 = new MimeBodyPart();
//            messageBodyPart1.setText(msg);
//
//            //4) create new MimeBodyPart object and set DataHandler object to this object
//            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
//            DataSource source = new FileDataSource(file);
//            messageBodyPart2.setDataHandler(new DataHandler(source));
//            messageBodyPart2.setFileName("Report.pdf");
//
//            //5) create Multipart object and add MimeBodyPart objects to this object
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(messageBodyPart1);
//            multipart.addBodyPart(messageBodyPart2);
//
//            //6) set the multiplart object to the message object
//            mimeMessage.setContent(multipart);
//        }else {
//            mimeMessage.setText(this.msg);
//        }
//        Transport.send(mimeMessage);
//
//        System.out.println("sent");
//    }
       // outMail();
    }
}

