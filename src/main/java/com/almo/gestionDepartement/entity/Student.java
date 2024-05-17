package com.almo.gestionDepartement.entity;

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
public class Student {
    @Id
    @GeneratedValue
    private UUID studentId;
    private String prenom;
    private String nom;
    private String matricule;
    private String filiere;
    private String email;
    private String password;
    private String telephone;

}
