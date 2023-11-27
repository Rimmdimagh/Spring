package tn.esprit.universiteproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.universiteproject.entities.Reservation;

import java.util.Date;
import java.util.List;
@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    List< Reservation> findByAnneUniversitaire(Date anu);
}
