package auth.jardin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import auth.jardin.entities.*;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long>  {
	
	ConfirmationToken findByConfirmationToken(String confirmationToken);
	
	ConfirmationToken findByJardin( Jardin jardin);
	
}
