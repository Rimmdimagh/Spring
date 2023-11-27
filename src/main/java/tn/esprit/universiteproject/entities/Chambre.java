package tn.esprit.universiteproject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Chambre implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idChambre;
    private long numeroChambre;
    private TypeChambre typeC;


    @OneToMany
    private Set<Reservation> reservations;
    @ManyToOne
    private Bloc bloc;
}
