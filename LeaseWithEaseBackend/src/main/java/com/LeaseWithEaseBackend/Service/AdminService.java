package com.LeaseWithEaseBackend.Service;

import java.util.List;

import com.LeaseWithEaseBackend.Model.Admin;

public interface AdminService {

	List<Admin> getAllAdmin();

	boolean registerAdmin(Admin admin);

	Admin getAdminByEmail(String email_id);

	void update(Admin check);
    boolean authenticateAdmin(String email_id,String password);

	Admin validateAdmin(Admin admin);

}
