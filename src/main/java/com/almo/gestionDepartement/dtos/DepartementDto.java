package com.almo.gestionDepartement.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartementDto {

    private String nomDepartement;
    private String nomChefDepartement;
    private int nombreEnseignant;
    private int nombreEtudiant;
    private int nombreFiliere;
    private String telephone;
    private String email;
}
