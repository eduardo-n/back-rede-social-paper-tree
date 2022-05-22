package com.projetotcc.papertree.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {
	
	@Autowired
    private JavaMailSender javaMailSender;

    public int sendEmail(String email){
       try {
            Random random = new Random();
            int token = 1500;
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("vitinhopaivinha@gmail.com");
            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject("PaperTree - confirmação de email");
            simpleMailMessage.setText(""+ token);
            javaMailSender.send(simpleMailMessage);
            return token;
        }catch (Exception e){
        	return 0;
        }
    }
}
