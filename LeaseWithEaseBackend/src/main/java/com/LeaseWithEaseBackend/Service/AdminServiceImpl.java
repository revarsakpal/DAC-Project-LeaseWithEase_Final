package com.LeaseWithEaseBackend.Service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LeaseWithEaseBackend.Model.Admin;
import com.LeaseWithEaseBackend.Repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	static Cipher cipher; 
	@Autowired
	AdminRepository adminRepository;
	private static final Random RANDOM = new SecureRandom();
	private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	@Override
	public List<Admin> getAllAdmin() {
		return adminRepository.findAll();
	}

	@Override
	public boolean registerAdmin(Admin admin) {
		adminRepository.save(admin);
		return true;
	}

	@Override
	public Admin getAdminByEmail(String email_id) {
		Optional<Admin> op= adminRepository.findById(email_id);
		if(op.isPresent())
			return op.get();
		else
			return null;

	}

	@Override
	public void update(Admin check) {
		adminRepository.save(check);		
	}
	
	public boolean authenticateAdmin(String email_id,String password) {
		/*KeyGenerator keyGenerator;
		SecretKey secretKey = null;
		try {
			keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128); // block size is 128bits
		    secretKey = keyGenerator.generateKey();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		if((getAdminByEmail(email_id)!=null) && getAdminByEmail(email_id).getPassword().equals(password)) 
			return true;
			return false;
		}
		
		
		public static String encrypt(String plainText, SecretKey secretKey)
				{
			byte[] plainTextByte = plainText.getBytes();
			String encryptedText = "" ;
			try {
				cipher.init(Cipher.ENCRYPT_MODE, secretKey);
				byte[] encryptedByte = cipher.doFinal(plainTextByte);
				Base64.Encoder encoder = Base64.getEncoder();
				 encryptedText = encoder.encodeToString(encryptedByte);
				
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (BadPaddingException b) {
				b.printStackTrace();
			}
			catch (IllegalBlockSizeException s)
			{
				s.printStackTrace();
			}
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

		@Override
		public Admin validateAdmin(Admin admin) {
			Admin a=getAdminByEmail(admin.getEmail_id());
			if(a.getPassword().equals(admin.getPassword()))
				return a;
			
			return null;
		}
		
	}
	

