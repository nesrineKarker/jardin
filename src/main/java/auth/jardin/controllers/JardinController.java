package auth.jardin.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import auth.jardin.entities.Demande;
import auth.jardin.entities.Jardin;
import auth.jardin.entities.ReponseEntity;
import auth.jardin.entities.Role;
import auth.jardin.services.FileService;
import auth.jardin.services.IServiceJardin;
import auth.jardin.services.ServiceDemande;

@CrossOrigin(origins = "*")
@RestController
public class JardinController {
	
	@Autowired
    private  IServiceJardin serviceJardin;  
	
	@Autowired
	private FileService fileService;
	
	/*@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository; */
	
	@Autowired
	private ServiceDemande demandeService; 
	
		
	 //----Register Jardin avec confirmation par E-mail----
	
	@PostMapping(value = "/registerJardin")
    public String register(@Valid @RequestBody Jardin jardin) {
		 
	        jardin.setEnabled(false);
	     
	        Role role= new Role(1,"ADMINJardin");
			
		    if (jardin.getRole()==null) {
		    	jardin.setRole(role);
		    }
		   
           serviceJardin.registerJardin(jardin);
         
           /*ConfirmationToken token= confirmationTokenRepository.findByJardin(jardin);
	    	if(token !=null) {
	    		return new ResponseEntity<String>(" This email already exist \n "
	    				+ "Please check your mail to confirm your account", HttpStatus.EXPECTATION_FAILED);
	    	}
	    	
	    	ConfirmationToken confirmationToken=new ConfirmationToken(jardin, "confirmation-account");
	    	confirmationTokenRepository.save(confirmationToken);
	    	mailService.sendConfirmationEmail(jardin, confirmationToken);*/
	    	
	    	
	    	Demande demande = new Demande(jardin);
	    	demandeService.registerDemande(demande);
	    	// créer un objet reponseEntity pour le retour
	    	ReponseEntity r = new ReponseEntity("Congratulations");
	    	return r.getMessage();
	    	// return  new ResponseEntity<String>("Congratulations!",HttpStatus.ACCEPTED);
	    	
	    	
	        /*return  new ResponseEntity<String>("Congratulations! Your account has been created"
	        		+ "Please check your email to continue the registration ", HttpStatus.ACCEPTED);*/
    }
	
	/* @GetMapping(value = "/confirm-account")
    public String confirmUserAccount(@RequestParam("token")String confirmationToken)
    {

		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
		//System.out.println(token);
	
        if(token != null && token.getType().equals("confirmation-account"))
        {
        	
            Jardin jardin = serviceJardin.findByEmail(token.getJardin().getEmail());
            ReponseEntity r1 = new ReponseEntity("This account is already enabled");
            if (jardin.isEnabled()) return r1.getMessage();
            
            else{
            	jardin.setEnabled(true);
            	serviceJardin.registerJardin(jardin);
            	ReponseEntity r2 = new ReponseEntity("Account is now enabled");
            	return r2.getMessage();
            	}   
        }
        else
        {   
        	ReponseEntity r = new ReponseEntity("The link is invalid or broken!");
        	return  r.getMessage();
        }
     }*/
	
	@PostMapping("/upload-image")
	public String uploadImage(MultipartFile file) {
		return fileService.uploadFile(file);
		
	}
	
	@PreAuthorize("hasRole('ADMINJardin')")
	@GetMapping("/jardins")
    public List<Jardin> getAllJardin(){
    	return serviceJardin.getAllJardin();
    }
	
	@PostMapping("/delete-jardin/{id}")
	public void deleteJardin(@PathVariable int id) {
		serviceJardin.deleteJardin(id);
	}
	
	@PostMapping("/update-jardin")
	public void updateJardin(@RequestBody Jardin jardin) {
		serviceJardin.updateJardin(jardin);
	}
	
	
}
