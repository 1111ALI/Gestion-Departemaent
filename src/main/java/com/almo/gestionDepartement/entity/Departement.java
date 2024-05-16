package com.almo.gestionDepartement.entity;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Departement {
    @Id
    @GeneratedValue
    private UUID departementId;
    private String nomDepartement;
    private String nomChefDepartement;
    private int nombreEnseignant;
    private int nombreEtudiant;
    private int nombreFiliere;
    private String telephone;
    private String email;


}
