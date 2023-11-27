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
//seriablizable:introduction entre mon travail et la bd
public class Foyer implements Serializable {
    @Id
//c'est pas obligatoire
    @Column(name="idFoyer")

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idFoyer;

    private String nomFoyer;
    private long capaciteFoyer;
//parent

    @OneToOne(mappedBy = "foyer")
    private Universite universite;

    @OneToMany(mappedBy = "foyer")
    private Set<Bloc>Blocs;
    private boolean archived=false;
}



