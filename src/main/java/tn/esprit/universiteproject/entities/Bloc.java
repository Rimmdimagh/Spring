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
public class Bloc implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idBloc;
    private String nomBloc;
    private long caapciteBloc;
    //classe fils
    @ManyToOne
    private Foyer foyer;
//CLASSE Parent
@OneToMany(mappedBy = "bloc")
private Set<Chambre> chambres;



}
