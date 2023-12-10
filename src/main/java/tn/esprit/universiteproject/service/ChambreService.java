package tn.esprit.universiteproject.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;
import tn.esprit.universiteproject.entities.Bloc;
import tn.esprit.universiteproject.entities.Chambre;
import tn.esprit.universiteproject.entities.Etudiant;
import tn.esprit.universiteproject.entities.TypeChambre;
import tn.esprit.universiteproject.repository.BlocRepository;
import tn.esprit.universiteproject.repository.ChambreRepository;
import tn.esprit.universiteproject.repository.ReservationRepository;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Service
@AllArgsConstructor

public class ChambreService implements  IChambreService{


    ChambreRepository chambreRepository;
    BlocRepository blocRepository;
    ReservationRepository reservationRepository;


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


    @Scheduled(fixedDelay = 5000)
    public void listeChambresParBloc() {
        // Récupérer tous les blocs

      List<Bloc>blocs=blocRepository.findAll();
      for (Bloc bloc : blocs)
      {
          String nomBloc=bloc.getNomBloc();
          List<Chambre> chambres = chambreRepository.findByBloc_NomBloc(nomBloc);

          System.out.println("Liste des chambres pour le bloc " + nomBloc + ":");
          for (Chambre chambre : chambres) {
              System.out.println("Chambre ID: " + chambre.getIdChambre() + ", Type: " + chambre.getTypeC());

          }


      }
    }
    @Scheduled(fixedDelay = 60000)
    public void pourcentageChambresParTypeChambre() {
        List<TypeChambre>typeChambres= Arrays.asList(TypeChambre.values());
        long totalChambres = chambreRepository.count();
        for (TypeChambre type : typeChambres) {

            long countByType = chambreRepository.countByTypeC(type);
            // Calcul du pourcentage
            double pourcentage = (countByType / (double) totalChambres) * 100;
            System.out.println("Pourcentage de chambres de type " + type + " : " + pourcentage + "%");
        }
    }
    @Scheduled(cron = "0 0 0 * * ?")// Exécution tous les jours à minuit
    public void nbPlacesDisponiblesParChambreAnneeEnCours() {
        // Récupérer l'année en cours
        Calendar calendrier = Calendar.getInstance();
        int anneeEnCours = calendrier.get(Calendar.YEAR);
// Récupérer liste  des chambres
        List<Chambre> chambres = chambreRepository.findAll();
        for (Chambre c : chambres) {
            // Récupérer le nombre de réservations pour l'année en cours pour chaque chambre

            Long nbReservations = c.getReservations()
                    .stream()
                    .filter(reservation -> reservation.getAnneUniversitaire().getYear() == anneeEnCours)
                    .count();
            // Calculer le nombre de places disponibles par chambre pour l'année en cours
            long capaciteChambre = c.getBloc().getCaapciteBloc();
            int placesDisponibles = (int) (capaciteChambre - nbReservations.intValue());

            System.out.println("Chambre ID: " + c.getIdChambre() + ", Places disponibles pour l'année en cours: " + placesDisponibles);

        }

    }}

