package isetb.pi.quizzproo.repositry;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import isetb.pi.quizzproo.entities.commercial;
import isetb.pi.quizzproo.entities.responsablerh.Statut;

@Repository

public interface commercialRepository extends JpaRepository<commercial,Long>{
	List<commercial> findByStatut(Statut statut);
	
	
}
