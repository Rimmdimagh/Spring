package tn.esprit.universiteproject.service;

import tn.esprit.universiteproject.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversities();
    Universite addUniversity (Universite u);
    Universite updateUniversity (Universite u,long id);
    Universite retrieveUniversity (long idUniversity);
    void removeUniversity  (Long idUniversity );
   Universite affecterFoyerAUniversite (long idFoyer, String nomUniversite) ;
    Universite desaffecterFoyerAUniversite (long idUniversite) ;
}
