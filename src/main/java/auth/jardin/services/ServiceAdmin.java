package auth.jardin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auth.jardin.entities.Admin;
import auth.jardin.repositories.AdminRepository;

@Service
public class ServiceAdmin implements IServiceAdmin {
	
	@Autowired
	AdminRepository adminRepository;

	@Override
	public void registerAdmin(Admin admin) {
		adminRepository.save(admin);
	}
}
