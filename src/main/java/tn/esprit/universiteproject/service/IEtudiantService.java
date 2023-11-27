package tn.esprit.universiteproject.service;

import tn.esprit.universiteproject.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant addEtudiant (Etudiant etudiant);
    Etudiant updateEtudiant (Etudiant e,Long id);
    Etudiant retrieveEtudiant(long idEtudiant);
    void removeEtudiant(long idEtudiant);
    List<Etudiant> addEtudiants (List<Etudiant> etudiants);


    //Etudiant affecterEtudiantAReservation(String nomEt , String prenomEt , String idReservation );

}
