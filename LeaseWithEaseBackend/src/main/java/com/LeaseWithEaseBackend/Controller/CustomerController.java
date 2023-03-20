package com.LeaseWithEaseBackend.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.LeaseWithEaseBackend.Model.Customer;
import com.LeaseWithEaseBackend.Service.CustomerService;
import com.LeaseWithEaseBackend.Service.EmailService;

@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService cService;
	@Autowired
	EmailService emailService;
	
	
	@GetMapping("customer")
	public ResponseEntity<List<Customer>> getAllCustomrs(){
		List<Customer> cList=cService.getAllCustomer();
		return ResponseEntity.ok(cList);
	}


	@GetMapping("customer/{cust_id}")
	public ResponseEntity<Customer> getCustomersById(@PathVariable int cust_id){
		Customer cust=cService.getCustomerById(cust_id);
		return ResponseEntity.ok(cust);
	}

	@PostMapping("customer/signup")
	public ResponseEntity<String> addNewcustomers(@RequestBody Customer cust){
		/*
		 * @RequestParam String fname,@RequestParam String lname,@RequestParam String
		 * email_id,@RequestParam String phone_no,
		 * 
		 * @RequestParam String signupdate,@RequestParam String
		 * terminateDate,@RequestParam Address addr,@RequestParam Double rate_of_del
		 */
		cust.setRole("Customer");
		cService.addNewT(cust);
		emailService.sendEmailToCustomers(cust);
		return ResponseEntity.ok("New customer added successfully!!");
	} 

	@GetMapping("customer/search/{email_id}")
	public ResponseEntity<Customer> getByEmail(@RequestParam String email_id){
		Customer cust=cService.getByEmail(email_id);
		return ResponseEntity.ok(cust);
	}

	@DeleteMapping("customer/closeAccount/{cust_id}")
	public ResponseEntity<String> deletecustomers(@PathVariable int cust_id){
		cService.deleteCustomer(cust_id);
		return ResponseEntity.ok("Customer account deleted successfully!!");
	}
	@PutMapping("customer/update")
	public ResponseEntity<String> updateCDetails(@RequestBody Customer cust){
		cService.updateCustomer(cust);
		return ResponseEntity.ok("Details updated successfully!!");
	}
	@PutMapping("customer/changePassword")
	public ResponseEntity<String> changePassword(@RequestParam String email_id,@RequestParam String newPassword,@RequestParam String oldPassword){
		String str=cService.changePassword(email_id,oldPassword,newPassword); 
		return ResponseEntity.ok(str);
	}




}
