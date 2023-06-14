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

    public String sendEmail(String email){
       try {
            Random random = new Random();
            String token = "1500"; //TODO change to random number
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom("vitinhopaivinha@gmail.com"); //TODO change to other email
            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject("PaperTree - confirmação de email");
            simpleMailMessage.setText("Seu token de validação é: "+ token);
            javaMailSender.send(simpleMailMessage);
            return token;
        }catch (Exception e){
        	return null;
        }
    }
}
