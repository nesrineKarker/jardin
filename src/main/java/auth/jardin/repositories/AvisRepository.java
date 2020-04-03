package auth.jardin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import auth.jardin.entities.Avis;
@Repository
public interface AvisRepository extends JpaRepository<Avis, Integer>{
	List<Avis> findByJardinId(@Param("id") int id);
}
