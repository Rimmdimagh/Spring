package tn.esprit.universiteproject.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.universiteproject.entities.Chambre;
import tn.esprit.universiteproject.entities.Etudiant;
import tn.esprit.universiteproject.service.ChambreService;
import tn.esprit.universiteproject.service.IEtudiantService;

import java.util.List;



@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("Etudiant")
public class EtudiantController {

    IEtudiantService etudiantService;

    //http://localhost:8082/tp-spring/Etudiant/retrieve_all_etudiant
                           //servelet        //nom controller je l'ai appelee avec @RequestMapping("Etudiant")
    @GetMapping("/retrieve_all_etudiant")
    public List<Etudiant> GetEtudiant(){
        List<Etudiant>ListEtudiant=(List<Etudiant>) etudiantService.retrieveAllEtudiants();
        return ListEtudiant;
    }

    //http://localhost:8082/tp-spring/Etudiant/addEtudiant
    //ajouter
    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e){
return etudiantService.addEtudiant(e);
    }
//retrieve etudiant
    @GetMapping("/retrieve_etudiant/{idEtudiant}")
    public Etudiant retrieveEtudiant(@PathVariable ("idEtudiant")Long idEtudiant)
    {
return etudiantService.retrieveEtudiant(idEtudiant);
    }


    //update
    @PutMapping("/updateEtudiant/{id}")
    public Etudiant updateEtudiant(@RequestBody Etudiant e ,@PathVariable("id")Long id){
        Etudiant etudiant= etudiantService.updateEtudiant(e,id);

        return etudiant;
    }

    //ajouter avec une liste
    @PostMapping("/addEtudiants")
    //hedhy heya nfsha eli mwjouda fel interface w service juste bel annotation
    public List<Etudiant> addEtudiants(@RequestBody List<Etudiant> etudiants){
     return etudiantService.addEtudiants(etudiants);

    }
    @DeleteMapping("/removeEtudiant/{id}")
    public void removeEtudiant(@PathVariable("id")Long id){
        etudiantService.removeEtudiant(id);
    }



}
