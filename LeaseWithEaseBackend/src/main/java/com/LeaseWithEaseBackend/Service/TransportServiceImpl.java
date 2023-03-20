package com.LeaseWithEaseBackend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LeaseWithEaseBackend.Model.Transporter;
import com.LeaseWithEaseBackend.Repository.TransportRepository;

@Service
public class TransportServiceImpl implements TransportService {
	@Autowired
	TransportRepository tRepository;

	@Override
	public List<Transporter> getAllTransporter() {
		return tRepository.findAll();
	}

	@Override
	public Transporter getTransporterById(int tr_id) {
		Optional <Transporter> op=tRepository.findById(tr_id);
		return op.get();
	}

	@Override
	public void addNewT(Transporter t) {
		tRepository.save(t)	;	
	}

	@Override
	public void deleteT(int tr_id) {
		tRepository.deleteById(tr_id);		
	}

	@Override
	public void updateT(Transporter existingT) {
		tRepository.save(existingT);		
	}

	@Override
	public String changePassword(String email_id, String oldpassword, String newpassword) {
		System.out.println(email_id);
		Transporter foundT=new Transporter();
		List<Transporter> tlist=tRepository.findAll();
		for(Transporter t : tlist) {
			if(t.getEmail_id()==email_id) {
				foundT=t;
			}
			else return "Account with this email id is not present!!";
		}
		if(foundT.getPassword().equals(oldpassword)) {
			foundT.setPassword(newpassword);
			tRepository.save(foundT);
			return "Password changed Successfully!!";
		}
		return "Old Password does not match!!";
	}

	@Override
	public boolean authenticateTransporter(String email_id, String password) {
		Transporter t=getByEmailId(email_id);
         if(t.getPassword().equals(password))
          return true;
		return false;
	}

	private Transporter getByEmailId(String email_id) {
		List<Transporter> tList=tRepository.findAll();
         for(Transporter t : tList) {
        	 if(t.getEmail_id().equals(email_id))
        		 return t;
         }
		return null;
	}

}




