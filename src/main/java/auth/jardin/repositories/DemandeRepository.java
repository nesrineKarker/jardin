package auth.jardin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import auth.jardin.entities.Demande;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Integer>{
	Demande findByJardinId(@Param("id") int id);

}
