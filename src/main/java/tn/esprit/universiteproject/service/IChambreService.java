package tn.esprit.universiteproject.service;

import tn.esprit.universiteproject.entities.Chambre;
import tn.esprit.universiteproject.entities.Etudiant;
import tn.esprit.universiteproject.entities.TypeChambre;
import tn.esprit.universiteproject.entities.Bloc;
import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambre();
    List<Chambre> addChambres (List<Chambre> blocs);



   public List<Chambre> getChambresParNomBloc ( String nomBloc );

  // public Long nbrChambreParTypeEtBloc(TypeChambre typeChambre, Long idBloc );
}
