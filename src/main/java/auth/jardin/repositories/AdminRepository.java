package auth.jardin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import auth.jardin.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

}
