package tn.esprit.universiteproject.service;

import tn.esprit.universiteproject.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    Reservation addReservation (Reservation reservation);
    List<Reservation> getReservationParAnneeUniversitaire(Date date );
}
