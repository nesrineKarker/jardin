package auth.jardin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auth.jardin.entities.Demande;
import auth.jardin.repositories.DemandeRepository;
@Service(value = "demandeService")
public class ServiceDemande implements IServiceDemande{
	@Autowired
	private DemandeRepository demandeRepo;
	
	@Override
	public void registerDemande(Demande demande) {
		
		demandeRepo.save(demande);
	}

	@Override
	public void deleteDemande(int id) {
		demandeRepo.deleteById(id);
	}

	@Override
	public Optional<Demande> findDemandeById(int id) {
		return demandeRepo.findById(id);
	}
	
	@Override
	public Demande findByJardinId(int id) {
		return demandeRepo.findByJardinId(id);
	}


	@Override
	public List<Demande> getAllDemande() {
		return demandeRepo.findAll();
	}

}
