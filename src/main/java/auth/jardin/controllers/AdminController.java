package auth.jardin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import auth.jardin.entities.Admin;
import auth.jardin.services.ServiceAdmin;

@CrossOrigin(origins = "*")
@RestController
public class AdminController {
	
	@Autowired
	private ServiceAdmin adminService;
	
	@PostMapping(value = "/addAdmin")
	public void addAdmin(@RequestBody Admin admin) {
		adminService.registerAdmin(admin);
	}

}
