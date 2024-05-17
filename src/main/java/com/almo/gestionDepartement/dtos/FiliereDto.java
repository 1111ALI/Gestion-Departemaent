package com.almo.gestionDepartement.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FiliereDto {
    @Id
    @GeneratedValue
    private String nomFiliere;
    private int nombreDiscipline;
    private int nombreEnseignant;
    private int nombreEtudiant;
    private List<String> discipline;
}
