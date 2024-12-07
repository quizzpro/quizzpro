package isetb.pi.quizzproo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.status.Status;
import isetb.pi.quizzproo.entities.commercial;
import isetb.pi.quizzproo.entities.responsablerh;

import isetb.pi.quizzproo.repositry.responsablerhRepository;


@Service
public class responsablerhService implements responsablerhServiceInterface {
	
	@Autowired
	private responsablerhRepository  responsablerhRepo;
	
	

	
	
	@Override
	public responsablerh addresponsablerh(responsablerh responsablerh)
	{
		    responsablerh.setStatut(responsablerh.getStatut().INACTIF); 

		    return responsablerhRepo.save(responsablerh);
		}

}