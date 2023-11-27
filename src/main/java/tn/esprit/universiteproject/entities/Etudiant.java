package tn.esprit.universiteproject.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder//DANS  COURS LAMBOK
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant implements Serializable {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private long idEtudiant;
private String nomEt;
private  String  prenomEt;
private long cin;
private  String ecole;
private Date dateNaissance;

    @ManyToMany(mappedBy="etudiants")
    private Set<Reservation> reservations;


}
