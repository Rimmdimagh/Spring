package tn.esprit.universiteproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.universiteproject.entities.Bloc;

import java.util.List;
@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {

    @Query("select b from Bloc b where b.foyer.universite.idUniversite=:idUniversite ")
    List<Bloc> findbyFoyerUniversiteId(@Param("idUniversite") long idUniversite);

}
