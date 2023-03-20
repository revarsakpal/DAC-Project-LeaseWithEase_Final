	package com.LeaseWithEaseBackend.Service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.LeaseWithEaseBackend.Model.Customer;
import com.LeaseWithEaseBackend.Model.Transporter;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender mailSender;

	@Async
	public void sendEmail(String email,String role,String fname) {

		String str="";
		if (role.equals("Admin")){
			str="<h2 style=\"color:blue;\">Hello Admin,</h2>"+
					"<b><p>You successfully registered on LeaseWithEase</p>"
					+ "<p>You are authorises to access all admin's services!!</p>"
					+ "<p>Thank You!!</p></b>"+

				"<p><b>Best,</b></p>"+

				"<p><i>LeaseWithEase Team<i></p>";

		}
		sendMail(str, email);
		
			/* twillo phone number is not available with us
				Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		        Message message = Message.creator(
		                new com.twilio.type.PhoneNumber(user.getPhone()),
		                new com.twilio.type.PhoneNumber("918806904717"),
		                "Teaching is The new learning")
		           .create();*/
			//   return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);

		
	}

	public void sendEmailToTransporter(Transporter t) {
		String str="<h2 style=\"color:blue;\">Hello "+t.getFname()+",</h2>"+
				"<b><p>You are successfully registered on LeaseWithEase as our valuable delivery partner.</p>"
				+ "<p>You are authorises to access all services on transporter portal!!</p>"
				+"<p>Details for agrrement and Login as mentioned Below :</p>"
				+"<p>Agreement Date : "+t.getSign_up_date()+"</p>"
				+"<p>Delivery Rate : "+t.getRate_of_del()+"</p>"
				+"<p>User Id : "+t.getEmail_id()+"</p>"
				+"<p>Password: "+t.getPassword()+"</p>"
				+ "<p>Thank You!!</p></b>"+

			"<p><b>Best,</b></p>"+

			"<p><i>LeaseWithEase Team<i></p>";		

		sendMail(str, t.getEmail_id());

	}

	public void sendEmailToCustomers(Customer cust) {
		String str ="<h2 style=\"color:blue;\">Hello "+ cust.getFname()+" ,</h2>"+
		"<b><p>We’re super excited to see you join the LeaseWithEase Rental Platform community.</p>"+

	"<p>We hope you will be happy with the products offered by the online store and that you will shop with us again and again.</p>"+

	"<p>Our goal is to offer the widest range of products offered by the online store at the highest quality.</p>"+
	"<p>If you think we should add any items to our store, don’t hesitate to contact us and share your feedback.</p>"+

	"<p>Until then, enjoy your shopping!</p></b>"+

	"<p><b>Best,</b></p>"+

	"<p><i>LeaseWithEase Team<i></p>";
		sendMail(str, cust.getEmail_id());
		
	}
public void sendMail(String str,String mail_id) {
	MimeMessage mimeMessage
	= mailSender.createMimeMessage();
	MimeMessageHelper mimeMessageHelper;
	try {

		mimeMessageHelper
		= new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setFrom("donotreply@gmail.com");
		mimeMessageHelper.setTo(mail_id);
		mimeMessageHelper.setSubject("Registration Confirmation!!");
		mimeMessage.setContent(str, "text/html; charset=utf-8");	
		mailSender.send(mimeMessage);
	}
	catch(Exception e) {
	}

}
}