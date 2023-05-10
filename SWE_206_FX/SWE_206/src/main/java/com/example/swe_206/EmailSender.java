package com.example.swe_206;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

// Create a new JavaMailSenderImpl instance
//JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//        mailSender.setUsername("your_username@gmail.com");
//        mailSender.setPassword("your_password");
//
//// Create a new SimpleMailMessage instance and set the message details
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo("recipient_email@example.com");
//        message.setSubject("Test Email Subject");
//        message.setText("This is a test email message.");
//
//// Send the email message using the mailSender instance
//        mailSender.send(message);


public class EmailSender {
    private static final String SENDER_EMAIL = "";
    private static final String SENDER_PASSWORD = "";


    public static void sendEmail(String recipientEmail, String userType) throws MessagingException {
            // Create email message
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SENDER_EMAIL, SENDER_PASSWORD);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SENDER_EMAIL));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject("Login Notification");
            message.setText("Dear " + userType + ",\n\nYou have logged in successfully.");

            // Send email message
            Transport.send(message);
        }
//public static void sender2(String recipientEmail, String userType) throws MessagingException{
//    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
//        mailSender.setPort(587);
//        mailSender.setUsername("your_username@gmail.com");
//        mailSender.setPassword("your_password");
//
//// Create a new SimpleMailMessage instance and set the message details
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(recipientEmail);
//        message.setSubject("Test Email Subject");
//        message.setText("This is a test email message.");
//
//// Send the email message using the mailSender instance
//        mailSender.send(message);
//    }
    }
