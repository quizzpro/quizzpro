package quizzpro.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import quizzpro.app.model.user;

import java.util.List;

@Repository
public interface userRepository extends JpaRepository<user, Long> {
	
    List<user> findByStatutAndType(int statut, String type);

    List<user> findByStatut(int statut);

    List<user> findByType(String type);
}
