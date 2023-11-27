package tn.esprit.universiteproject.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.universiteproject.entities.Foyer;
import tn.esprit.universiteproject.entities.Universite;
import tn.esprit.universiteproject.repository.FoyerRepository;
import tn.esprit.universiteproject.repository.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService{

UniversiteRepository universiteRepository;
FoyerRepository foyerRepository;
    @Override
    public List<Universite> retrieveAllUniversities() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversity(Universite u) {
       return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversity(Universite u,long id) {
        if(universiteRepository.existsById(id)){
            u.setIdUniversite(id);
            return universiteRepository.save(u);
        }
        else  return null;
    }

    @Override
    public Universite retrieveUniversity(long idUniversity) {
        return universiteRepository.findById(idUniversity).get();
    }

    @Override
    public void removeUniversity(Long idUniversity) {
universiteRepository.deleteById(idUniversity);
    }



    //affecter un Foyer à une Universite.
    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite)
    {

     Universite universite=universiteRepository.findByNomUniversite(nomUniversite);// pour rechercher une université dans la base de données en fonction de son nom (nomUniversite)
        // recherche un foyer dans la base de données en utilisant son ID
        //orElse(null) pour éviter une éventuelle exception si aucun foyer n'est trouvé avec cet ID, retournant ainsi null dans ce cas.
     Foyer foyer=foyerRepository.findById(idFoyer).orElse(null);
     //on set le fils dans le parent :fils c est universite ,parent c est le foyer
     universite.setFoyer(foyer);
     // sauvegarde les modifications apportées à l'objet universite
     return  universiteRepository.save(universite);
    }


    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        //rechercher une université dans la base de données en fonction de son ID (idUniversite)
        // Si aucune université correspondante n'est trouvée, la valeur null
        Universite universite=universiteRepository.findById(idUniversite).orElse(null);
//assert vérifie si l'université trouvée précédemment n'est pas nulle
assert universite != null;
//université ne sera plus associée à aucun foyer
universite.setFoyer(null);
//sauvegarde les modifications apportées à l'objet universite
return universiteRepository.save(universite);

    }


}
