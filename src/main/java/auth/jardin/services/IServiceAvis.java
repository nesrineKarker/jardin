package auth.jardin.services;

import java.util.List;
import java.util.Optional;

import auth.jardin.entities.Avis;

public interface IServiceAvis {

	
	public void registerAvis(Avis avis);

	public void deleteAvis(int id);


	public Optional<Avis> findAvisById(int id);

	public List<Avis> getAllAvis();
	public List<Avis> findByJardinId(int id);


}
