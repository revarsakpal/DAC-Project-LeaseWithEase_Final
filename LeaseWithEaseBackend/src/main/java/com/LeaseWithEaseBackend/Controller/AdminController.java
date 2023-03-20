package com.LeaseWithEaseBackend.Controller;

import java.nio.file.spi.FileSystemProvider;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LeaseWithEaseBackend.Exception.BadRequestException;
import com.LeaseWithEaseBackend.Model.Admin;
import com.LeaseWithEaseBackend.Service.AdminService;
import com.LeaseWithEaseBackend.Service.EmailService;
import javax.crypto.KeyGenerator;   
import javax.crypto.SecretKey;  


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AdminController {
	static Cipher cipher; 
	@Autowired
	AdminService adminService;
	@Autowired
	EmailService emailService;
	@Autowired
	JavaMailSender javaMailSender;
	//@Autowired
	/*private PasswordEncoder encoder;
	@Bean 
	public PasswordEncoder passwordEncoder() { return
			PasswordEncoderFactories.createDelegatingPasswordEncoder(); }
	 */


	private static final Random RANDOM = new SecureRandom();
	private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	


	@GetMapping("admin")
	public ResponseEntity<List<Admin>> getAllAdmin(){
		List<Admin> adminList=adminService.getAllAdmin();
		return ResponseEntity.ok(adminList);
	}
	@GetMapping("admin/{email_id}")
	public Admin getAdminByEmailId(@PathVariable String email_id){
		Admin admin=adminService.getAdminByEmail(email_id);
		return admin;
	}
	@PostMapping("admin/signin")
	public Admin authenticateAdmin(@RequestBody Admin admin){
		System.out.println(admin.getEmail_id());
		System.out.println(admin.getPassword());
		Admin validAdmin=adminService.validateAdmin(admin);
		if(validAdmin!=null)
		return validAdmin;
		else return null;
	}
	
	@PostMapping("admin/register")
	public ResponseEntity<String> registerAdmin(@RequestParam String email_id,@RequestParam String fname,@RequestParam String lname,@RequestParam String role,@RequestParam String password,@RequestParam String phone_no){
		if (adminService.getAdminByEmail(email_id)!=null) {
			throw new BadRequestException(email_id+ " already registered.");
			//return ResponseEntity.ok("Email ID Already Regiestered ");
		}
		//if(adminService.getAdminByEmail(email_id)==null) {
		role="Admin";
		Date date=new Date();
		//DateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
		//String strDate=dateFormat.format(date);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String strDate=dtf.format(now);
		Admin admin=new Admin();
		admin.setEmail_id(email_id);
		admin.setFname(fname);
		admin.setLname(lname);
		// admin.setPassword(password);
		admin.setPhone_no(phone_no);
		admin.setRole(role);
		admin.setSign_up_date(strDate);
		System.out.println(password);
		System.out.println(password);

		//String encodedPassword = encoder.encode(password);
		//admin.setPassword(encodedPassword);
		// Generate random 36-character string token for confirmation link
		/*KeyGenerator keyGenerator;
		try {
			keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128); // block size is 128bits
			SecretKey secretKey = keyGenerator.generateKey();
			try {
				cipher = Cipher.getInstance("AES");
			} catch (NoSuchPaddingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String plainText = password;
			System.out.println("Plain Text Before Encryptin: " + plainText);

			String encryptedText;
			try {
				encryptedText = encrypt(plainText, secretKey);
				//System.out.println("Encrypted Text After Encryption: " + encryptedText);
				//String decryptedText = decrypt(encryptedText, secretKey);
				//System.out.println("Decrypted Text After Decryption: " + decryptedText);	
				admin.setPassword(encryptedText);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		admin.setToken(UUID.randomUUID().toString());*/
	  admin.setPassword(password);
		if(adminService.registerAdmin(admin)) {
			emailService.sendEmail(email_id, role, fname); 	
		}    
		//}
		return ResponseEntity.ok("Register Successfully!!");
	}
	public static String encrypt(String plainText, SecretKey secretKey)
			throws Exception {
		byte[] plainTextByte = plainText.getBytes();
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedByte = cipher.doFinal(plainTextByte);
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(encryptedByte);
		return encryptedText;
	}

	public static String decrypt(String encryptedText, SecretKey secretKey)
			throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = decoder.decode(encryptedText);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		String decryptedText = new String(decryptedByte);
		return decryptedText;
	}

	@PutMapping("admin/changePassword")
	public String changePassword(@RequestParam String newpassword, 
			@RequestParam String oldpassword,@RequestParam String email_id) {
		Admin check=adminService.getAdminByEmail(email_id);
		System.out.println(email_id);
		if(check!=null) {

			try {
				KeyGenerator keyGenerator;
				keyGenerator = KeyGenerator.getInstance("AES");
				keyGenerator.init(128); // block size is 128bits
				SecretKey secretKey = keyGenerator.generateKey();

				System.out.println(1);
				cipher = Cipher.getInstance("AES");
				cipher.init(Cipher.DECRYPT_MODE, secretKey);
				System.out.println("old password"+encrypt(oldpassword,secretKey));
				System.out.println("old pass db"+check.getPassword());
				/*if((encrypt(oldpassword, secretKey)).equals(check.getPassword())){
					check.setPassword(encrypt(newpassword,secretKey));
					adminService.update(check);
					Admin check1=adminService.getAdminByEmail(email_id);
					//System.out.println("changed password"+decrypt(check1.getPassword(),secretKey));*/
				//} 
			}catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			catch (NoSuchPaddingException e1) {
				e1.printStackTrace();
			}
			catch (Exception e3)
			{
				e3.printStackTrace();
			}
			return "Password changed Successfully!!";

		}

		return "Old Password or email id does not match!! ";
	}
}
