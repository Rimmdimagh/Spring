package tn.esprit.universiteproject.service;

import tn.esprit.universiteproject.entities.Etudiant;
import tn.esprit.universiteproject.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    Reservation addReservation (Reservation reservation);
    List<Reservation> getReservationParAnneeUniversitaire(Date date );
     //Reservation ajouterReservation(Long idChambre, Long cin) ;
     Reservation annulerReservation (Long cin) ;
    // List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite( Date anneeUniversite, String nomUniversite) ;

}
