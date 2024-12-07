package isetb.pi.quizzproo.repositry;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import isetb.pi.quizzproo.entities.responsablerh;
import isetb.pi.quizzproo.entities.responsablerh.Statut;


@Repository
public interface responsablerhRepository extends JpaRepository <responsablerh,Long> {

	List<responsablerh> findByStatut(Statut statut);



}





