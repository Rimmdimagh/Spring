package tn.esprit.universiteproject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.universiteproject.entities.Etudiant;
import tn.esprit.universiteproject.entities.Reservation;
import tn.esprit.universiteproject.repository.EtudiantRepository;
import tn.esprit.universiteproject.repository.ReservationRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EtudiantService implements IEtudiantService{

    EtudiantRepository etudiantRepository;
    ReservationRepository reservationRepository;


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
/*
    @Override
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation) {
Etudiant etudiant=etudiantRepository.findByNomEtAndPrenomEt(prenomEt,nomEt);
        Reservation reservation=reservationRepository.findById(Long.valueOf(idReservation)).get();


Set<Reservation> reservations=new ArrayList<>();
if(etudiant.getReservations()!=null)
{
    reservations=etudiant.getReservations();

}
reservations.add(reservation);
        etudiant.setReservations(reservations);
        etudiantRepository.save(etudiant);

        return etudiant;
    }*/
}
