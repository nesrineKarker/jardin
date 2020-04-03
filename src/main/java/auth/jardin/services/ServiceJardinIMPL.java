package auth.jardin.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import auth.jardin.entities.Jardin;
import auth.jardin.repositories.JardinRepository;

@Service(value = "jardinService")
public class ServiceJardinIMPL implements IServiceJardin{
	
	List<Jardin> jardins = new ArrayList<>();
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;
	@Autowired
	private JardinRepository jardinRepository;
	
	@Override
	public void registerJardin(Jardin jardin) {
		
		jardin.setPassword(bcryptEncoder.encode(jardin.getPassword()));
        jardinRepository.save(jardin);
	}
	@Override
	public List<Jardin> getAllJardin() {
		jardinRepository.findAll().forEach(jardins::add);;
    	return jardins;
	}
		
	@Override
	public void deleteJardin(int id) {
		
		jardinRepository.deleteById(id);
		
	}
	
	@Override
	public Optional<Jardin> updateJardin(Jardin jardin) {
		return jardinRepository.findById(jardin.getId()).filter(e-> {
            e.setUsername(jardin.getUsername());
            e.setEmail(jardin.getEmail());
            e.setPassword(jardin.getPassword());
            e.setDescription(jardin.getDescription());
            e.setLogo(jardin.getLogo());
            e.setNbEmploy(jardin.getNbEmploy());
            e.setDateCreation(jardin.getDateCreation());
            e.setNumTel(jardin.getNumTel());
            e.setAdresse(jardin.getAdresse());           
           
            return jardinRepository.save(jardin) != null;
        });
	}
	
	@Override
	public Optional<Jardin> findJardinById(int id){
		return jardinRepository.findById(id);
	}
	@Override
	public Jardin findByEmail(String email) {
		Jardin jardin = jardinRepository.findByEmail(email);
		return jardin;
	}
	


}
