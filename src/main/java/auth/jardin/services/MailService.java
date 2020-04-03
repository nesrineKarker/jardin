package auth.jardin.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import auth.jardin.entities.ConfirmationToken;
import auth.jardin.entities.Jardin;

@Transactional
@Service("mailService")
public class MailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	//---Sending a confirmation Email---
	
	public void sendConfirmationEmail(Jardin jardin, ConfirmationToken confirmationToken) throws MailException {
		
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(jardin.getEmail());
        mailMessage.setSubject("Complete Registration!");
       // mailMessage.setText("To confirm your account, please click here : "
      //  +"http://localhost:9000/confirm-account?token="+confirmationToken.getConfirmationToken());
        
        mailMessage.setText("To confirm your account, please click here : "
          +"http://localhost:4200/login-jardin");
        javaMailSender.send(mailMessage);		
	}



}