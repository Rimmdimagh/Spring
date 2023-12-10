package tn.esprit.universiteproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.universiteproject.entities.Bloc;
import tn.esprit.universiteproject.entities.Chambre;
import tn.esprit.universiteproject.entities.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre,Long> {

    @Query("select c from Chambre c where c.bloc.idBloc=: idBloc AND c.typeC=tn.esprit.universiteproject.entities.TypeChambre.DOUBLE")
    List<Chambre>findBytypeCDOUBLEAndidBloc(@Param("idBloc")long blocId);

   @Query("select c from  Chambre  c JOIN c.reservations r where r.estValide=:estValide")
    List<Chambre>findByreservationsValide(@Param("estValide")boolean estValide);

    @Query("select c from Chambre c where c.bloc.idBloc = :idBloc AND c.bloc.caapciteBloc > :caapciteBloc")
    List<Chambre> findByidBlocAndCaapciteBlocGreaterThan(@Param("idBloc") long idBloc, @Param("caapciteBloc") long caapciteBloc);



    List<Chambre>findByNumeroChambreIn(List<Long>numeroChambre);


   List<Chambre>findByBloc_nomBloc(String nomBloc);
  Long countByTypeCAndBloc_IdBloc(TypeChambre typeC, Long idBloc);


    List<Chambre> findByBloc_NomBloc(String nomBloc);
    long countByTypeC(TypeChambre typeChambre);

}
