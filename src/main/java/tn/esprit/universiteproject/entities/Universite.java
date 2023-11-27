package tn.esprit.universiteproject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.FilePermission;
import java.io.Serializable;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idUniversite;
    private String nomUniversite;
    private String adresse;

    @OneToOne
    private Foyer foyer;

}
