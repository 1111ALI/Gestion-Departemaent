package com.almo.gestionDepartement.dtos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentDto {
    private String prenom;
    private String nom;
    private String matricule;
    private String filiere;
    private String email;
    private String password;
    private String telephone;
}
