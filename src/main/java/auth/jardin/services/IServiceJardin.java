package auth.jardin.services;

import java.util.List;
import java.util.Optional;

import auth.jardin.entities.Jardin;

public interface IServiceJardin {

	public void registerJardin(Jardin jardin);

	public void deleteJardin(int id);

	public Optional<Jardin> updateJardin(Jardin jardin);

	public Optional<Jardin> findJardinById(int id);

	public List<Jardin> getAllJardin();

	public Jardin findByEmail(String email);


}
