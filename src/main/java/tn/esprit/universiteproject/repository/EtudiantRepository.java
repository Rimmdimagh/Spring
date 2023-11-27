package tn.esprit.universiteproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.universiteproject.entities.Etudiant;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long>{
    Etudiant findByNomEtAndPrenomEt(String nomEt,String prenomEt);

}
