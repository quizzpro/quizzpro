package isetb.pi.quizzproo.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isetb.pi.quizzproo.entities.commercial;
import isetb.pi.quizzproo.entities.responsablerh;
import isetb.pi.quizzproo.services.responsablerhService;

//Annotation pour créer des web services REST avec le framework Spring WEB
@RestController

@RequestMapping("/responsablerh") // localhost/responsablerh
@CrossOrigin(origins = "http://localhost:4200")
public class responsablerhcontroller {


	@Autowired
	responsablerhService  responsablerhService;
	
	
	
	//ajouter
		@PostMapping("/addresp")
		public responsablerh createResponsablerh(@RequestBody responsablerh responsablerh){
		return responsablerhService.addresponsablerh(responsablerh);
		}
		
		

}
