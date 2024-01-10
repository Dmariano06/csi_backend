package csi.contact.form.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@org.springframework.stereotype.Service
public class Service {


        @Autowired
        private JavaMailSender javaMailSender;

        public void sendEmail(String to, String subject, String body, String cc) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            message.setCc(cc);

            javaMailSender.send(message);
        }
    }

