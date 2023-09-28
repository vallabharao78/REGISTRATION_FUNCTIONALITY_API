package com.vallabha.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.vallabha.entity.User;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailConfig {

	@Autowired
	private JavaMailSender javaMailSender;
	

	public boolean sendEmail(User user)
    {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom("noreplyvallabha@gmail.com");
            helper.setTo(user.getFirstName());
            helper.setText("Dear "+user.getFirstName()+" "+user.getLastName()+" </br> Your registration almost complete.</br> To unlock your account use below credentials : </br> Email : "+user.getEmail()+" </br> Password : "+user.getPassword()+" </br></br>  Thanks", true);
            helper.setSubject("Unlock Your User Account Here...");
 
            javaMailSender.send(mimeMessage);
            return true;
        } 
        catch (Exception e) {
            return false;
        }
    }
}
