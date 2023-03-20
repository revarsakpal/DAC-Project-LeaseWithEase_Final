package com.LeaseWithEaseBackend.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.LeaseWithEaseBackend.Model.Address;
import com.LeaseWithEaseBackend.Model.Transporter;
import com.LeaseWithEaseBackend.Service.EmailService;
import com.LeaseWithEaseBackend.Service.TransportService;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TransporterController {
	@Autowired 
	TransportService tservice;
	@Autowired
	EmailService emailService;
	@GetMapping("transporter")
	public ResponseEntity <List<Transporter>> getAllTransporter(){
		List<Transporter> tList=tservice.getAllTransporter();	
		return ResponseEntity.ok(tList);	
	}

	@GetMapping("transporter/{tr_id}")
	public Transporter getTransporterById(@PathVariable int tr_id){
		Transporter t=tservice.getTransporterById(tr_id);
		return t;
	}

	@PostMapping("transporter/addnew")
	public ResponseEntity<String> addNewTransporter(@RequestBody Transporter t){
		/*
		 * @RequestParam String fname,@RequestParam String lname,@RequestParam String
		 * email_id,@RequestParam String phone_no,
		 * 
		 * @RequestParam String signupdate,@RequestParam String
		 * terminateDate,@RequestParam Address addr,@RequestParam Double rate_of_del
		 */
		String password=t.getEmail_id().substring(0,4).concat("@").concat(t.getPhone_no().substring((t.getPhone_no().length()-4)));
		t.setPassword(password);
		
		Date date=new Date();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String strDate=dtf.format(now);
		
		t.setSign_up_date(strDate);
		
		tservice.addNewT(t);
		emailService.sendEmailToTransporter(t);
		return ResponseEntity.ok("New Transporter added successfully!!");
	} 
	
	@DeleteMapping("transporter/closePartnership/{tr_id}")
	public ResponseEntity<String> deleteTransporter(@PathVariable int tr_id){
		tservice.deleteT(tr_id);
		return ResponseEntity.ok("Transporter Partnership has been terminated successfully!!");
	}
	@PutMapping("transporter/update")
	public ResponseEntity<String> updateTDetails(@RequestBody Transporter t){
		Transporter existingT=tservice.getTransporterById(t.getTr_id());
		existingT.setFname(t.getFname());
		existingT.setLname(t.getLname());
		existingT.setPhone_no(t.getPassword());
		tservice.updateT(existingT);
		return ResponseEntity.ok("Details updated successfully!!");
	}
	@PutMapping("transporter/changePassword")
	public ResponseEntity<String> changePassword(@RequestParam String email_id,@RequestParam String newPassword,@RequestParam String oldPassword){
		String str=tservice.changePassword(email_id,oldPassword,newPassword); 
		return ResponseEntity.ok(str);
	}
	
}
