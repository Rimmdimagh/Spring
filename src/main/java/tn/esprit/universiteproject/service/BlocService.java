package tn.esprit.universiteproject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.universiteproject.entities.Bloc;
import tn.esprit.universiteproject.entities.Chambre;
import tn.esprit.universiteproject.entities.Foyer;
import tn.esprit.universiteproject.entities.Universite;
import tn.esprit.universiteproject.repository.BlocRepository;
import tn.esprit.universiteproject.repository.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BlocService implements IBlocService{
BlocRepository blocRepository;
ChambreRepository chambreRepository;


    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }
/*
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        Bloc bloc=blocRepository.findById(idBloc).orElse(null);// pour rechercher une université dans la base de données en fonction de son nom (nomUniversite)
        // recherche un foyer dans la base de données en utilisant son ID
        //orElse(null) pour éviter une éventuelle exception si aucun foyer n'est trouvé avec cet ID, retournant ainsi null dans ce cas.
     List<Chambre>chambre=chambreRepository.findByNumeroChambreIn(numChambre);

        for (Chambre ch : chambre) {
            ch.setBloc(bloc);
            chambreRepository.save(ch);

        }
            assert bloc != null;
        //on set le fils dans le parent :fils c est universite ,parent c est le foyer
        bloc.setChambres(chambre);
        blocRepository.save(bloc);
        // sauvegarde les modifications apportées à l'objet universite
        return bloc;
    }*/
}
