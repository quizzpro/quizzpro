package isetb.pi.quizzproo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import isetb.pi.quizzproo.entities.commercial;
import isetb.pi.quizzproo.entities.responsablerh;
import isetb.pi.quizzproo.entities.responsablerh.Statut;
import isetb.pi.quizzproo.repositry.commercialRepository;

@Service
public class commercialService implements commercialServiceInterface {
   @Autowired
    private  commercialRepository commercialRepo;


    @Override
    public commercial  addcommercial(commercial commercial) {
      
        commercial.setStatut(commercial.getStatut().INACTIF);
        return commercialRepo.save(commercial);
    }


	

  
}
