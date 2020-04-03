package auth.jardin.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import auth.jardin.entities.Avis;
import auth.jardin.services.ServiceAvis;

@CrossOrigin(origins = "*")
@RestController
public class AvisController {
 
	@Autowired
	private ServiceAvis avisService;
	
	@PostMapping(value = "/addAvis")
	public void addAvis(Avis avis) {
		avisService.registerAvis(avis);
	}
	
	@GetMapping(value = "/deleteAvis/{id}")
	public void deleteAvis(@PathVariable int id) {
		avisService.deleteAvis(id);
	}
	
	@GetMapping(value = "/getAvis/{id}")
	public Optional<Avis> getAvis(@PathVariable() int id) {
		return avisService.findAvisById(id);
	}
	
	@GetMapping(value = "/getAllAvis")
	public List<Avis> getAllAvis(){
		return avisService.getAllAvis(); 
	}
	
	@GetMapping(value = "/getAvisByJardin")
	public List<Avis> getAvisByJardin(int id){
		return avisService.findByJardinId(id);
		
	}
	
	

}
