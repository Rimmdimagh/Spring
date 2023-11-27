package tn.esprit.universiteproject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.universiteproject.entities.Etudiant;
import tn.esprit.universiteproject.repository.EtudiantRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{

    EtudiantRepository etudiantRepository;


    @Override
    public List<Etudiant> retrieveAllEtudiants() {

        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e,Long id) {
        if(etudiantRepository.existsById(id)){
            e.setIdEtudiant(id);
            return etudiantRepository.save(e);
        }
        else
            return null;
    }

    @Override
    public Etudiant retrieveEtudiant(long idEtudiant) {
       return etudiantRepository.findById(idEtudiant).get();
    }

    @Override
    public void removeEtudiant(long idEtudiant) {
etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
       return etudiantRepository.saveAll(etudiants);
    }
}
