package tn.esprit.universiteproject.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.universiteproject.entities.Universite;
import tn.esprit.universiteproject.service.UniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("Universite")
public class UniversiteController {

    UniversiteService universiteService;




    @GetMapping("/retrieveAllUniversities")
    public List<Universite>retrieveAllUniversities(){
        return universiteService.retrieveAllUniversities();
    }


//http://localhost:8082/tp-spring/Universite/addUniversity

    @PostMapping("/addUniversity")

    public Universite addUniversity(@RequestBody Universite u){
        return universiteService.addUniversity(u);
    }

//http://localhost:8082/tp-spring/Universite/updateUniversity/1

    @PutMapping("/updateUniversity/{id}")
    public Universite updateUniversity(@RequestBody Universite u,@PathVariable Long id){
        return universiteService.updateUniversity(u,id);
    }



//http://localhost:8082/tp-spring/Universite/retrieveUniversity/1
    @GetMapping("/retrieveUniversity/{id}")
    public Universite retrieveUniversity(@PathVariable Long id){


        return  universiteService.retrieveUniversity(id);


    }

    //http://localhost:8082/tp-spring/Universite/removeUniversity/1
    @DeleteMapping("/removeUniversity/{id}")
    public void removeUniversity(@PathVariable Long id) {

        universiteService.removeUniversity(id);
    }





    //http://localhost:8082/tp-spring/Universite/affecter_foyer_au_universite/1/nomUniversite
@PutMapping("/affecter_foyer_au_universite/{idFoyer}/{nomUniversite}")
public Universite affecterFoyerAUniversite(@PathVariable Long idFoyer,@PathVariable String nomUniversite){
return universiteService.affecterFoyerAUniversite(idFoyer,nomUniversite);
}

//http://localhost:8082/tp-spring/Universite/DésAffectation_foyer_universite/idUniversite
@PutMapping("/DésAffectation_foyer_universite/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable Long idUniversite){
return universiteService.desaffecterFoyerAUniversite(idUniversite);
}



}
