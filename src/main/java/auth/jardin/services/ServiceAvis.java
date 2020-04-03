package auth.jardin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import auth.jardin.entities.Avis;
import auth.jardin.repositories.AvisRepository;
@Service
public class ServiceAvis implements IServiceAvis {
	
	@Autowired
	private AvisRepository avisRepo;

	@Override
	public void registerAvis(Avis avis) {
		avisRepo.save(avis);
	}

	@Override
	public void deleteAvis(int id) {
		avisRepo.deleteById(id);
	}

	@Override
	public Optional<Avis> findAvisById(int id) {
		return avisRepo.findById(id);
	}

	@Override
	public List<Avis> getAllAvis() {
		return avisRepo.findAll();
	}

	@Override
	public List<Avis> findByJardinId(int id) {
		return avisRepo.findByJardinId(id);
	}

}
