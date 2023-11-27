package tn.esprit.universiteproject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idReservation;
   private Date anneUniversitaire;
   private boolean estValide;

    @ManyToMany
    private Set<Etudiant> etudiants;

    @ManyToOne
    private Chambre chambre;

}
