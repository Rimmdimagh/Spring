package tn.esprit.universiteproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.universiteproject.entities.Universite;
@Repository
public interface UniversiteRepository extends JpaRepository<Universite,Long> {
    Universite findByNomUniversite(String nomUniversite);
    Universite findByidUniversite(Long id);
}
