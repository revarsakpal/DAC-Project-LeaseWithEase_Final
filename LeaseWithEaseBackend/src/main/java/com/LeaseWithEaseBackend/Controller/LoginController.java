package com.LeaseWithEaseBackend.Controller;


import javax.servlet.http.HttpSession;

	import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LeaseWithEaseBackend.Model.Admin;
import com.LeaseWithEaseBackend.Model.Customer;
import com.LeaseWithEaseBackend.Model.Transporter;
import com.LeaseWithEaseBackend.Model.User;
import com.LeaseWithEaseBackend.Service.AdminService;
import com.LeaseWithEaseBackend.Service.CustomerService;
import com.LeaseWithEaseBackend.Service.TransportService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class LoginController {
	@Autowired
	AdminService adminService;
	@Autowired
	TransportService tService;
	@Autowired
	CustomerService cService;

	@PostMapping("signin")
	public ResponseEntity<Admin> authenticateUser(@RequestBody User user){
		System.out.println(user.getEmail_id());
		System.out.println(user.getPassword());
		System.out.println(user.getRole());
		
		if((user.getRole().equals("Admin")) && (adminService.authenticateAdmin(user.getEmail_id(),user.getPassword()))) {
			//Admin validadmin=new Admin();
			//validadmin.setEmail_id(email_id);
			//validadmin.setPassword(password);
			//session.setAttribute("validA", validadmin);
			Admin validAdmin=new Admin();
			 validAdmin=adminService.getAdminByEmail(user.getEmail_id());
			
			return ResponseEntity.ok(validAdmin);
		}
		/*if((role.equals("Transporter")) && (tService.authenticateTransporter(email_id, password)))
		{      
		Transporter validT=new Transporter();
		validT.setEmail_id(email_id);
		validT.setPassword(password);
	//	session.setAttribute("validT", validT);
		return ResponseEntity.ok("transporterHome");}
		if((role.equals("Customer")) && (cService.authenticateCustomer(email_id, password)))
		{
			Customer validC=new Customer();
			validC.setEmail_id(email_id);
			validC.setPassword(password);
		//	session.setAttribute("validC", validC);
			return ResponseEntity.ok("customerHome");}*/
		return ResponseEntity.ok(null);
	}

	@GetMapping("signup")
	public ResponseEntity<String> signUp(@RequestParam String role){
		System.out.println(role);
		if(role.equals("Admin"))
			return ResponseEntity.ok("adminsignup");

		if(role.equals("Customer"))
			return ResponseEntity.ok("customersignup");
		return null;
	}

 @GetMapping("signout")
 public ResponseEntity<String> logoutUser(HttpSession session){	 
	 session.invalidate();
	 return ResponseEntity.ok("Logout Successfully!!");
 }




}
