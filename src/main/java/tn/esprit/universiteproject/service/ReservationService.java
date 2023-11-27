package tn.esprit.universiteproject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.universiteproject.entities.Reservation;
import tn.esprit.universiteproject.repository.ReservationRepository;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {

    ReservationRepository reservationRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaire(Date date) {
        return reservationRepository.findByAnneUniversitaire(date);
    }
}

