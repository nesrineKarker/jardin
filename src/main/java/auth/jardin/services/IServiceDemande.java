package auth.jardin.services;

import java.util.List;
import java.util.Optional;

import auth.jardin.entities.Demande;

public interface IServiceDemande {
	
	public void registerDemande(Demande demande);

	public void deleteDemande(int id);


	public Optional<Demande> findDemandeById(int id);

	public List<Demande> getAllDemande();

	public Demande findByJardinId(int id);
	

}
