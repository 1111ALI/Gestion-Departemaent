package com.almo.gestionDepartement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Filiere {
    @Id
    @GeneratedValue
    private UUID filiereId;
    private String nomFiliere;
    private int nombreDiscipline;
    private int nombreEnseignant;
    private int nombreEtudiant;
    private List<String> discipline;

}
