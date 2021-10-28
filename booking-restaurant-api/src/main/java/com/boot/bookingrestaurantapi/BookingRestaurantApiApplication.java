package com.boot.bookingrestaurantapi;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;


@SpringBootApplication
public class BookingRestaurantApiApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(BookingRestaurantApiApplication.class, args);
	}
	
	@Bean
	public JavaMailSenderImpl customJavaMailSenderImpl(){

	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	     
	    mailSender.setUsername("christian.gomez.herrera@gmail.com");
	    mailSender.setPassword("laclave");
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	     
	    return mailSender;

	}

}
