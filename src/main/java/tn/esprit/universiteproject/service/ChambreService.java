package tn.esprit.universiteproject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.universiteproject.entities.Bloc;
import tn.esprit.universiteproject.entities.Chambre;
import tn.esprit.universiteproject.entities.Etudiant;
import tn.esprit.universiteproject.entities.TypeChambre;
import tn.esprit.universiteproject.repository.BlocRepository;
import tn.esprit.universiteproject.repository.ChambreRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ChambreService implements  IChambreService{

    ChambreRepository chambreRepository;


    @Override
    public  List<Chambre> retrieveAllChambre() {
        return chambreRepository.findAll();
    }


    @Override
    public List<Chambre> addChambres(List<Chambre> blocs) {
        return chambreRepository.saveAll(blocs);
    }



    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        return chambreRepository.findByBloc_nomBloc(nomBloc);
    }
/*
    @Override
    public Long nbrChambreParTypeEtBloc(TypeChambre typeChambre, Long idBloc) {
        return chambreRepository.countByTypeCAndBlocs_Id(typeChambre,idBloc);
    }*/
}
