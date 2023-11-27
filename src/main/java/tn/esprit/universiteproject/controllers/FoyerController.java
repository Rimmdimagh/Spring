package tn.esprit.universiteproject.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.universiteproject.entities.Etudiant;
import tn.esprit.universiteproject.entities.Foyer;
import tn.esprit.universiteproject.service.FoyerService;
import tn.esprit.universiteproject.service.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("Foyer")
public class FoyerController {
   IFoyerService foyerService;
//http://localhost:8082/tp-spring/Foyer/retrieve_all_Foyers
    @GetMapping("/retrieve_all_Foyers")
    public List<Foyer>GetFoyers(){
        return foyerService.retrieveAllFoyers();
    }

//http://localhost:8082/tp-spring/Foyer/addFoyer
    @PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer f){
return foyerService.addFoyer(f);
    }


//http://localhost:8082/tp-spring/Foyer/updateFoyer/1
    @PutMapping("/updateFoyer/{idFoyer}")
    public Foyer updateFoyer(@RequestBody Foyer f ,@PathVariable Long idFoyer){
        Foyer foyer= foyerService.updateFoyer(f,idFoyer);
        return foyer;
    }


//http://localhost:8082/tp-spring/Foyer/retrieveFoyer/1
    @GetMapping("/retrieveFoyer/{idFoyer}")
    public  Foyer retrieveFoyer(@PathVariable Long idFoyer){
        return  foyerService.retrieveFoyer(idFoyer);
    }
//http://localhost:8082/tp-spring/Foyer/archiverFoyer/6
    @PutMapping("/archiverFoyer/{idFoyer}")
    public void archiverFoyer(@PathVariable Long idFoyer){
         foyerService.archiverFoyer(idFoyer);
    }
//http://localhost:8082/tp-spring/Foyer/ajouterFoyerEtAffecterAUniversite/2
    @PostMapping("/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer,@PathVariable long idUniversite){
    Foyer addFoyer= foyerService.ajouterFoyerEtAffecterAUniversite(foyer,idUniversite);
    return addFoyer;
    }
}
