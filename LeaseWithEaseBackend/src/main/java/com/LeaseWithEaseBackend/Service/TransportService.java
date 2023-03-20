package com.LeaseWithEaseBackend.Service;

import java.util.List;

import com.LeaseWithEaseBackend.Model.Transporter;

public interface TransportService {

	List<Transporter> getAllTransporter();

	Transporter getTransporterById(int tr_id);

	void addNewT(Transporter t);

	void deleteT(int tr_id);

	void updateT(Transporter existingT);

	String changePassword(String email_id, String oldpassword, String newpassword);

	boolean authenticateTransporter(String email_id, String password);

}
