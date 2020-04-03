package auth.jardin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import auth.jardin.entities.Jardin;

public interface JardinRepository extends JpaRepository<Jardin, Integer>{
	@Query("SELECT j FROM Jardin j WHERE j.email=:email")
	Jardin findByEmail(@Param("email") String email);
	
	
	
}
