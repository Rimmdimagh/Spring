package tn.esprit.universiteproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.universiteproject.entities.Foyer;
@Repository
public interface FoyerRepository extends JpaRepository<Foyer,Long>{
}
