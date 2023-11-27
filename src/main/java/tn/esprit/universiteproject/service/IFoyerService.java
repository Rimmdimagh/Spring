package tn.esprit.universiteproject.service;

import tn.esprit.universiteproject.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer (Foyer f);
    Foyer updateFoyer (Foyer f, Long id);
    Foyer retrieveFoyer (Long idFoyer);
    void archiverFoyer (Long idFoyer);
    // Ajoutez un attribut boolean archived dans l'entité Foyer, par défault false et le modifier à true suite à l'exécution de ce service

//ajouter à la fois un Foyer ses blocs associés et l’affecter à une université
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}
