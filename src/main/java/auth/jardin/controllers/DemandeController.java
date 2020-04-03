package auth.jardin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import auth.jardin.entities.ConfirmationToken;
import auth.jardin.entities.Jardin;
import auth.jardin.repositories.ConfirmationTokenRepository;
import auth.jardin.services.MailService;
import auth.jardin.services.ServiceDemande;
import auth.jardin.services.ServiceJardinIMPL;

@CrossOrigin(origins = "*")
@RestController
public class DemandeController {
	
	@Autowired
	private ServiceDemande serviceDemande;
	@Autowired
	private ServiceJardinIMPL serviceJardin;
	@Autowired
	 private MailService mailService;
	
	@Autowired
	private ConfirmationTokenRepository  confirmationTokenRepository;
	
	@PostMapping(value="/refuseDemande/{id}")
	private void refuseeDemande(@PathVariable int id) {
		serviceDemande.deleteDemande(id);
		serviceJardin.deleteJardin(serviceDemande.findDemandeById(id).get().getJardin().getId());
	}
	@PostMapping(value="/deleteDemande/{id}")
	private void deleteDemande(@PathVariable int id) {
		//Demande demande = serviceDemande.findDemandeById(id).get();
		//demande.setJardin(null);
		//serviceDemande.registerDemande(demande);
		serviceDemande.deleteDemande(id);
	}
	
	
	
	@PostMapping(value="/confirmDemande/{id}")
	private ResponseEntity<String> confirmDemande(@PathVariable int id) {
		
        Jardin jardin = serviceDemande.findDemandeById(id).get().getJardin();
        ConfirmationToken token= confirmationTokenRepository.findByJardin(jardin);
	    	if(token !=null) {
	    		return new ResponseEntity<String>(" This email already exist \n "
	    				+ "Please check your mail to confirm your account", HttpStatus.EXPECTATION_FAILED);
	    	}
	    	
	    	ConfirmationToken confirmationToken=new ConfirmationToken(jardin, "confirmation-account");
	    	confirmationTokenRepository.save(confirmationToken);
	    	mailService.sendConfirmationEmail(jardin, confirmationToken);
	    	jardin.setEnabled(true);
	    	serviceDemande.deleteDemande(id);
	    	
	        return  new ResponseEntity<String>("Congratulations! Your account has been created"
	        		+ "Please check your email to continue the registration ", HttpStatus.ACCEPTED);
	        
	}
  
	
}
