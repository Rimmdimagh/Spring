package tn.esprit.universiteproject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.universiteproject.entities.Chambre;
import tn.esprit.universiteproject.entities.Reservation;
import tn.esprit.universiteproject.repository.ChambreRepository;
import tn.esprit.universiteproject.repository.ReservationRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    ReservationRepository reservationRepository;
    ChambreRepository chambreRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaire(Date date) {
        return reservationRepository.findByAnneUniversitaire(date);
    }
/*
    @Override
    public Reservation ajouterReservation(Long idChambre, Long cin) {
        //on l'ajoute selon chambre
        Chambre chambre=chambreRepository.findById(idChambre).orElse(null);
        if(chambre!=null){
            Reservation nouvelleReservation = new Reservation();
            nouvelleReservation.setIdReservation(cin);

            // Récupérer la liste des réservations de la chambre
            List<Reservation> reservations = chambre.getReservations();


            // Ajouter la nouvelle réservation à la liste des réservations de la chambre
            reservations.add(nouvelleReservation);
            // Mettre à jour la liste des réservations de la chambre
            chambre.setReservations(reservations);

            // Sauvegarder la chambre mise à jour avec la nouvelle réservation
            chambreRepository.save(chambre);
            return nouvelleReservation;

        }
    }*/

    @Override
    public Reservation annulerReservation(Long cin) {
        Reservation reservation=reservationRepository.findById(cin).orElse(null);
        if(reservation!=null){
            //suppression de la reservation trouvée
            reservationRepository.delete(reservation);
            return  reservation;
        }

else
    return null;
    }
/*
    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversite, String nomUniversite) {

    }*/

}

