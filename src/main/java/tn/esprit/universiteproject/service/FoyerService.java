package tn.esprit.universiteproject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.universiteproject.entities.Foyer;
import tn.esprit.universiteproject.entities.Universite;
import tn.esprit.universiteproject.repository.FoyerRepository;
import tn.esprit.universiteproject.repository.UniversiteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerService implements IFoyerService{

FoyerRepository foyerRepository;
UniversiteRepository universiteRepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return  foyerRepository.findAll();

    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f, Long id) {
        if(foyerRepository.existsById(id)){
            f.setIdFoyer(id);
            return foyerRepository.save(f);
        }
        else
            return null;
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    //si il existe on va l archiver
    public void archiverFoyer(Long idFoyer) {
Foyer foyer=foyerRepository.findById(idFoyer).orElse(null);
if(foyer!=null){
    foyer.setArchived(true);
    foyerRepository.save(foyer);
}
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite) {
        Universite universite=universiteRepository.findById(idUniversite).orElse(null);
if(universite!=null){
foyer.setUniversite(universite);
Foyer addFoyer=foyerRepository.save(foyer);
return  addFoyer;
}
return  null;
    }


}
