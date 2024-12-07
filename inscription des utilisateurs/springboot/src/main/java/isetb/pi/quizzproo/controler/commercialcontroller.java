package isetb.pi.quizzproo.controler;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isetb.pi.quizzproo.entities.commercial;
import  isetb.pi.quizzproo.services.commercialService;




@RestController
@RequestMapping("/commercial") 
@CrossOrigin(origins = "http://localhost:4200")
public class commercialcontroller{
	
@Autowired
commercialService  commercialService;




@PostMapping("/add")
public commercial createCommercial(@RequestBody commercial commercial){
return commercialService.addcommercial(commercial);
}


}

